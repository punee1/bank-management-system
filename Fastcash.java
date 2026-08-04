
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    JButton oneh, fiveh, onet, twot, fivet, tent, exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 730);
        add(label);
        
        JLabel info = new JLabel("SELECT  WITHDRAWL  AMOUNT");
        info.setFont(new Font("Rakeway", Font.BOLD, 15));
        info.setForeground(Color.white);
        info.setBounds(180, 260, 300, 30);
        label.add(info);
        
        oneh = new JButton("RS.100");
        oneh.setBounds(145, 365, 140, 25);
        oneh.addActionListener(this);
        label.add(oneh);
        
        fiveh = new JButton("RS.500");
        fiveh.setBounds(310, 365, 143, 25);
        fiveh.addActionListener(this);
        label.add(fiveh);
        
        onet = new JButton("RS.1000");
        onet.setBounds(145, 395, 140, 25);
        onet.addActionListener(this);
        label.add(onet);
        
        twot = new JButton("RS.2000");
        twot.setBounds(310, 395, 143, 25);
        twot.addActionListener(this);
        label.add(twot);
        
        fivet = new JButton("RS.5000");
        fivet.setBounds(145, 425, 140, 25);
        fivet.addActionListener(this);
        label.add(fivet);
        
        tent = new JButton("RS.10000");
        tent.setBounds(310, 425, 143, 25);
        tent.addActionListener(this);
        label.add(tent);
        
        exit = new JButton("BACK");
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
        if (ae.getSource() == exit){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
   }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));                   
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            
            Date date = new Date();
            String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"' )";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " +amount+ " Withdrawl Successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String [] args){
     Fastcash f1 = new Fastcash("");
     f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
