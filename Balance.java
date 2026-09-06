package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    JLabel balanceLabel;

    Color darkBlue = new Color(20, 42, 74);
    Color blue = new Color(37, 99, 235);
    Color green = new Color(22, 163, 74);
    Color textDark = new Color(31, 41, 55);
    Color gray = new Color(107, 114, 128);
    Color lightGreen = new Color(240, 253, 244);

    Balance(String pinnumber) {

        this.pinnumber = pinnumber;

        setTitle("Account Balance - Bank Management System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(248, 250, 252));

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 260, 650);
        sidebar.setBackground(darkBlue);
        sidebar.setLayout(null);
        add(sidebar);

        JLabel bankTitle = new JLabel("<html><center>BANK<br>MANAGEMENT<br>SYSTEM</center></html>");
        bankTitle.setFont(new Font("Arial", Font.BOLD, 25));
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bankTitle.setBounds(20, 45, 220, 110);
        sidebar.add(bankTitle);

        JLabel line = new JLabel();
        line.setBackground(new Color(60, 82, 112));
        line.setOpaque(true);
        line.setBounds(35, 175, 190, 1);
        sidebar.add(line);

        JLabel balanceTitle = new JLabel("ACCOUNT BALANCE");
        balanceTitle.setFont(new Font("Arial", Font.BOLD, 18));
        balanceTitle.setForeground(Color.WHITE);
        balanceTitle.setHorizontalAlignment(SwingConstants.CENTER);
        balanceTitle.setBounds(35, 220, 190, 35);
        sidebar.add(balanceTitle);

        JLabel balanceInfo = new JLabel("<html><center>Check your current<br>account balance</center></html>");
        balanceInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        balanceInfo.setForeground(new Color(190, 205, 225));
        balanceInfo.setHorizontalAlignment(SwingConstants.CENTER);
        balanceInfo.setBounds(30, 270, 200, 55);
        sidebar.add(balanceInfo);

        JLabel secure = new JLabel("SECURE BANKING");
        secure.setFont(new Font("Arial", Font.BOLD, 12));
        secure.setForeground(new Color(150, 175, 205));
        secure.setHorizontalAlignment(SwingConstants.CENTER);
        secure.setBounds(35, 570, 190, 25);
        sidebar.add(secure);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(260, 0, 840, 650);
        mainPanel.setBackground(new Color(248, 250, 252));
        mainPanel.setLayout(null);
        add(mainPanel);

        JLabel heading = new JLabel("Account Balance");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(textDark);
        heading.setBounds(55, 45, 400, 40);
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("View your available account balance");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(gray);
        subtitle.setBounds(58, 88, 450, 25);
        mainPanel.add(subtitle);

        JPanel balanceCard = new JPanel();
        balanceCard.setBounds(55, 140, 730, 330);
        balanceCard.setBackground(Color.WHITE);
        balanceCard.setLayout(null);
        balanceCard.setBorder(new RoundedBorder(1,new Color(225, 229, 235),20));
        mainPanel.add(balanceCard);

        JLabel walletIcon = new JLabel("₹");
        walletIcon.setFont(new Font("Arial", Font.BOLD, 34));
        walletIcon.setForeground(blue);
        walletIcon.setHorizontalAlignment(SwingConstants.CENTER);
        walletIcon.setVerticalAlignment(SwingConstants.CENTER);
        walletIcon.setBackground(new Color(239, 246, 255));
        walletIcon.setOpaque(true);
        walletIcon.setBounds(315, 30, 90, 90);
        balanceCard.add(walletIcon);

        JLabel availableLabel = new JLabel("AVAILABLE BALANCE");
        availableLabel.setFont(new Font("Arial", Font.BOLD, 13));
        availableLabel.setForeground(gray);
        availableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        availableLabel.setBounds(180, 135, 360, 25);
        balanceCard.add(availableLabel);

        balanceLabel = new JLabel("₹0");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 38));
        balanceLabel.setForeground(green);
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        balanceLabel.setBounds(100, 160, 530, 55);
        balanceCard.add(balanceLabel);

        JLabel status = new JLabel("Your account is active");
        status.setFont(new Font("Arial", Font.PLAIN, 13));
        status.setForeground(green);
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setBackground(lightGreen);
        status.setOpaque(true);
        status.setBounds(245, 225, 240, 35);
        balanceCard.add(status);

        back = new JButton("BACK TO DASHBOARD");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(Color.WHITE);
        back.setBackground(darkBlue);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(55, 500, 730, 50);
        back.addActionListener(this);
        mainPanel.add(back);

        calculateBalance();
        setVisible(true);
    }

    private void calculateBalance() {
        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(
                    "SELECT type, amount FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawl") || type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount;
                }
            }
            rs.close();
            balanceLabel.setText("₹" + String.format("%,d", balance));
        } catch (Exception e) {
            System.out.println(e);
            balanceLabel.setText("₹0");
            JOptionPane.showMessageDialog(this,"Unable to load account balance.","Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    static class RoundedBorder implements javax.swing.border.Border {
        private int thickness;
        private Color color;
        private int radius;

        RoundedBorder(int thickness,Color color,int radius) {
            this.thickness = thickness;
            this.color = color;
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(thickness + 3,thickness + 3,thickness + 3,thickness + 3);
        }
        
        public boolean isBorderOpaque() {
            return false;
        }
        
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
            Graphics2D g2 =(Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x + thickness / 2,y + thickness / 2,width - thickness,height - thickness,radius,radius);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        new Balance("");
    }
}
