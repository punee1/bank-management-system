package bms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String pinnumber;

    Color darkBlue = new Color(8, 30, 68);
    Color blue = new Color(35, 91, 210);
    Color lightBlue = new Color(235, 242, 255);
    Color textColor = new Color(20, 35, 65);
    Color gray = new Color(105, 115, 130);

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Deposit Money");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 251));

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(250, 650));
        sidebar.setBackground(darkBlue);
        sidebar.setLayout(null);

        JLabel bankIcon = new JLabel("₹");
        bankIcon.setFont(new Font("Segoe UI",Font.BOLD,48));
        bankIcon.setForeground(Color.WHITE);
        bankIcon.setHorizontalAlignment(SwingConstants.CENTER);
        bankIcon.setBounds(80,30,90,70);
        sidebar.add(bankIcon);

        JLabel bankName = new JLabel("<html><center>BANK<br>"+ "MANAGEMENT<br>"+ "SYSTEM</center></html>");
        bankName.setFont(new Font("Segoe UI",Font.BOLD,18));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.CENTER);
        bankName.setBounds(25,100,200,85);
        sidebar.add(bankName);

        JPanel separator = new JPanel();
        separator.setBackground(new Color(70,100,160));
        separator.setBounds(30,205,190,2);
        sidebar.add(separator);

        JLabel secure = new JLabel("<html><center>Secure Banking<br>"+ "Transaction</center></html>");
        secure.setFont(new Font("Segoe UI",Font.PLAIN,16));
        secure.setForeground(new Color(190,205,230));
        secure.setHorizontalAlignment(SwingConstants.CENTER);
        secure.setBounds(30,245,190,60);
        sidebar.add(secure);

        JLabel transactionIcon = new JLabel("+");
        transactionIcon.setFont(new Font("Segoe UI", Font.BOLD, 70));
        transactionIcon.setForeground(new Color(80, 150, 240));
        transactionIcon.setHorizontalAlignment(SwingConstants.CENTER);
        transactionIcon.setBounds(70, 340, 110, 90);
        sidebar.add(transactionIcon);

        JLabel bottom =new JLabel("SECURE • SIMPLE • SMART");
        bottom.setFont(new Font("Segoe UI",Font.BOLD,12));
        bottom.setForeground(new Color(140,180,240));
        bottom.setHorizontalAlignment(SwingConstants.CENTER);
        bottom.setBounds(25,555,200,30);
        sidebar.add(bottom);
        mainPanel.add(sidebar,BorderLayout.WEST);

        JPanel content =new JPanel();
        content.setLayout(null);
        content.setBackground(new Color(245,247,251));

        JLabel title =new JLabel("Deposit Money");
        title.setFont(new Font("Segoe UI",Font.BOLD,34));
        title.setForeground(textColor);
        title.setBounds(60,55,500,45);
        content.add(title);
        
        JLabel subtitle = new JLabel("Add money securely to your bank account");
        subtitle.setFont(new Font("Segoe UI",Font.PLAIN,16));
        subtitle.setForeground(gray);
        subtitle.setBounds(63,105,500,30);
        content.add(subtitle);

        JPanel line =new JPanel();
        line.setBackground(blue);
        line.setBounds(63,145,75,4);
        content.add(line);

        JPanel card =new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(225,230,240)));
        card.setBounds(60,185,645,330);
        content.add(card);

        JLabel cardTitle =new JLabel("Enter Deposit Amount");
        cardTitle.setFont(new Font("Segoe UI",Font.BOLD,22));
        cardTitle.setForeground(textColor);
        cardTitle.setBounds(45,35,400,35);
        card.add(cardTitle);

        JLabel cardDescription =new JLabel("Enter the amount you want to deposit");
        cardDescription.setFont(new Font("Segoe UI",Font.PLAIN,14));
        cardDescription.setForeground(gray);
        cardDescription.setBounds(45,72,400,25);
        card.add(cardDescription);

        JLabel rupee =new JLabel("₹");
        rupee.setFont(new Font("Segoe UI",Font.BOLD,25));
        rupee.setForeground(blue);
        rupee.setHorizontalAlignment(SwingConstants.CENTER);
        rupee.setBackground(lightBlue);
        rupee.setOpaque(true);
        rupee.setBounds(45,125,55,55);
        card.add(rupee);

        amount = new JTextField();
        amount.setFont(new Font("Segoe UI",Font.PLAIN,20));
        amount.setForeground(textColor);
        amount.setBounds(115,125,450,55);
        amount.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(new Color(205,215,235),1,15),new EmptyBorder(0,15,0,15)));
        card.add(amount);

        deposit =createButton("DEPOSIT MONEY",darkBlue);
        deposit.setBounds(45,220,250,52);
        card.add(deposit);

        back =createButton("BACK",new Color(90,105,125));
        back.setBounds(315,220,250,52);
        card.add(back);

        JLabel security =new JLabel("🔒  Your transaction is securely processed");
        security.setFont(new Font("Segoe UI Emoji",Font.PLAIN,13));
        security.setForeground(new Color(95,110,125));
        security.setHorizontalAlignment(SwingConstants.CENTER);
        security.setBounds(60,540,645,30);
        content.add(security);

        mainPanel.add(content,BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    private JButton createButton(String text,Color color) {
        JButton button =new JButton(text);
        button.setFont(new Font("Segoe UI",Font.BOLD,14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(new RoundedBorder(color,0,12));
        button.addActionListener(this);
        return button;
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == deposit) {
            String number = amount.getText().trim();
            Date date = new Date();
            if (number.equals("")) {
               JOptionPane.showMessageDialog(this,"Please enter the amount.","Amount Required",JOptionPane.WARNING_MESSAGE);
               return;
            }
            try {
                double value = Double.parseDouble(number);
                if (value <= 0) {
                    JOptionPane.showMessageDialog(this,"Please enter a valid amount.","Invalid Amount",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Conn c = new Conn();
                String query ="insert into bank values('"+ pinnumber+ "', '"+ date+ "', 'Deposit', '"+ number+ "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this,"Rs " + number+ " Deposited Successfully!","Deposit Successful",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Please enter numbers only.","Invalid Amount",JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Database Error: "+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    static class RoundedBorder implements javax.swing.border.Border {
        private Color color;
        private int thickness;
        private int radius;
        RoundedBorder(Color color,int thickness,int radius) {
            this.color = color;
            this.thickness = thickness;
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(8,8,8,8);
        }
        public boolean isBorderOpaque() {
            return false;
        }
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x,y,width - 1,height - 1,radius,radius);
            g2.dispose();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Deposit(""));
    }
}
