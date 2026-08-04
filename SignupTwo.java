package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadharTextField ;
    JButton next;
    JRadioButton CY, CN, EY, EN;
    JComboBox Occupation, Religion, Category, Income, Education;
    String formno;
    
    public SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        setTitle(" NEW ACCOUNT APPLICATION FORM - PAGE 2");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 0, 100, 100);
        add(label);
        
        JLabel det = new JLabel("Page 2 : Additional Details ");
        det.setFont(new Font("Rakeway", Font.BOLD, 22));
        det.setBounds(270, 30, 400, 30);
        add(det);
        
        JLabel religion = new JLabel("RELIGION :");
        religion.setFont(new Font("Rakeway", Font.BOLD, 16));
        religion.setBounds(110, 140, 400, 25);
        add(religion);
        
        String valriligion[] = {"","Hindu", "Muslim", "Sikh", "Christian", "Other"}; 
        Religion = new JComboBox(valriligion);
        Religion.setBackground(Color.WHITE);
        Religion.setBounds(300, 140, 350, 25);
        add(Religion);
        
        JLabel category = new JLabel("CATEGORY :");
        category.setFont(new Font("Rakeway", Font.BOLD, 16));
        category.setBounds(110, 180, 400, 25);
        add(category);
        
        String valcategory[] = {"","General", "OBC", "ST", "SC", "Other"}; 
        Category = new JComboBox(valcategory);
        Category.setBackground(Color.WHITE);
        Category.setBounds(300, 180, 350, 25);
        add(Category);
        
        JLabel income = new JLabel("INCOME :");
        income.setFont(new Font("Rakeway", Font.BOLD, 16));
        income.setBounds(110, 220, 400, 25);
        add(income);
        
        String valincome[] = {"","Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"}; 
        Income = new JComboBox(valincome);
        Income.setBackground(Color.WHITE);
        Income.setBounds(300, 220, 350, 25);
        add(Income);
        
        JLabel education = new JLabel("EDUCATIONAL ");
        education.setFont(new Font("Rakeway", Font.BOLD, 16));
        education.setBounds(110, 260, 400, 25);
        add(education);
        
        JLabel qualification = new JLabel("QUALIFICATION :");
        qualification.setFont(new Font("Rakeway", Font.BOLD, 16));
        qualification.setBounds(110, 280, 400, 25);
        add(qualification);
        
        String valeducation[] = {"","Non-Graduate", "Graduate", "Post Gradate", "Doctrate", "Others"}; 
        Education = new JComboBox(valeducation);
        Education.setBackground(Color.WHITE);
        Education.setBounds(300, 280, 350, 25);
        add(Education);
        
        JLabel occupation = new JLabel("OCCUPATION :");
        occupation.setFont(new Font("Rakeway", Font.BOLD, 16));
        occupation.setBounds(110, 320, 400, 25);
        add(occupation);
        
        String valoccupation[] = {"","Salaried", "Self-Emplyomed", "Business", "Student", "Retired", "Other"}; 
        Occupation = new JComboBox(valoccupation);
        Occupation.setBackground(Color.WHITE);
        Occupation.setBounds(300, 320, 350, 25);
        add(Occupation);
        
        JLabel pan = new JLabel("PAN NO. :");
        pan.setFont(new Font("Rakeway", Font.BOLD, 16));
        pan.setBounds(110, 360, 400, 25);
        add(pan);   
        
        panTextField = new JTextField();
        panTextField.setBounds(300, 360, 350, 25);
        panTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(panTextField);
        
        JLabel aadhar = new JLabel("AADHAR NO. :");
        aadhar.setFont(new Font("Rakeway", Font.BOLD, 16));
        aadhar.setBounds(110, 400, 400, 25);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setBounds(300, 400, 350, 25);
        aadharTextField.setFont(new Font("Rakeway", Font.PLAIN, 15));
        add(aadharTextField);
        
        JLabel citizen = new JLabel("SENIOR CITIZEN :");
        citizen.setFont(new Font("Rakeway", Font.BOLD, 16));
        citizen.setBounds(110, 440, 400, 25);
        add(citizen);
        
        CY = new JRadioButton("YES");
        CY.setBounds(300, 440, 100, 25);
        CY.setBackground(Color.WHITE);
        add(CY);
        
        CN = new JRadioButton("NO");
        CN.setBackground(Color.WHITE);
        CN.setBounds(440, 440, 100, 25);
        add(CN);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(CY);
        citizengroup.add(CN);
        
        JLabel existing_ac = new JLabel("EXISTING ACCOUNT :");
        existing_ac.setFont(new Font("Rakeway", Font.BOLD, 16));
        existing_ac.setBounds(110, 480, 400, 25);
        add(existing_ac);
        
        EY = new JRadioButton("YES");
        EY.setBounds(300, 480, 100, 25);
        EY.setBackground(Color.WHITE);
        add(EY);
        
        EN = new JRadioButton("NO");
        EN.setBackground(Color.WHITE);
        EN.setBounds(440, 480, 100, 25);
        add(EN);
        
        ButtonGroup existingacgroup = new ButtonGroup();
        existingacgroup.add(EY);
        existingacgroup.add(EN);
        
        next = new JButton("NEXT");
        next.setBounds(548, 565, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
    setSize(800,700);
    setVisible(true);
    setLocation(300,10);
    }
    public void actionPerformed(ActionEvent e){
        
            String sreligion = (String )Religion.getSelectedItem();
            String scategory = (String) Category.getSelectedItem();
            String sincome = (String) Income.getSelectedItem();
            String seducation = (String) Education.getSelectedItem();
            String soccupation = (String) Occupation.getSelectedItem();
            String citizen = "null";
            if(CY.isSelected()){
                citizen = "Yes";
            }else if(CN.isSelected()){
                citizen = "No";
            }
            String existingac = "null";
            if(EY.isSelected()){
                existingac = "Yes";
            }else if(EN.isSelected()){
                existingac = "NO";
            }
            String span = panTextField.getText();
            String saadhar = aadharTextField.getText();
            
            try{
                if(Religion.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter The Detailes");
                }
                else{
                  Conn c = new Conn();
                  String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+citizen+"', '"+existingac+"', '"+span+"', '"+saadhar+"')";
                  c.s.executeUpdate(query);
                  
                  setVisible(false);
                new SignupThree(formno).setVisible(true);
                }                
               
            }catch (Exception ae){
                System.out.println(ae);
            }
        }
        
    public static void main(String []args){
    SignupTwo s1 = new SignupTwo("");
    s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}    
}
