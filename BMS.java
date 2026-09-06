package bms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BMS extends JFrame implements ActionListener {

    JButton login, signup, clear, showPin;
    JTextField cardTextField;
    JPasswordField pinPasswordField;

    Color darkBlue = new Color(8, 30, 68);
    Color blue = new Color(35, 91, 210);
    Color lightBlue = new Color(235, 242, 255);
    Color textColor = new Color(20, 35, 65);

    BMS() {

        setTitle("Bank Management System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(390, 650));
        leftPanel.setLayout(null);
        leftPanel.setBackground(darkBlue);

        JPanel circle1 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(35, 91, 210));
                g2.fillOval(-100,-120,300,300);
                g2.dispose();
            }
        };

        circle1.setOpaque(false);
        circle1.setBounds(0,0,390,200);
        leftPanel.add(circle1);

        JLabel bankIcon = new JLabel("₹");
        bankIcon.setFont(new Font("Segoe UI",Font.BOLD,70));
        bankIcon.setForeground(Color.WHITE);
        bankIcon.setHorizontalAlignment(SwingConstants.CENTER);
        bankIcon.setBounds(115,110,160,100);
        leftPanel.add(bankIcon);

        JLabel title1 = new JLabel("BANK");
        title1.setFont(new Font("Segoe UI",Font.BOLD,42));
        title1.setForeground(Color.WHITE);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setBounds(40,225,310,55);
        leftPanel.add(title1);

        JLabel title2 = new JLabel("MANAGEMENT");
        title2.setFont(new Font("Segoe UI",Font.BOLD,30));
        title2.setForeground(new Color(100, 170, 255));
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBounds(40,275,310,45);
        leftPanel.add(title2);

        JLabel title3 = new JLabel("SYSTEM");
        title3.setFont(new Font("Segoe UI",Font.BOLD,30));
        title3.setForeground(Color.WHITE);
        title3.setHorizontalAlignment(SwingConstants.CENTER);
        title3.setBounds(40,315,310,45);
        leftPanel.add(title3);

        JPanel lineLeft = new JPanel();
        lineLeft.setBackground(new Color(70, 130, 220));
        lineLeft.setBounds(110,380,170,3);
        leftPanel.add(lineLeft);

        JLabel description = new JLabel("<html><center>Secure and reliable banking<br>"+ "management solution</center></html>");
        description.setFont(new Font("Segoe UI",Font.PLAIN,16));
        description.setForeground(new Color(210, 220, 240));
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setBounds(35,405,320,65);
        leftPanel.add(description);

        JLabel secureText = new JLabel("SECURE • SIMPLE • SMART");
        secureText.setFont(new Font("Segoe UI",Font.BOLD,13));
        secureText.setForeground(new Color(150, 190, 250));
        secureText.setHorizontalAlignment(SwingConstants.CENTER);
        secureText.setBounds(35,555,320,30);
        leftPanel.add(secureText);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(null);

        JLabel welcome = new JLabel("Welcome Back");
        welcome.setFont(new Font("Segoe UI",Font.BOLD,38));
        welcome.setForeground(textColor);
        welcome.setBounds(80,60,500,50);
        rightPanel.add(welcome);

        JLabel subtitle = new JLabel("Login to access your account");
        subtitle.setFont(new Font("Segoe UI",Font.PLAIN,16));
        subtitle.setForeground(new Color(110, 120, 140));
        subtitle.setBounds(83,110,400,30);
        rightPanel.add(subtitle);

        JPanel headingLine = new JPanel();
        headingLine.setBackground(blue);
        headingLine.setBounds(83,150,70,4);
        rightPanel.add(headingLine);

        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Segoe UI",Font.BOLD,17));
        cardLabel.setForeground(textColor);
        cardLabel.setBounds(83,195,200,30);
        rightPanel.add(cardLabel);

        JLabel cardIcon = new JLabel("\u25A3");
        cardIcon.setFont(new Font("Segoe UI Symbol",Font.BOLD,23));
        cardIcon.setForeground(blue);
        cardIcon.setHorizontalAlignment(SwingConstants.CENTER);
        cardIcon.setBackground(lightBlue);
        cardIcon.setOpaque(true);
        cardIcon.setBounds(83,235,52,52);
        rightPanel.add(cardIcon);

        cardTextField =new RoundedTextField(15);
        cardTextField.setFont(new Font("Segoe UI",Font.PLAIN,16));
        cardTextField.setForeground(textColor);
        cardTextField.setBounds(148,235,430,52);
        cardTextField.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(new Color(205,215,235),1,15),new EmptyBorder(0,15,0,15)));
        rightPanel.add(cardTextField);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(new Font("Segoe UI",Font.BOLD,17));
        pinLabel.setForeground(textColor);
        pinLabel.setBounds(83,320,200,30);
        rightPanel.add(pinLabel);

        JLabel pinIcon = new JLabel("●");
        pinIcon.setFont(new Font("Segoe UI",Font.BOLD,22));
        pinIcon.setForeground(blue);
        pinIcon.setHorizontalAlignment(SwingConstants.CENTER);
        pinIcon.setBackground(lightBlue);
        pinIcon.setOpaque(true);
        pinIcon.setBounds(83,360,52,52);
        rightPanel.add(pinIcon);

        pinPasswordField =new JPasswordField();
        pinPasswordField.setFont(new Font("Segoe UI",Font.PLAIN,16));
        pinPasswordField.setForeground(textColor);
        pinPasswordField.setBounds(148,360,370,52);
        pinPasswordField.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(new Color(205,215,235),1,15),new EmptyBorder(0,15,0,15)));
        rightPanel.add(pinPasswordField);

        showPin = new JButton("●");
        showPin.setBounds(528,360,50,52);
        showPin.setBackground(Color.WHITE);
        showPin.setForeground(new Color(100,110,130));
        showPin.setBorder(new RoundedBorder(new Color(205,215,235),1,15));
        showPin.setFocusPainted(false);
        showPin.addActionListener(this);
        rightPanel.add(showPin);

        login = createButton("SIGN IN",darkBlue);
        login.setBounds(83,450,240,52);
        rightPanel.add(login);

        clear = createButton("CLEAR",darkBlue);
        clear.setBounds(338,450,240,52);
        rightPanel.add(clear);

        signup = createButton("CREATE NEW ACCOUNT",blue);
        signup.setBounds(83,520,495,52);
        rightPanel.add(signup);

        JLabel footer = new JLabel("Your security is our priority");
        footer.setFont(new Font("Segoe UI",Font.PLAIN,13));
        footer.setForeground(new Color(120,130,145));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setBounds(80,585,495,25);
        rightPanel.add(footer);

        mainPanel.add(leftPanel,BorderLayout.WEST);
        mainPanel.add(rightPanel,BorderLayout.CENTER);
        add(mainPanel);
        
        setVisible(true);
    }

    private JButton createButton(String text,Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI",Font.BOLD,15));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(new RoundedBorder(color,0,15));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinPasswordField.setText("");
        }
        else if (ae.getSource() == login) {
            String cardnumber = cardTextField.getText().trim();
            String pinnumber = new String(pinPasswordField.getPassword());
            if (cardnumber.isEmpty() || pinnumber.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please enter Card Number and PIN.","Login Required",JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                Conn c =new Conn();
                String query = "SELECT * FROM login "+ "WHERE cardnumber = ? "+ "AND pin = ?";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1,cardnumber);
                pst.setString(2,pinnumber);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this,"Login Successful!","Welcome",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } 
                else{
                    JOptionPane.showMessageDialog(this,"Invalid Card Number or PIN.","Login Failed",JOptionPane.ERROR_MESSAGE);
                }
                rs.close();
                pst.close();
                c.c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Database Error: "+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
            else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

        else if (ae.getSource() == showPin) {
            if(pinPasswordField.getEchoChar() == '\u0000') 
            {
                pinPasswordField.setEchoChar('•');
            } 
            else{
               pinPasswordField.setEchoChar('\u0000');
            }
        }
    }

    static class RoundedTextField extends JTextField {
        private int radius;
        RoundedTextField(int radius) 
        {
            this.radius = radius;
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
            g2.dispose();
            super.paintComponent(g);
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
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height)
        {
            Graphics2D g2 =(Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x,y,width - 1,height - 1,radius,radius);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMS());
    }
}
