
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savingac, fixed_depositac, currentac, recurring_depositac;
    JButton submit , cancel;
    JCheckBox atm, mobile, e_statement, cheque, declare, email, internet;
    String formno;
    String fullCardNumber, lastFour;
    Random ran;
    
    SignupThree(String formno){
        this.formno = formno;
        
        setLayout(null);

        ran = new Random();

        StringBuilder cardNumber = new StringBuilder();

        cardNumber.append(ran.nextInt(9) + 1);

        for (int i = 1; i < 16; i++) {
            cardNumber.append(ran.nextInt(10));
        }

        fullCardNumber = cardNumber.toString();

        lastFour = fullCardNumber.substring(12);

        
        
        setTitle(" NEW ACCOUNT APPLICATION FORM - PAGE 3");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 0, 100, 100);
        add(label);
        
        JLabel det = new JLabel("Page 3 : Account Details ");
        det.setFont(new Font("Rakeway", Font.BOLD, 22));
        det.setBounds(270, 30, 400, 30);
        add(det);
        
        JLabel account = new JLabel("Account Type :");
        account.setFont(new Font("Rakeway", Font.BOLD, 16));
        account.setBounds(110, 120, 400, 25);
        add(account);
        
        savingac = new JRadioButton("Saving Account");
        savingac.setBounds(110, 160, 200, 25);
        savingac.setFont(new Font("Rakeway", Font.BOLD, 14));
        savingac.setBackground(Color.WHITE);
        add(savingac);
        
        fixed_depositac = new JRadioButton("Fixed Deposit Account");
        fixed_depositac.setBounds(400, 160, 200, 25);
        fixed_depositac.setFont(new Font("Rakeway", Font.BOLD, 14));
        fixed_depositac.setBackground(Color.WHITE);
        add(fixed_depositac);
        
        currentac = new JRadioButton("Current Account");
        currentac.setBounds(110, 200, 200, 25);
        currentac.setFont(new Font("Rakeway", Font.BOLD, 14));
        currentac.setBackground(Color.WHITE);
        add(currentac);
        
        recurring_depositac = new JRadioButton("Recurring Deposit Account");
        recurring_depositac.setBounds(400, 200, 250, 25);
        recurring_depositac.setFont(new Font("Rakeway", Font.BOLD, 14));
        recurring_depositac.setBackground(Color.WHITE);
        add(recurring_depositac);
        
        ButtonGroup account_type = new ButtonGroup();
        account_type.add(savingac);
        account_type.add(fixed_depositac);
        account_type.add(currentac);
        account_type.add(recurring_depositac);
        
        JLabel card = new JLabel("Card Number. :");
        card.setFont(new Font("Rakeway", Font.BOLD, 16));
        card.setBounds(110, 260, 200, 25);
        add(card);
        
        JLabel cardno = new JLabel("(Your 16-digit Card number)");
        cardno.setFont(new Font("Rakeway", Font.BOLD, 10));
        cardno.setBounds(110, 280, 200, 25);
        add(cardno);
        
        JLabel Card = new JLabel("XXXX-XXXX-XXXX-" + lastFour);
        Card.setFont(new Font("Rakeway", Font.BOLD, 16));
        Card.setBounds(360, 260, 200, 25);
        add(Card);
        
        JLabel Cardno = new JLabel("It would appear on ATM card/Cheque Book and Statement");
        Cardno.setFont(new Font("Rakeway", Font.BOLD, 10));
        Cardno.setBounds(360, 280, 300, 25);
        add(Cardno);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Rakeway", Font.BOLD, 16));
        pin.setBounds(110, 320, 200, 25);
        add(pin);
        
        JLabel pinno = new JLabel("(4-digit Password)");
        pinno.setFont(new Font("Rakeway", Font.BOLD, 10));
        pinno.setBounds(110, 340, 200, 25);
        add(pinno);
        
        JLabel Pin = new JLabel("XXXX");
        Pin.setFont(new Font("Rakeway", Font.BOLD, 16));
        Pin.setBounds(360, 320, 200, 25);
        add(Pin);
        
        JLabel services = new JLabel("Services Requried :");
        services.setFont(new Font("Rakeway", Font.BOLD, 16));
        services.setBounds(110, 390, 200, 25);
        add(services);
        
        atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Rakeway", Font.BOLD, 15));
        atm.setBackground(Color.WHITE);
        atm.setBounds(110, 430, 200, 25);
        add(atm);
        
        internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Rakeway", Font.BOLD, 15));
        internet.setBackground(Color.WHITE);
        internet.setBounds(400, 430, 200, 25);
        add(internet);
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Rakeway", Font.BOLD, 15));
        mobile.setBackground(Color.WHITE);
        mobile.setBounds(110, 470, 200, 25);
        add(mobile);
        
        email = new JCheckBox("Email Alerts");
        email.setFont(new Font("Rakeway", Font.BOLD, 15));
        email.setBackground(Color.WHITE);
        email.setBounds(400, 470, 200, 25);
        add(email);
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Rakeway", Font.BOLD, 15));
        cheque.setBackground(Color.WHITE);
        cheque.setBounds(110, 510, 200, 25);
        add(cheque);
        
        e_statement = new JCheckBox("E-Statement");
        e_statement.setFont(new Font("Rakeway", Font.BOLD, 15));
        e_statement.setBackground(Color.WHITE);
        e_statement.setBounds(400, 510, 200, 25);
        add(e_statement);
        
        declare = new JCheckBox("I hereby decalred that the above entered details correct to the best of mu knowledge");
        declare.setFont(new Font("Rakeway", Font.BOLD, 10));
        declare.setBackground(Color.WHITE);
        declare.setBounds(110, 570, 450, 25);
        add(declare);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 600, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 600, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
    setSize(800,700);
    setVisible(true);
    setLocation(300,10);
    
   
}
     public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accounttype = "null";
            if(savingac.isSelected()){
                accounttype = "Saving Account";
            }else if(fixed_depositac.isSelected()){
                accounttype = "Fixed Deposit Account";
            }else if(currentac.isSelected()){
                accounttype = "Current Account";                      
            }else if(recurring_depositac.isSelected()){
                accounttype = "Recurring Deposit Account";
            }
        
        String pinnumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        String facility = "";

if (atm.isSelected()) {
    facility += "ATM Card, ";
}

if (internet.isSelected()) {
    facility += "Internet Banking, ";
}

if (mobile.isSelected()) {
    facility += "Mobile Banking, ";
}

if (email.isSelected()) {
    facility += "Email Alerts, ";
}

if (cheque.isSelected()) {
    facility += "Cheque Book, ";
}

if (e_statement.isSelected()) {
    facility += "E-Statement, ";
}
        try{
                if(accounttype.equals("null")){
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }
                else{
                  Conn c = new Conn();
                  String query1 = "insert into signupthree values('"+formno+"', '"+accounttype+"', '"+fullCardNumber+"', '"+pinnumber+"', '"+facility+"')";
                  String query2 = "insert into login values('"+formno+"', '"+fullCardNumber+"', '"+pinnumber+"')";
                  
                  c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null, "Card No. : " + fullCardNumber + "\nPin : " + pinnumber);
                  setVisible(false);
                  new Deposit(pinnumber).setVisible(true);
                }                
               
            }catch (Exception e1){
                System.out.println(ae);
            }
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String []args){
        SignupThree s1 = new SignupThree("");
        s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
