package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener {

    JButton exit;
    JLabel info, cardNumberLabel, balanceLabel;
    String pinnumber;

    Color darkBlue = new Color(20, 42, 74);
    Color blue = new Color(37, 99, 235);
    Color lightBlue = new Color(239, 246, 255);
    Color textDark = new Color(31, 41, 55);
    Color gray = new Color(107, 114, 128);
    Color green = new Color(22, 163, 74);
    Color red = new Color(220, 38, 38);

    Ministatement(String pin) {

        this.pinnumber = pin;

        setTitle("Mini Statement - Bank Management System");
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

        JLabel statementTitle = new JLabel("MINI STATEMENT");
        statementTitle.setFont(new Font("Arial", Font.BOLD, 18));
        statementTitle.setForeground(Color.WHITE);
        statementTitle.setHorizontalAlignment(SwingConstants.CENTER);
        statementTitle.setBounds(35, 220, 190, 35);
        sidebar.add(statementTitle);

        JLabel statementInfo = new JLabel("<html><center>View your recent<br>account transactions</center></html>");
        statementInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        statementInfo.setForeground(new Color(190, 205, 225));
        statementInfo.setHorizontalAlignment(SwingConstants.CENTER);
        statementInfo.setBounds(30, 270, 200, 55);
        sidebar.add(statementInfo);

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

        JLabel heading = new JLabel("Mini Statement");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(textDark);
        heading.setBounds(55, 35, 400, 40);
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Review your recent account transactions");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(gray);
        subtitle.setBounds(58, 78, 450, 25);
        mainPanel.add(subtitle);

        JPanel accountCard = new JPanel();
        accountCard.setBounds(55, 115, 730, 90);
        accountCard.setBackground(Color.WHITE);
        accountCard.setLayout(null);
        accountCard.setBorder(new RoundedBorder(1,new Color(225, 229, 235),18));
        mainPanel.add(accountCard);

        JLabel accountLabel = new JLabel("ACCOUNT");
        accountLabel.setFont(new Font("Arial", Font.BOLD, 11));
        accountLabel.setForeground(gray);
        accountLabel.setBounds(25, 15, 100, 20);
        accountCard.add(accountLabel);

        cardNumberLabel = new JLabel("Card Number: Loading...");
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cardNumberLabel.setForeground(textDark);
        cardNumberLabel.setBounds(25, 38, 350, 30);
        accountCard.add(cardNumberLabel);

        JLabel balanceText = new JLabel("AVAILABLE BALANCE");
        balanceText.setFont(new Font("Arial", Font.BOLD, 11));
        balanceText.setForeground(gray);
        balanceText.setBounds(450, 15, 180, 20);
        accountCard.add(balanceText);

        balanceLabel = new JLabel("₹0");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(green);
        balanceLabel.setBounds(450, 38, 240, 30);
        accountCard.add(balanceLabel);

        JPanel transactionCard = new JPanel();
        transactionCard.setBounds(55, 225, 730, 300);
        transactionCard.setBackground(Color.WHITE);
        transactionCard.setLayout(null);
        transactionCard.setBorder(new RoundedBorder(1,new Color(225, 229, 235),18));
        mainPanel.add(transactionCard);

        JLabel transactionHeading = new JLabel("TRANSACTION HISTORY");
        transactionHeading.setFont(new Font("Arial", Font.BOLD, 16));
        transactionHeading.setForeground(textDark);
        transactionHeading.setBounds(25, 15, 250, 25);
        transactionCard.add(transactionHeading);

        JLabel transactionSub = new JLabel("Latest transactions from your account");
        transactionSub.setFont(new Font("Arial", Font.PLAIN, 12));
        transactionSub.setForeground(gray);
        transactionSub.setBounds(25, 40, 300, 20);
        transactionCard.add(transactionSub);

        JLabel dateHeader = new JLabel("DATE");
        dateHeader.setFont(new Font("Arial", Font.BOLD, 11));
        dateHeader.setForeground(gray);
        dateHeader.setBounds(25, 72, 180, 20);
        transactionCard.add(dateHeader);

        JLabel typeHeader = new JLabel("TRANSACTION");
        typeHeader.setFont(new Font("Arial", Font.BOLD, 11));
        typeHeader.setForeground(gray);
        typeHeader.setBounds(215, 72, 150, 20);
        transactionCard.add(typeHeader);

        JLabel amountHeader = new JLabel("AMOUNT");
        amountHeader.setFont(new Font("Arial", Font.BOLD, 11));
        amountHeader.setForeground(gray);
        amountHeader.setBounds(575, 72, 100, 20);
        transactionCard.add(amountHeader);

        info = new JLabel();
        info.setVerticalAlignment(JLabel.TOP);
        info.setFont(new Font("Arial", Font.PLAIN, 12));
        info.setBorder(null);

        JScrollPane scrollPane = new JScrollPane(info);
        scrollPane.setBounds(20, 95, 690, 170);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        transactionCard.add(scrollPane);

        exit = new JButton("BACK TO DASHBOARD");
        exit.setFont(new Font("Arial", Font.BOLD, 13));
        exit.setForeground(Color.WHITE);
        exit.setBackground(darkBlue);
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setBounds(55, 550, 730, 45);
        exit.addActionListener(this);
        mainPanel.add(exit);

        loadCardNumber();
        loadTransactions();

        setVisible(true);
    }

    private void loadCardNumber() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT cardnumber FROM login WHERE pin = '"+ pinnumber + "'");
            if (rs.next()) {
                String card = rs.getString("cardnumber");
                if (card != null && card.length() >= 16) {
                    String maskedCard =card.substring(0, 4)+ " XXXX XXXX "+ card.substring(12);
                    cardNumberLabel.setText("Card Number: " + maskedCard);
                } else {
                    cardNumberLabel.setText("Card Number: " + card);
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            cardNumberLabel.setText("Card Number: Not Available");
        }
    }

    private void loadTransactions() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+ pinnumber+ "' ORDER BY STR_TO_DATE(date, "+ "'%a %b %d %H:%i:%s IST %Y') DESC");
            StringBuilder statement =new StringBuilder("<html>");
            int balance = 0;
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawl") || type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount;
                }
                String displayDate = formatDate(date);
                String amountText;
                if (type.equalsIgnoreCase("Deposit")) {
                    amountText ="<font color='green'>+ ₹"+ String.format("%,d", amount)+ "</font>";
                } else {
                    amountText ="<font color='red'>- ₹"+ String.format("%,d", amount)+ "</font>";
                }
                statement.append("<table width='660'>" + "<tr>" + "<td width='185'>" + displayDate + "</td>" + "<td width='345'>" + type + "</td>" + "<td width='130' align='right'>" + amountText + "</td>" + "</tr>" + "</table>" + "<hr color='#eeeeee'>");
            }
            statement.append("</html>");
            info.setText(statement.toString());
            balanceLabel.setText("₹" + String.format("%,d", balance));
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            info.setText("<html><font color='gray'>"+ "No transaction history available."+ "</font></html>");
            balanceLabel.setText("₹0");
        }
    }

    private String formatDate(String date) {
        if (date == null) {
            return "";
        }
        try {
            if (date.length() > 20) {
                return date.substring(0, 20);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
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

    public static void main(String[] args) 
    {
        new Ministatement("");
    }
}
