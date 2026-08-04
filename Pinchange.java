package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener {
 
    String pinnumber;
    JPasswordField Newpin, Repin;
    JButton change, back;

    Pinchange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);

        JLabel info = new JLabel("CHANGE YOUR PIN");
        info.setFont(new Font("Raleway", Font.BOLD, 17));
        info.setForeground(Color.white);
        info.setBounds(220, 240, 350, 30);
        label.add(info);

        JLabel newpin = new JLabel("NEW PIN:");
        newpin.setFont(new Font("Raleway", Font.BOLD, 15));
        newpin.setForeground(Color.white);
        newpin.setBounds(150, 290, 300, 30);
        label.add(newpin);

        Newpin = new JPasswordField();
        Newpin.setBounds(350, 295, 100, 20);
        Newpin.setFont(new Font("Raleway", Font.BOLD, 15));
        label.add(Newpin);

        JLabel repin = new JLabel("RE-ENTER NEW PIN:");
        repin.setFont(new Font("Raleway", Font.BOLD, 15));
        repin.setForeground(Color.white);
        repin.setBounds(150, 320, 300, 30);
        label.add(repin);

        Repin = new JPasswordField();
        Repin.setBounds(350, 325, 100, 20);
        Repin.setFont(new Font("Raleway", Font.BOLD, 15));
        label.add(Repin);

        change = new JButton("CHANGE");
        change.setBounds(310, 425, 143, 25);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("BACK");
        back.setBounds(310, 455, 143, 25);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.white);
        setSize(800, 730);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = new String(Newpin.getPassword());
                String rpin = new String(Repin.getPassword());

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (!npin.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                    return;
                }

                Conn c = new Conn();

                String checkQuery = "SELECT * FROM login WHERE pin = ? AND pin <> ?";
                PreparedStatement checkPs = c.c.prepareStatement(checkQuery);
                checkPs.setString(1, npin);
                checkPs.setString(2, pinnumber);

                ResultSet rs = checkPs.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,
                            "This PIN is already used by someone else.\nPlease enter another PIN.");
                    return;
                }

                String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                String query2 = "UPDATE login SET pin = ? WHERE pin = ?";
                String query3 = "UPDATE signupthree SET pin = ? WHERE pin = ?";

                PreparedStatement ps1 = c.c.prepareStatement(query1);
                ps1.setString(1, npin);
                ps1.setString(2, pinnumber);

                PreparedStatement ps2 = c.c.prepareStatement(query2);
                ps2.setString(1, npin);
                ps2.setString(2, pinnumber);

                PreparedStatement ps3 = c.c.prepareStatement(query3);
                ps3.setString(1, npin);
                ps3.setString(2, pinnumber);

                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(npin).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        Pinchange p1 = new Pinchange("");
        p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}