package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener{
 
    JButton exit;
    JLabel info;

    Ministatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        info = new JLabel();
        info.setVerticalAlignment(JLabel.TOP);

        JScrollPane scrollPane = new JScrollPane(info);
        scrollPane.setBounds(20, 140, 350, 250);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        JLabel text = new JLabel("Indian Bank");
        text.setBounds(150, 20, 100, 20);
        add(text);
        
        JLabel head = new JLabel();
        head.setBounds(20, 80, 300, 20);
        add(head);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                head.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
         
        try{
            int balance = 0;
            ResultSet rs = new Conn().s.executeQuery("select * from bank where pin = '"+pin+"' order by STR_TO_DATE(date, '%a %b %d %H:%i:%s IST %Y') desc");
            StringBuilder statement = new StringBuilder("<html>");

            while(rs.next()){
                statement.append(rs.getString("date"))
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("type"))
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("amount"))
                         .append("<br><br>");

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            statement.append("</html>");
            info.setText(statement.toString());
            bal.setText("Your total Balance is Rs "+balance);

        }catch(Exception e){
            System.out.println(e);
        }
        
        exit = new JButton("Exit");
        add(exit);
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        Ministatement m1 = new Ministatement("");
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}