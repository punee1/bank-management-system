
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Balance extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    Balance(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);
        
        back = new JButton("BACK");
        back.setBounds(310, 455, 143, 25);
        back.addActionListener(this);
        label.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));                   
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is Rs " +balance);
        text.setBounds(150, 260, 300, 30);
        text.setFont(new Font("Rakeway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        label.add(text);
                
        getContentPane().setBackground(Color.white);
        setSize(800, 730);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String [] args){
        Balance b1 = new Balance("");
        b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
