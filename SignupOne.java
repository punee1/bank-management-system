package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JDateChooser datechooser;
    JTextField nameTextField, fatherTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField ;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    
    SignupOne(){
        
        setLayout(null);
        setTitle(" NEW ACCOUNT APPLICATION FORM - PAGE 1");
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L) ;
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Rakeway", Font.BOLD, 38));
        formno.setBounds(130, 30, 600, 30);
        add(formno);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 0, 100, 100);
        add(label);
        
        JLabel det = new JLabel("Page 1 : Personal Details ");
        det.setFont(new Font("Rakeway", Font.BOLD, 18));
        det.setBounds(280, 80, 400, 30);
        add(det);
       
        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Rakeway", Font.BOLD, 20));
        name.setBounds(110, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(290, 140, 350, 25);
        nameTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(nameTextField);
        
        JLabel father = new JLabel("Father's NAME :");
        father.setFont(new Font("Rakeway", Font.BOLD, 20));
        father.setBounds(110, 180, 400, 30);
        add(father);
        
        fatherTextField = new JTextField();
        fatherTextField.setBounds(290, 180, 350, 25);
        fatherTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(fatherTextField);
        
        JLabel date = new JLabel("Date Of Birth :");
        date.setFont(new Font("Rakeway", Font.BOLD, 20));
        date.setBounds(110, 220, 400, 30);
        add(date);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(290, 220, 350, 25);
        datechooser.setForeground(Color.BLACK);
        add(datechooser);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Rakeway", Font.BOLD, 20));
        gender.setBounds(110, 260, 400, 30);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(290, 260, 100, 25);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBackground(Color.WHITE);
        female.setBounds(430, 260, 100, 25);
        add(female);
        
        other = new JRadioButton("OTHER");
        other.setBackground(Color.WHITE);
        other.setBounds(570, 260, 100, 25);
        add(other);
       
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email Adress :");
        email.setFont(new Font("Rakeway", Font.BOLD, 20));
        email.setBounds(110, 300, 400, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(290, 300, 350, 25);
        emailTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Rakeway", Font.BOLD, 20));
        marital.setBounds(110, 340, 400, 30);
        add(marital);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(290, 340, 100, 25);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(430, 340, 100, 25);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Rakeway", Font.BOLD, 20));
        address.setBounds(110, 380, 400, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(290, 380, 350, 25);
        addressTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(addressTextField);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Rakeway", Font.BOLD, 20));
        city.setBounds(110, 420, 400, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(290, 420, 350, 25);
        cityTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(cityTextField);
        
        JLabel pin = new JLabel("Pin Code :");
        pin.setFont(new Font("Rakeway", Font.BOLD, 20));
        pin.setBounds(110, 460, 400, 30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setBounds(290, 460, 350, 25);
        pinTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(pinTextField);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Rakeway", Font.BOLD, 20));
        state.setBounds(110, 500, 400, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(290, 500, 350, 25);
        stateTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(stateTextField);
        
        next = new JButton("NEXT");
        next.setBounds(538, 571, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 700);
        setVisible(true);
        setLocation(300, 10);
    }
       
        public void actionPerformed(ActionEvent ae){
            String formno = "" + random;
            String name = nameTextField.getText();
            String fname = fatherTextField.getText();
            String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            String gender = "null";
            if(male.isSelected()){
                gender = "male";
            }else if(female.isSelected()){
                gender = "female";
            }else if(other.isSelected()){
                gender = "other";
            }
            String email = emailTextField.getText();
            String marital = "null";
            if(married.isSelected()){
                marital = "married";
            }else if(unmarried.isSelected()){
                marital = "unmarried";
            }
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String pin = pinTextField.getText();
            String state = stateTextField.getText();
            
            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter The Detailes");
                }
                else{
                  Conn c = new Conn();
                  String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                  c.s.executeUpdate(query);
                  
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                }                
               
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    
    public static void main(String [] args){
        SignupOne s1 = new SignupOne();
        s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }     
}
