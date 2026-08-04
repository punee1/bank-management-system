
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);
        
        JLabel info = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        info.setFont(new Font("Rakeway", Font.BOLD, 15));
        info.setForeground(Color.white);
        info.setBounds(145, 260, 350, 30);
        label.add(info);
        
        amount = new JTextField();
        amount.setFont(new Font("Rakeway", Font.BOLD, 20));
        amount.setForeground(Color.BLACK);
        amount.setBounds(145, 295, 300, 25);
        label.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(310, 425, 143, 25);
        deposit.addActionListener(this);
        label.add(deposit);
        
        back = new JButton("BACK");
        back.setBounds(310, 455, 143, 25);
        back.addActionListener(this);
        label.add(back);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 730);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }else{
                try{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
            }
        }
    }
    public static void main(String [] args){
    Deposit d1 = new Deposit("");
    d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    
