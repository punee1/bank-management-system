package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    
    Login(){
        
        setTitle("Automated Teller Machine");
       
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(120, 20, 100, 100);
        add(label);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",  Font.BOLD, 38));
        text.setBounds(350, 40, 400, 40);
        add(text);
        
        
        JLabel cardno = new JLabel("Card no. :");
        cardno.setFont(new Font("Raleway",  Font.BOLD, 25));
        cardno.setBounds(250, 150, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(420, 155, 250, 30);
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway",  Font.BOLD, 25));
        pin.setBounds(250, 220, 150, 40);
        add(pin);
        
        pinPasswordField = new JPasswordField();
        pinPasswordField.setBounds(420, 225, 250, 30);
        add(pinPasswordField);
        
        login = new JButton("SIGN IN");
        login.setBounds(420, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(570, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(420, 380, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        setSize(900, 500);
        setVisible(true);
        setLocation(200, 150);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
   if (ae.getSource() == clear){
       cardTextField.setText("");
       pinPasswordField.setText("");
   }else if(ae.getSource() == login){
       Conn c = new Conn();
       String cardnumber = cardTextField.getText();
       String pinnumber = new String(pinPasswordField.getPassword());
       String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
       try{
           ResultSet rs = c.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }else{
               JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin");
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
        
    }else if(ae.getSource() == signup){
        setVisible(false);
        new SignupOne().setVisible(true);
        
    }
    }
    public static void main(String [] args){
        Login l1 = new Login();
        l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
