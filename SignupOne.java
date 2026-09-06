package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JDateChooser datechooser;
    JTextField nameTextField, fatherTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    Color darkBlue = new Color(20, 42, 74);
    Color blue = new Color(37, 99, 235);
    Color textDark = new Color(31, 41, 55);
    Color gray = new Color(107, 114, 128);
    Color lightBlue = new Color(239, 246, 255);

    SignupOne() {

        setTitle("New Account Application - Personal Details");
        setSize(1100, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(248, 250, 252));
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 260, 720);
        sidebar.setBackground(darkBlue);
        sidebar.setLayout(null);
        add(sidebar);

        JLabel bankTitle = new JLabel("<html><center>BANK<br>" + "MANAGEMENT<br>"+ "SYSTEM</center></html>");
        bankTitle.setFont(new Font("Arial", Font.BOLD, 25));
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bankTitle.setBounds(20, 45, 220, 110);
        sidebar.add(bankTitle);

        JLabel line = new JLabel();
        line.setBackground(new Color(60, 82, 112));
        line.setOpaque(true);
        line.setBounds(35, 175, 190, 1);
        sidebar.add(line);

        JLabel application = new JLabel("ACCOUNT OPENING");
        application.setFont(new Font("Arial", Font.BOLD, 18));
        application.setForeground(Color.WHITE);
        application.setHorizontalAlignment(SwingConstants.CENTER);
        application.setBounds(25, 220, 210, 35);
        sidebar.add(application);

        JLabel page = new JLabel("<html><center>Step 1 of 3<br>" + "Personal Details</center></html>");
        page.setFont(new Font("Arial", Font.PLAIN, 14));
        page.setForeground(new Color(190, 205, 225));
        page.setHorizontalAlignment(SwingConstants.CENTER);
        page.setBounds(25, 270, 210, 55);
        sidebar.add(page);

        JLabel applicationNo = new JLabel("<html><center>APPLICATION<br>" + "NUMBER<br><b>" + random+ "</b></center></html>");
        applicationNo.setFont(new Font("Arial", Font.PLAIN, 13));
        applicationNo.setForeground(new Color(170, 190, 215));
        applicationNo.setHorizontalAlignment(SwingConstants.CENTER);
        applicationNo.setBounds(25, 390, 210, 75);
        sidebar.add(applicationNo);
        
        JLabel secure = new JLabel("SECURE ACCOUNT OPENING");
        secure.setFont(new Font("Arial", Font.BOLD, 11));
        secure.setForeground(new Color(150, 175, 205));
        secure.setHorizontalAlignment(SwingConstants.CENTER);
        secure.setBounds(20, 650, 220, 25);
        sidebar.add(secure);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(260, 0, 840, 720);
        mainPanel.setBackground(new Color(248, 250, 252));
        mainPanel.setLayout(null);
        add(mainPanel);

        JLabel heading = new JLabel("New Account Application");
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(textDark);
        heading.setBounds(45, 25, 500, 40);
        mainPanel.add(heading);
        
        JLabel subtitle = new JLabel("Page 1 • Enter your personal details");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(gray);
        subtitle.setBounds(48, 65, 400, 25);
        mainPanel.add(subtitle);

        JPanel formCard = new JPanel();
        formCard.setBounds(45, 100, 750, 555);
        formCard.setBackground(Color.WHITE);
        formCard.setLayout(null);
        formCard.setBorder(new RoundedBorder(1,new Color(225, 229, 235),18));
        mainPanel.add(formCard);

        JLabel nameLabel = createLabel("FULL NAME");
        nameLabel.setBounds(35, 25, 200, 22);
        formCard.add(nameLabel);

        nameTextField = createTextField();
        nameTextField.setBounds(35, 50, 315, 38);
        formCard.add(nameTextField);

        JLabel fatherLabel = createLabel("FATHER'S NAME");
        fatherLabel.setBounds(380, 25, 200, 22);
        formCard.add(fatherLabel);

        fatherTextField = createTextField();
        fatherTextField.setBounds(380, 50, 315, 38);
        formCard.add(fatherTextField);

        JLabel dobLabel = createLabel("DATE OF BIRTH");
        dobLabel.setBounds(35, 105, 200, 22);
        formCard.add(dobLabel);

        datechooser = new JDateChooser();
        datechooser.setBounds(35, 130, 315, 38);
        datechooser.setFont(new Font("Arial", Font.PLAIN, 14));
        datechooser.setDateFormatString("dd-MM-yyyy");
        datechooser.setBorder(new RoundedBorder(1,new Color(209, 213, 219),8));
        formCard.add(datechooser);

        JLabel genderLabel = createLabel("GENDER");
        genderLabel.setBounds(380, 105, 200, 22);
        formCard.add(genderLabel);

        male = createRadioButton("Male");
        male.setBounds(380, 130, 90, 38);
        formCard.add(male);

        female = createRadioButton("Female");
        female.setBounds(475, 130, 100, 38);
        formCard.add(female);

        other = createRadioButton("Other");
        other.setBounds(580, 130, 100, 38);
        formCard.add(other);

        ButtonGroup genderGroup = new ButtonGroup();

        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel emailLabel = createLabel("EMAIL ADDRESS");
        emailLabel.setBounds(35, 185, 200, 22);
        formCard.add(emailLabel);

        emailTextField = createTextField();
        emailTextField.setBounds(35, 210, 315, 38);
        formCard.add(emailTextField);

        JLabel maritalLabel = createLabel("MARITAL STATUS");
        maritalLabel.setBounds(380, 185, 200, 22);
        formCard.add(maritalLabel);

        married = createRadioButton("Married");
        married.setBounds(380, 210, 100, 38);
        formCard.add(married);

        unmarried = createRadioButton("Unmarried");
        unmarried.setBounds(485, 210, 120, 38);
        formCard.add(unmarried);

        ButtonGroup maritalGroup =new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        JLabel addressLabel = createLabel("ADDRESS");
        addressLabel.setBounds(35, 265, 200, 22);
        formCard.add(addressLabel);

        addressTextField = createTextField();
        addressTextField.setBounds(35, 290, 660, 38);
        formCard.add(addressTextField);

        JLabel cityLabel = createLabel("CITY");
        cityLabel.setBounds(35, 345, 200, 22);
        formCard.add(cityLabel);

        cityTextField = createTextField();
        cityTextField.setBounds(35, 370, 205, 38);
        formCard.add(cityTextField);

        JLabel pinLabel = createLabel("PIN CODE");
        pinLabel.setBounds(265, 345, 200, 22);
        formCard.add(pinLabel);

        pinTextField = createTextField();
        pinTextField.setBounds(265, 370, 205, 38);
        formCard.add(pinTextField);

        JLabel stateLabel = createLabel("STATE");
        stateLabel.setBounds(495, 345, 200, 22);
        formCard.add(stateLabel);

        stateTextField = createTextField();
        stateTextField.setBounds(495, 370, 200, 38);
        formCard.add(stateTextField);

        JLabel required = new JLabel("* Please fill all required details");
        required.setFont(new Font("Arial", Font.PLAIN, 12));
        required.setForeground(gray);
        required.setBounds(35, 425, 300, 25);
        formCard.add(required);

        next = new JButton("CONTINUE  →");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(blue);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setBounds(35, 470, 660, 48);
        next.addActionListener(this);
        formCard.add(next);

        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(textDark);
        return label;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(textDark);
        field.setBorder(new RoundedBorder(1,new Color(209, 213, 219),8));
        field.setBackground(Color.WHITE);
        return field;
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radio = new JRadioButton(text);
        radio.setFont(new Font("Arial", Font.PLAIN, 13));
        radio.setForeground(textDark);
        radio.setBackground(Color.WHITE);
        radio.setFocusPainted(false);
        return radio;
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = String.valueOf(random);
        String name = nameTextField.getText().trim();
        String fname = fatherTextField.getText().trim();
        String dob = "";
        if (datechooser.getDate() != null) {
            dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText().trim();
        }
        String gender = "";
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        } else if (other.isSelected()) {
            gender = "other";
        }
        String email = emailTextField.getText().trim();
        String marital = "";
        if (married.isSelected()) {
            marital = "married";
        } else if (unmarried.isSelected()) {
            marital = "unmarried";
        }
        String address = addressTextField.getText().trim();
        String city = cityTextField.getText().trim();
        String pin = pinTextField.getText().trim();
        String state = stateTextField.getText().trim();

        if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || gender.isEmpty() || email.isEmpty() || marital.isEmpty() || address.isEmpty() || city.isEmpty() || pin.isEmpty() || state.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please fill all the required details.","Incomplete Details",JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this,"Please enter a valid email address.","Invalid Email",JOptionPane.WARNING_MESSAGE);
            emailTextField.requestFocus();
            return;
        }

        if (!pin.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(this,"PIN Code must contain exactly 6 digits.","Invalid PIN Code",JOptionPane.WARNING_MESSAGE);
            pinTextField.requestFocus();
            return;
        }

        try {
            Conn c = new Conn();
            String query ="INSERT INTO signup " + "(formno, name, fname, dob, gender, " + "email, marital, address, city, pin, state) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps =c.c.prepareStatement(query);
            
            ps.setString(1, formno);
            ps.setString(2, name);
            ps.setString(3, fname);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, marital);
            ps.setString(8, address);
            ps.setString(9, city);
            ps.setString(10, pin);
            ps.setString(11, state);
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(this,"Personal details saved successfully!","Account Application",JOptionPane.INFORMATION_MESSAGE);
            
            setVisible(false);            
            new SignupTwo(formno).setVisible(true);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Unable to save details.\n"+ "Error: " + e.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    static class RoundedBorder implements javax.swing.border.Border {
        private int thickness;
        private Color color;
        private int radius;

        RoundedBorder(int thickness,Color color,int radius) {
            this.thickness = thickness;
            this.color = color;
            this.radius = radius;
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness + 3,thickness + 8,thickness + 3,thickness + 8);
        }
        
        public boolean isBorderOpaque() {
            return false;
        }
        
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
            Graphics2D g2 =(Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x + thickness / 2,y + thickness / 2,width - thickness,height - thickness,radius,radius);
            g2.dispose();
        }
    }

    public static void main(String[] args) 
    {
        new SignupOne();
    }
}
