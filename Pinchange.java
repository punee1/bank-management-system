package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener {

    String pinnumber;
    JPasswordField Newpin, Repin;
    JButton change, back;

    Color darkBlue = new Color(20, 42, 74);
    Color blue = new Color(37, 99, 235);
    Color textDark = new Color(31, 41, 55);
    Color gray = new Color(107, 114, 128);
    Color lightBlue = new Color(239, 246, 255);

    Pinchange(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Change PIN - Bank Management System");
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

        JLabel pinTitle = new JLabel("PIN SECURITY");
        pinTitle.setFont(new Font("Arial", Font.BOLD, 18));
        pinTitle.setForeground(Color.WHITE);
        pinTitle.setHorizontalAlignment(SwingConstants.CENTER);
        pinTitle.setBounds(35, 220, 190, 35);
        sidebar.add(pinTitle);

        JLabel pinInfo = new JLabel("<html><center>Secure your account<br>with a new PIN</center></html>");
        pinInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        pinInfo.setForeground(new Color(190, 205, 225));
        pinInfo.setHorizontalAlignment(SwingConstants.CENTER);
        pinInfo.setBounds(30, 270, 200, 55);
        sidebar.add(pinInfo);

        JLabel security = new JLabel("SECURE BANKING");
        security.setFont(new Font("Arial", Font.BOLD, 12));
        security.setForeground(new Color(150, 175, 205));
        security.setHorizontalAlignment(SwingConstants.CENTER);
        security.setBounds(35, 570, 190, 25);
        sidebar.add(security);

        JPanel mainPanel = new JPanel();

        mainPanel.setBounds(260, 0, 840, 650);
        mainPanel.setBackground(new Color(248, 250, 252));
        mainPanel.setLayout(null);
        add(mainPanel);

        JLabel heading = new JLabel("Change PIN");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(textDark);
        heading.setBounds(55, 45, 400, 40);
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Update your ATM PIN securely");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(gray);
        subtitle.setBounds(58, 88, 400, 25);
        mainPanel.add(subtitle);

        JPanel pinCard = new JPanel();

        pinCard.setBounds(55, 135, 730, 410);
        pinCard.setBackground(Color.WHITE);
        pinCard.setLayout(null);
        pinCard.setBorder(new RoundedBorder(1,new Color(225, 229, 235),20));
        mainPanel.add(pinCard);

        JLabel cardHeading = new JLabel("CREATE NEW PIN");
        cardHeading.setFont(new Font("Arial", Font.BOLD, 18));
        cardHeading.setForeground(textDark);
        cardHeading.setBounds(45, 30, 300, 30);
        pinCard.add(cardHeading);

        JLabel cardSubheading = new JLabel("Enter a new 4-digit PIN for your account");
        cardSubheading.setFont(new Font("Arial", Font.PLAIN, 13));
        cardSubheading.setForeground(gray);
        cardSubheading.setBounds(45, 60, 400, 25);
        pinCard.add(cardSubheading);

        JLabel newPinLabel = new JLabel("NEW PIN");
        newPinLabel.setFont(new Font("Arial", Font.BOLD, 13));
        newPinLabel.setForeground(textDark);
        newPinLabel.setBounds(45, 105, 200, 25);
        pinCard.add(newPinLabel);
        
        Newpin = new JPasswordField();
        Newpin.setFont(new Font("Arial", Font.BOLD, 20));
        Newpin.setEchoChar('•');
        Newpin.setHorizontalAlignment(JTextField.CENTER);
        Newpin.setBorder(new RoundedBorder(1,new Color(209, 213, 219),10));
        Newpin.setBounds(45, 132, 640, 48);
        pinCard.add(Newpin);

        JLabel rePinLabel = new JLabel("RE-ENTER NEW PIN");
        rePinLabel.setFont(new Font("Arial", Font.BOLD, 13));
        rePinLabel.setForeground(textDark);
        rePinLabel.setBounds(45, 195, 250, 25);
        pinCard.add(rePinLabel);

        Repin = new JPasswordField();
        Repin.setFont(new Font("Arial", Font.BOLD, 20));
        Repin.setEchoChar('•');
        Repin.setHorizontalAlignment(JTextField.CENTER);
        Repin.setBorder(new RoundedBorder(1,new Color(209, 213, 219),10));
        Repin.setBounds(45, 222, 640, 48);
        pinCard.add(Repin);

        JLabel instruction = new JLabel("<html>PIN must contain exactly 4 digits and should not be " + "the same as another customer's PIN.</html>");
        instruction.setFont(new Font("Arial", Font.PLAIN, 12));
        instruction.setForeground(gray);
        instruction.setBounds(45, 285, 640, 35);
        pinCard.add(instruction);

        change = new JButton("CHANGE PIN");
        change.setFont(new Font("Arial", Font.BOLD, 14));
        change.setForeground(Color.WHITE);
        change.setBackground(blue);
        change.setFocusPainted(false);
        change.setBorderPainted(false);
        change.setCursor(new Cursor(Cursor.HAND_CURSOR));
        change.setBounds(45, 335, 305, 45);
        change.addActionListener(this);
        pinCard.add(change);

        back = new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(textDark);
        back.setBackground(lightBlue);
        back.setFocusPainted(false);
        back.setBorder(new RoundedBorder(1,new Color(191, 219, 254),10));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(380, 335, 305, 45);
        back.addActionListener(this);
        pinCard.add(back);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            return;
        }

        if (ae.getSource() == change) {
            String npin =new String(Newpin.getPassword()).trim();
            String rpin =new String(Repin.getPassword()).trim();

            if (npin.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please enter a new PIN.","Invalid PIN",JOptionPane.WARNING_MESSAGE);
                Newpin.requestFocus();
                return;
            }

            if (rpin.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please re-enter the new PIN.","Invalid PIN",JOptionPane.WARNING_MESSAGE);
                Repin.requestFocus();
                return;
            }

            if (!npin.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this,"PIN must contain exactly 4 digits.","Invalid PIN",JOptionPane.WARNING_MESSAGE);
                Newpin.requestFocus();
                return;
            }

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(this,"The entered PINs do not match.","PIN Mismatch",JOptionPane.WARNING_MESSAGE);
                Repin.requestFocus();
                return;
            }

            if (npin.equals(pinnumber)) {
                JOptionPane.showMessageDialog(this,"New PIN cannot be the same as your current PIN.","Invalid PIN",JOptionPane.WARNING_MESSAGE);
                return;
            }
            changePin(npin);
        }
    }

    private void changePin(String npin) {
        Conn c = null;
        try {
            c = new Conn();
            String checkQuery = "SELECT pin FROM login WHERE pin = ? AND pin <> ?";
            PreparedStatement checkPs = c.c.prepareStatement(checkQuery);
            checkPs.setString(1, npin);
            checkPs.setString(2, pinnumber);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                rs.close();
                checkPs.close();
                JOptionPane.showMessageDialog(this,"This PIN is already used by another account.\n" + "Please enter a different PIN.","PIN Already Exists",JOptionPane.WARNING_MESSAGE);
                return;
            }
            rs.close();
            checkPs.close();
            c.c.setAutoCommit(false);

            String query1 ="UPDATE bank SET pin = ? WHERE pin = ?";
            String query2 ="UPDATE login SET pin = ? WHERE pin = ?";
            String query3 ="UPDATE signupthree SET pin = ? WHERE pin = ?";
            
            PreparedStatement ps1 = c.c.prepareStatement(query1);
            PreparedStatement ps2 = c.c.prepareStatement(query2);
            PreparedStatement ps3 = c.c.prepareStatement(query3);

            ps1.setString(1, npin);
            ps1.setString(2, pinnumber);

            ps2.setString(1, npin);
            ps2.setString(2, pinnumber);

            ps3.setString(1, npin);
            ps3.setString(2, pinnumber);

            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();

            ps1.close();
            ps2.close();
            ps3.close();

            c.c.commit();
            c.c.setAutoCommit(true);
            JOptionPane.showMessageDialog(this,"Your PIN has been changed successfully!","PIN Changed",JOptionPane.INFORMATION_MESSAGE);

            Newpin.setText("");
            Repin.setText("");

            setVisible(false);
            new Transactions(npin).setVisible(true);

        } catch (Exception e) {
            try {
                if (c != null) {
                    c.c.rollback();
                    c.c.setAutoCommit(true);
                }
            } catch (Exception rollbackException) {
                System.out.println(rollbackException);
            }
            JOptionPane.showMessageDialog(this,"Unable to change PIN.\n" + "Error: " + e.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
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
        new Pinchange("");
    }
}
