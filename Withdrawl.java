package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdrawl, back;
    JTextField amount;
    String pinnumber;

    Withdrawl(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);

        JLabel info1 = new JLabel("MAXIMUM WITHDRAWAL IS RS. 10,000");
        info1.setFont(new Font("Raleway", Font.BOLD, 13));
        info1.setForeground(Color.WHITE);
        info1.setBounds(180, 240, 300, 20);
        label.add(info1);

        JLabel info2 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        info2.setFont(new Font("Raleway", Font.BOLD, 14));
        info2.setForeground(Color.WHITE);
        info2.setBounds(145, 280, 350, 20);
        label.add(info2);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setBounds(145, 315, 300, 25);
        label.add(amount);

        withdrawl = new JButton("WITHDRAW");
        withdrawl.setBounds(310, 425, 143, 25);
        withdrawl.addActionListener(this);
        label.add(withdrawl);

        back = new JButton("BACK");
        back.setBounds(310, 455, 143, 25);
        back.addActionListener(this);
        label.add(back);

        setLayout(null);
        setSize(800, 730);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        } else if (ae.getSource() == withdrawl) {

            String number = amount.getText().trim();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount.");
                return;
            }

            int amt;

            try {
                amt = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                return;
            }

            if (amt <= 0) {
                JOptionPane.showMessageDialog(null, "Amount must be greater than zero.");
                return;
            }

            if (amt > 10000) {
                JOptionPane.showMessageDialog(null, "Maximum withdrawal limit is Rs. 10,000.");
                return;
            }

            try {

                Conn c = new Conn();

                int balance = 0;

                ResultSet rs = c.s.executeQuery(
                        "select * from bank where pin = '" + pinnumber + "'");

                while (rs.next()) {

                    String type = rs.getString("type");
                    int transactionAmount = Integer.parseInt(rs.getString("amount"));

                    if (type.equalsIgnoreCase("Deposit")) {
                        balance += transactionAmount;
                    } else if (type.equalsIgnoreCase("Withdrawl")
                            || type.equalsIgnoreCase("Withdrawal")) {
                        balance -= transactionAmount;
                    }
                }

                if (balance < amt) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                    return;
                }

                Date date = new Date();

                String query = "insert into bank values('"
                        + pinnumber + "','"
                        + date + "','Withdrawl','"
                        + amt + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,
                        "Rs. " + amt + " Withdrawn Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Withdrawl w = new Withdrawl("");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}