package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
  
    JButton deposit , cash, fast_cash, pin, mini_statement, balance , exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);
        
        JLabel info = new JLabel("PLEASE SELECT YOUR TRANSACTION ");
        info.setFont(new Font("Rakeway", Font.BOLD, 15));
        info.setForeground(Color.white);
        info.setBounds(165, 260, 300, 30);
        label.add(info);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(145, 365, 140, 25);
        deposit.addActionListener(this);
        label.add(deposit);
        
        cash = new JButton("CASH WITHDRAWL");
        cash.setBounds(310, 365, 143, 25);
        cash.addActionListener(this);
        label.add(cash);
        
        fast_cash = new JButton("FAST CASH");
        fast_cash.setBounds(145, 395, 140, 25);
        fast_cash.addActionListener(this);
        label.add(fast_cash);
        
        mini_statement = new JButton("MINI STATEMENT");
        mini_statement.setBounds(310, 395, 143, 25);
        mini_statement.addActionListener(this);
        label.add(mini_statement);
        
        pin = new JButton("PIN CHANGE");
        pin.setBounds(145, 425, 140, 25);
        pin.addActionListener(this);
        label.add(pin);
        
        balance = new JButton("BALANCE ENQUIRY");
        balance.setBounds(310, 425, 143, 25);
        balance.addActionListener(this);
        label.add(balance);
        
        exit = new JButton("EXIT");
        exit.setBounds(310, 455, 143, 25);
        exit.addActionListener(this);
        label.add(exit);
        
        getContentPane().setBackground(Color.white);
        setSize(800, 730);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
      if (ae.getSource() == deposit){
          setVisible(false);
          new Deposit(pinnumber).setVisible(true);
       
   }else if(ae.getSource() == cash){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
    }else if(ae.getSource() == fast_cash){
        setVisible(false);
        new Fastcash(pinnumber).setVisible(true);
    }else if(ae.getSource() == mini_statement){
        new Ministatement(pinnumber).setVisible(true);
    }else if(ae.getSource() == pin){
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
    }else if(ae.getSource() == balance){
        setVisible(false);
        new Balance(pinnumber).setVisible(true);
    }else if(ae.getSource() == exit){
        System.exit(0);
    }
    }
    public static void main(String []args){
        Transactions t1 = new Transactions("");
        t1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
