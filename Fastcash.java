package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton oneh, fiveh, onet, twot, fivet, tent, exit;
    String pinnumber;

    Color darkBlue = new Color(20, 42, 74);
    Color blue = new Color(37, 99, 235);
    Color lightBlue = new Color(239, 246, 255);
    Color textDark = new Color(31, 41, 55);
    Color gray = new Color(107, 114, 128);

    Fastcash(String pinnumber) {

        this.pinnumber = pinnumber;

        setTitle("Quick Cash - Bank Management System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

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

        JLabel quickCashLabel = new JLabel("QUICK CASH");
        quickCashLabel.setFont(new Font("Arial", Font.BOLD, 18));
        quickCashLabel.setForeground(Color.WHITE);
        quickCashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quickCashLabel.setBounds(35, 220, 190, 35);
        sidebar.add(quickCashLabel);

        JLabel secureLabel = new JLabel("<html><center>Fast and convenient<br>cash withdrawal</center></html>");
        secureLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        secureLabel.setForeground(new Color(190, 205, 225));
        secureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secureLabel.setBounds(30, 270, 200, 55);
        sidebar.add(secureLabel);

        JLabel pinLabel = new JLabel("PIN: " + maskPin(pinnumber));
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        pinLabel.setForeground(new Color(170, 190, 215));
        pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinLabel.setBounds(35, 570, 190, 30);
        sidebar.add(pinLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(260, 0, 840, 650);
        mainPanel.setBackground(new Color(248, 250, 252));
        mainPanel.setLayout(null);
        add(mainPanel);

        JLabel heading = new JLabel("Quick Cash");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(textDark);
        heading.setBounds(55, 45, 350, 40);
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Select an amount to withdraw instantly");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(gray);
        subtitle.setBounds(58, 88, 400, 25);
        mainPanel.add(subtitle);

        JPanel cashCard = new JPanel();
        cashCard.setBounds(55, 135, 730, 425);
        cashCard.setBackground(Color.WHITE);
        cashCard.setLayout(null);
        cashCard.setBorder(new RoundedBorder(1, new Color(225, 229, 235), 20));
        mainPanel.add(cashCard);

        JLabel selectLabel = new JLabel("SELECT WITHDRAWAL AMOUNT");
        selectLabel.setFont(new Font("Arial", Font.BOLD, 17));
        selectLabel.setForeground(textDark);
        selectLabel.setBounds(45, 30, 350, 30);
        cashCard.add(selectLabel);

        JLabel limitLabel = new JLabel("Choose from the available quick cash options");
        limitLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        limitLabel.setForeground(gray);
        limitLabel.setBounds(45, 60, 400, 25);
        cashCard.add(limitLabel);

        oneh = createAmountButton("₹100");
        oneh.setBounds(45, 105, 195, 70);
        cashCard.add(oneh);

        fiveh = createAmountButton("₹500");
        fiveh.setBounds(265, 105, 195, 70);
        cashCard.add(fiveh);

        onet = createAmountButton("₹1,000");
        onet.setBounds(485, 105, 195, 70);
        cashCard.add(onet);

        twot = createAmountButton("₹2,000");
        twot.setBounds(45, 190, 195, 70);
        cashCard.add(twot);

        fivet = createAmountButton("₹5,000");
        fivet.setBounds(265, 190, 195, 70);
        cashCard.add(fivet);

        tent = createAmountButton("₹10,000");
        tent.setBounds(485, 190, 195, 70);
        cashCard.add(tent);

        exit = new JButton("BACK TO DASHBOARD");
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setForeground(Color.WHITE);
        exit.setBackground(darkBlue);
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setBounds(45, 320, 635, 50);
        exit.addActionListener(this);
        cashCard.add(exit);

        setVisible(true);
    }

    private JButton createAmountButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(blue);
        button.setBackground(lightBlue);
        button.setFocusPainted(false);
        button.setBorder(new RoundedBorder(1, new Color(191, 219, 254), 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            return;
        }
        JButton clickedButton = (JButton) ae.getSource();
        String amountText = clickedButton.getText().replace("₹", "").replace(",", "");
        int amount = Integer.parseInt(amountText);
        Conn c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try {
            c = new Conn();
            rs = c.s.executeQuery("SELECT type, amount FROM bank WHERE pin = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) 
            {
                String type = rs.getString("type");
                int transactionAmount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += transactionAmount;
                } else if (type.equalsIgnoreCase("Withdrawl") || type.equalsIgnoreCase("Withdrawal")) {
                    balance -= transactionAmount;
                }
            }
            if (balance < amount) {
                JOptionPane.showMessageDialog(this,"Insufficient Balance\n\nAvailable Balance: ₹"+ String.format("%,d", balance),"Transaction Failed",JOptionPane.WARNING_MESSAGE);
                return;
            }
            Date date = new Date();
            String query ="INSERT INTO bank VALUES (?, ?, ?, ?)";
            ps = c.c.prepareStatement(query);
            ps.setString(1, pinnumber);
            ps.setString(2, date.toString());
            ps.setString(3, "Withdrawl");
            ps.setString(4, String.valueOf(amount));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"₹" + String.format("%,d", amount)+ " Withdrawn Successfully!","Transaction Successful",JOptionPane.INFORMATION_MESSAGE);

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Transaction could not be completed.\nPlease try again.","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private String maskPin(String pin) {
        if (pin == null || pin.length() <= 2) {
            return "****";
        }
        return "******" + pin.substring(pin.length() - 2);
    }

    static class RoundedBorder implements javax.swing.border.Border {
        private int thickness;
        private Color color;
        private int radius;

        RoundedBorder(int thickness, Color color, int radius) {
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
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x + thickness / 2,y + thickness / 2,width - thickness,height - thickness,radius,radius);
            g2.dispose();
        }
    }

    public static void main(String[] args) 
    {
        new Fastcash("");
    }
}
