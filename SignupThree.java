package bms;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton savingac, fixed_depositac, currentac, recurring_depositac;
    JButton submit, cancel;
    JCheckBox atm, mobile, e_statement, cheque, declare, email, internet;
    String formno;
    String fullCardNumber, lastFour;
    Random ran;
    
    Color darkBlue = new Color(15, 35, 65);
    Color blue = new Color(35, 99, 180);
    Color lightBlue = new Color(240, 245, 252);
    Color textColor = new Color(35, 45, 60);

    SignupThree(String formno) {
        this.formno = formno;

        setTitle("Bank Management System - Account Opening");
        setSize(1100, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(lightBlue);
        
        ran = new Random();
        StringBuilder cardNumber =new StringBuilder();
        cardNumber.append(ran.nextInt(9) + 1);
        for (int i = 1; i < 16; i++) {
            cardNumber.append(ran.nextInt(10));
        }
        fullCardNumber =cardNumber.toString();
        lastFour =fullCardNumber.substring(12);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(darkBlue);
        sidebar.setBounds(0, 0, 280, 720);
        add(sidebar);

        JLabel bankTitle = new JLabel("<html><center>BANK<br>" + "MANAGEMENT<br>" + "SYSTEM</center></html>");
        bankTitle.setFont(new Font("Arial",Font.BOLD,27));
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bankTitle.setBounds(20,45,240,125);
        sidebar.add(bankTitle);

        JPanel line = new JPanel();
        line.setBackground(new Color(70, 120, 190));
        line.setBounds(45,195,190,2);
        sidebar.add(line);

        JLabel accountOpening = new JLabel("ACCOUNT OPENING");
        accountOpening.setFont(new Font("Arial",Font.BOLD,18));
        accountOpening.setForeground(Color.WHITE);
        accountOpening.setHorizontalAlignment(SwingConstants.CENTER);
        accountOpening.setBounds(20,225,240,30);
        sidebar.add(accountOpening);

        JLabel step = new JLabel("STEP 3 OF 3");
        step.setFont(new Font("Arial",Font.BOLD,15));
        step.setForeground(new Color(150, 200, 255));
        step.setHorizontalAlignment(SwingConstants.CENTER);
        step.setBounds(20,270,240,30);
        sidebar.add(step);
        
        JPanel progressBackground =new JPanel();
        progressBackground.setBackground(new Color(55, 75, 105));
        progressBackground.setBounds(45,315,190,8);
        sidebar.add(progressBackground);
        
        JPanel progress = new JPanel();
        progress.setBackground(new Color(70, 150, 230));
        progress.setBounds(45,315,190,8);
        sidebar.add(progress);

        JLabel application = new JLabel("<html><center>" + "Application No.<br>" + "<b>" + formno + "</b>" + "</center></html>");
        application.setFont(new Font("Arial",Font.PLAIN,14));
        application.setForeground(Color.LIGHT_GRAY);
        application.setHorizontalAlignment(SwingConstants.CENTER);
        application.setBounds(20,350,240,55);
        sidebar.add(application);

        JLabel secure = new JLabel("<html><center>" + "Your account is almost ready.<br>" + "Review the details and submit." + "</center></html>");
        secure.setFont(new Font("Arial",Font.PLAIN,12));
        secure.setForeground(new Color(180, 190, 205));
        secure.setHorizontalAlignment(SwingConstants.CENTER);
        secure.setBounds(20,600,240,50);
        sidebar.add(secure);

        JLabel heading = new JLabel("Account Details");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setForeground(textColor);
        heading.setBounds(320,25,400,40);
        add(heading);

        JLabel subHeading = new JLabel("Choose your account type and required banking services");
        subHeading.setFont(new Font("Arial",Font.PLAIN,14));
        subHeading.setForeground(new Color(100, 110, 125));
        subHeading.setBounds(322,67,650,25);
        add(subHeading);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(310,105,750,535);
        mainPanel.setBorder(new RoundedBorder(18,new Color(220, 225, 235)));
        add(mainPanel);

        JLabel accountTitle = new JLabel("ACCOUNT TYPE");
        accountTitle.setFont(new Font("Arial",Font.BOLD,14));
        accountTitle.setForeground(textColor);
        accountTitle.setBounds(35,25,300,30);
        mainPanel.add(accountTitle);

        savingac = createRadioButton("Saving Account");
        savingac.setBounds(35,65,200,35);
        mainPanel.add(savingac);

        fixed_depositac = createRadioButton("Fixed Deposit Account");
        fixed_depositac.setBounds(350,65,250,35);
        mainPanel.add(fixed_depositac);

        currentac = createRadioButton("Current Account");
        currentac.setBounds(35,105,200,35);
        mainPanel.add(currentac);

        recurring_depositac = createRadioButton("Recurring Deposit Account");
        recurring_depositac.setBounds(350,105,270,35);
        mainPanel.add(recurring_depositac);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savingac);
        accountGroup.add(fixed_depositac);
        accountGroup.add(currentac);
        accountGroup.add(recurring_depositac);

        JLabel cardTitle = new JLabel("CARD NUMBER");
        cardTitle.setFont(new Font("Arial",Font.BOLD,14));
        cardTitle.setForeground(textColor);
        cardTitle.setBounds(35,160,200,25);
        mainPanel.add(cardTitle);

        JLabel cardInfo = new JLabel("Your 16-digit debit card number");
        cardInfo.setFont(new Font("Arial",Font.PLAIN,12));
        cardInfo.setForeground(new Color(110, 120, 135));
        cardInfo.setBounds(35,185,250,20);
        mainPanel.add(cardInfo);

        JLabel CardNumber = new JLabel("XXXX  XXXX  XXXX  " + lastFour);
        CardNumber.setFont(new Font("Arial",Font.BOLD,20));
        CardNumber.setForeground(blue);
        CardNumber.setBounds(350,170,350,35);
        mainPanel.add(CardNumber);

        JLabel pinTitle = new JLabel("PIN");
        pinTitle.setFont(new Font("Arial",Font.BOLD,14));
        pinTitle.setForeground(textColor);
        pinTitle.setBounds(35,220,200,25);
        mainPanel.add(pinTitle);
        
        JLabel pinInfo = new JLabel("A 4-digit PIN will be generated");
        pinInfo.setFont(new Font("Arial",Font.PLAIN,12));
        pinInfo.setForeground(new Color(110, 120, 135));
        pinInfo.setBounds(35,245,250,20);
        mainPanel.add(pinInfo);

        JLabel pinValue = new JLabel("XXXX");
        pinValue.setFont(new Font("Arial",Font.BOLD,20));
        pinValue.setForeground(blue);
        pinValue.setBounds(350,225,200,35);
        mainPanel.add(pinValue);

        JLabel serviceTitle = new JLabel("SERVICES REQUIRED");
        serviceTitle.setFont(new Font("Arial",Font.BOLD,14));
        serviceTitle.setForeground(textColor);
        serviceTitle.setBounds(35,285,250,25);
        mainPanel.add(serviceTitle);

        atm = createCheckBox("ATM Card");
        atm.setBounds(35,320,200,30);
        mainPanel.add(atm);

        internet = createCheckBox("Internet Banking");
        internet.setBounds(350,320,220,30);
        mainPanel.add(internet);

        mobile = createCheckBox("Mobile Banking");
        mobile.setBounds(35,355,200,30);
        mainPanel.add(mobile);

        email = createCheckBox("Email Alerts");
        email.setBounds(350,355,200,30);
        mainPanel.add(email);

        cheque = createCheckBox("Cheque Book");
        cheque.setBounds(35,390,200,30);
        mainPanel.add(cheque);

        e_statement = createCheckBox("E-Statement");
        e_statement.setBounds(350,390,200,30);
        mainPanel.add(e_statement);

        declare = new JCheckBox("I hereby declare that the above entered details are correct.");
        declare.setFont(new Font("Arial",Font.PLAIN,12));
        declare.setForeground(textColor);
        declare.setBackground(Color.WHITE);
        declare.setFocusPainted(false);
        declare.setBounds(35,435,550,30);
        mainPanel.add(declare);

        cancel = new JButton("CANCEL");
        cancel.setBounds(735,655,140,40);
        styleButton(cancel,new Color(100, 110, 125));
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("SUBMIT");
        submit.setBounds(890,655,170,40);
        styleButton(submit,blue);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radio = new JRadioButton(text);
        radio.setFont(new Font("Arial",Font.PLAIN,14));
        radio.setForeground(textColor);
        radio.setBackground(Color.WHITE);
        radio.setFocusPainted(false);
        return radio;
    }

    private JCheckBox createCheckBox(String text) {
        JCheckBox box = new JCheckBox(text);
        box.setFont(new Font("Arial",Font.PLAIN,14));
        box.setForeground(textColor);
        box.setBackground(Color.WHITE);
        box.setFocusPainted(false);
        return box;
    }

    private void styleButton(JButton button,Color color) {
        button.setFont(new Font("Arial",Font.BOLD,14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cancel) {
            int choice = JOptionPane.showConfirmDialog(this,"Are you sure you want to cancel " + "the account opening process?","Confirm Cancellation",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                setVisible(false);
                new BMS().setVisible(true);
            }
            return;
        }

        if (ae.getSource() == submit) {
            String accounttype = "";
            if (savingac.isSelected()) {
                accounttype = "Saving Account";
            } else if (fixed_depositac.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (currentac.isSelected()) {
                accounttype = "Current Account";
            } else if (recurring_depositac.isSelected()) {
                accounttype = "Recurring Deposit Account";
            }

            if (accounttype.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please select an account type.");
                return;
            }

            if (!declare.isSelected()) {
                JOptionPane.showMessageDialog(this,"Please accept the declaration " + "before submitting.");
                return;
            }

            String pinnumber = String.valueOf(1000 +ran.nextInt(9000));
            
            StringBuilder facility =new StringBuilder();
            if (atm.isSelected()) {
                facility.append("ATM Card, ");
            }
            if (internet.isSelected()) {
                facility.append("Internet Banking, ");
            }
            if (mobile.isSelected()) {
                facility.append("Mobile Banking, ");
            }
            if (email.isSelected()) {
                facility.append("Email Alerts, ");
            }
            if (cheque.isSelected()) {
                facility.append("Cheque Book, ");
            }
            if (e_statement.isSelected()) {
                facility.append("E-Statement, ");
            }
            String facilityString = facility.toString();
            
            if (facilityString.endsWith(", ")) {
                facilityString = facilityString.substring(0,facilityString.length() - 2);
            }

            Conn c = null;
            PreparedStatement ps1 = null;
            PreparedStatement ps2 = null;
            try {
                c = new Conn();
                c.c.setAutoCommit(false);
                String query1 = "INSERT INTO signupthree " + "VALUES (?, ?, ?, ?, ?)";
                ps1 = c.c.prepareStatement(query1);
                ps1.setString(1,formno);
                ps1.setString(2,accounttype);
                ps1.setString(3,fullCardNumber);
                ps1.setString(4,pinnumber);
                ps1.setString(5,facilityString);
                ps1.executeUpdate();
                
                String query2 = "INSERT INTO login " + "VALUES (?, ?, ?)";
                ps2 = c.c.prepareStatement(query2);
                ps2.setString(1,formno);
                ps2.setString(2,fullCardNumber);
                ps2.setString(3,pinnumber);
                ps2.executeUpdate();

                c.c.commit();

                JOptionPane.showMessageDialog(this,"ACCOUNT CREATED SUCCESSFULLY!\n\n" + "Card Number : " + fullCardNumber + "\n" + "PIN : " + pinnumber,"Account Created",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);

                new Deposit(pinnumber).setVisible(true);
            } catch (Exception e) {
                try {
                    if (c != null) {
                        c.c.rollback();
                    }
                } catch (Exception rollbackError) {
                    System.out.println(rollbackError);
                }
                JOptionPane.showMessageDialog(this,"Database Error:\n" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (ps1 != null) {
                        ps1.close();
                    }
                    if (ps2 != null) {
                        ps2.close();
                    }
                    if (c != null) {
                        c.c.setAutoCommit(true);
                    }
                } catch (Exception closeError) {
                    System.out.println(closeError);
                }
            }
        }
    }

    static class RoundedBorder extends AbstractBorder {
        private final int radius;
        private final Color color;
        
        RoundedBorder(int radius,Color color) {
            this.radius = radius;
            this.color = color;
        }
        
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(x,y,width - 1,height - 1,radius,radius);
            g2.dispose();
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(8,12,8,12);
        }
        
        public Insets getBorderInsets(Component c,Insets insets) {
            insets.left = 12;
            insets.right = 12;
            insets.top = 8;
            insets.bottom = 8;
            return insets;
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            SignupThree s3 = new SignupThree("1234");
            s3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
