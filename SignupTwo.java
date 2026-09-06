package bms;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next, back;
    JRadioButton CY, CN, EY, EN;
    JComboBox<String> Occupation, Religion, Category, Income, Education;
    String formno;

    Color darkBlue = new Color(15, 35, 65);
    Color blue = new Color(35, 99, 180);
    Color lightBlue = new Color(240, 245, 252);
    Color textColor = new Color(35, 45, 60);
    Color white = Color.WHITE;

    SignupTwo(String formno) {
        this.formno = formno;
        setTitle("Bank Management System - Account Opening");
        setSize(1100, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(lightBlue);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(darkBlue);
        sidebar.setBounds(0, 0, 280, 720);
        add(sidebar);

        JLabel bankTitle = new JLabel("<html><center>BANK<br>MANAGEMENT<br>SYSTEM</center></html>");
        bankTitle.setFont(new Font("Arial", Font.BOLD, 27));
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bankTitle.setBounds(20, 55, 240, 120);
        sidebar.add(bankTitle);

        JLabel line = new JLabel();
        line.setBackground(new Color(70, 120, 190));
        line.setOpaque(true);
        line.setBounds(45, 195, 190, 2);
        sidebar.add(line);

        JLabel accountOpening = new JLabel("ACCOUNT OPENING");
        accountOpening.setFont(new Font("Arial", Font.BOLD, 18));
        accountOpening.setForeground(Color.WHITE);
        accountOpening.setHorizontalAlignment(SwingConstants.CENTER);
        accountOpening.setBounds(20, 225, 240, 30);
        sidebar.add(accountOpening);

        JLabel step = new JLabel("STEP 2 OF 3");
        step.setFont(new Font("Arial", Font.BOLD, 15));
        step.setForeground(new Color(150, 200, 255));
        step.setHorizontalAlignment(SwingConstants.CENTER);
        step.setBounds(20, 270, 240, 30);
        sidebar.add(step);
        
        JPanel progressBackground = new JPanel();
        progressBackground.setBackground(new Color(55, 75, 105));
        progressBackground.setBounds(45, 315, 190, 8);
        sidebar.add(progressBackground);

        JPanel progress = new JPanel();
        progress.setBackground(new Color(70, 150, 230));
        progress.setBounds(45, 315, 125, 8);
        sidebar.add(progress);

        JLabel application = new JLabel("<html><center>Application No.<br><b>" + formno + "</b></center></html>");
        application.setFont(new Font("Arial", Font.PLAIN, 14));
        application.setForeground(Color.LIGHT_GRAY);
        application.setHorizontalAlignment(SwingConstants.CENTER);
        application.setBounds(20, 350, 240, 55);
        sidebar.add(application);

        JLabel secure = new JLabel("<html><center>Your information is securely<br>" + "stored in the bank database.</center></html>");
        secure.setFont(new Font("Arial", Font.PLAIN, 12));
        secure.setForeground(new Color(180, 190, 205));
        secure.setHorizontalAlignment(SwingConstants.CENTER);
        secure.setBounds(20, 600, 240, 50);
        sidebar.add(secure);

        JLabel heading = new JLabel("Additional Details");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(textColor);
        heading.setBounds(330, 35, 400, 40);
        add(heading);

        JLabel subHeading = new JLabel("Please provide your additional personal information");
        subHeading.setFont(new Font("Arial", Font.PLAIN, 14));
        subHeading.setForeground(new Color(100, 110, 125));
        subHeading.setBounds(332, 78, 500, 25);
        add(subHeading);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(320, 120, 730, 510);
        formPanel.setBorder(new RoundedBorder(18, new Color(220, 225, 235)));
        add(formPanel);

        addLabel(formPanel, "RELIGION", 35, 30);
        String[] religionValues = {"Select Religion","Hindu","Muslim","Sikh","Christian","Other"};
        Religion = new JComboBox<>(religionValues);
        styleComboBox(Religion);
        Religion.setBounds(250, 27, 420, 38);
        formPanel.add(Religion);

        addLabel(formPanel, "CATEGORY", 35, 85);
        String[] categoryValues = {"Select Category","General","OBC","ST","SC","Other"};
        Category = new JComboBox<>(categoryValues);
        styleComboBox(Category);
        Category.setBounds(250, 82, 420, 38);
        formPanel.add(Category);
        
        addLabel(formPanel, "INCOME", 35, 140);
        String[] incomeValues = {"Select Income","Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        Income = new JComboBox<>(incomeValues);
        styleComboBox(Income);
        Income.setBounds(250, 137, 420, 38);
        formPanel.add(Income);
        
        addLabel(formPanel, "EDUCATIONAL QUALIFICATION", 35, 195);
        String[] educationValues = {"Select Qualification","Non-Graduate","Graduate","Post Graduate","Doctorate","Others"};
        Education = new JComboBox<>(educationValues);
        styleComboBox(Education);
        Education.setBounds(250, 192, 420, 38);
        formPanel.add(Education);
        
        addLabel(formPanel, "OCCUPATION", 35, 250);
        String[] occupationValues = {"Select Occupation","Salaried","Self-Employed","Business","Student","Retired","Other"};
        Occupation = new JComboBox<>(occupationValues);
        styleComboBox(Occupation);
        Occupation.setBounds(250, 247, 420, 38);
        formPanel.add(Occupation);
        
        addLabel(formPanel, "PAN NUMBER", 35, 305);
        panTextField = createTextField();
        panTextField.setBounds(250, 302, 420, 38);
        formPanel.add(panTextField);
        
        addLabel(formPanel, "AADHAAR NUMBER", 35, 360);
        aadharTextField = createTextField();
        aadharTextField.setBounds(250, 357, 420, 38);
        formPanel.add(aadharTextField);
        
        addLabel(formPanel, "SENIOR CITIZEN", 35, 415);
        CY = createRadioButton("YES");
        CY.setBounds(250, 412, 80, 30);
        formPanel.add(CY);

        CN = createRadioButton("NO");
        CN.setBounds(340, 412, 80, 30);
        formPanel.add(CN);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(CY);
        citizenGroup.add(CN);
        
        addLabel(formPanel, "EXISTING ACCOUNT", 440, 415);
        EY = createRadioButton("YES");
        EY.setBounds(575, 412, 65, 30);
        formPanel.add(EY);

        EN = createRadioButton("NO");
        EN.setBounds(640, 412, 65, 30);
        formPanel.add(EN);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(EY);
        existingGroup.add(EN);

        back = new JButton("BACK");
        back.setBounds(760, 640, 120, 40);
        styleButton(back, new Color(100, 110, 125));
        back.addActionListener(this);
        add(back);

        next = new JButton("NEXT  →");
        next.setBounds(890, 640, 160, 40);
        styleButton(next, blue);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }
    
    private void addLabel(JPanel panel,String text,int x,int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(textColor);
        label.setBounds(x, y, 210, 30);
        panel.add(label);
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(textColor);
        field.setBackground(Color.WHITE);
        field.setBorder(new RoundedBorder(10,new Color(205, 212, 222)));
        return field;
    }

    private void styleComboBox(JComboBox<String> combo) {
        combo.setFont(new Font("Arial", Font.PLAIN, 14));
        combo.setBackground(Color.WHITE);
        combo.setForeground(textColor);
        combo.setBorder(new RoundedBorder(10,new Color(205, 212, 222)));
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radio = new JRadioButton(text);
        radio.setFont(new Font("Arial", Font.PLAIN, 13));
        radio.setForeground(textColor);
        radio.setBackground(Color.WHITE);
        radio.setFocusPainted(false);
        return radio;
    }

    private void styleButton(JButton button,Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            
            new SignupOne().setVisible(true);
            return;
        }
        
        if (e.getSource() == next) {
            String sreligion =(String) Religion.getSelectedItem();
            String scategory =(String) Category.getSelectedItem();
            String sincome =(String) Income.getSelectedItem();
            String seducation =(String) Education.getSelectedItem();
            String soccupation =(String) Occupation.getSelectedItem();
            String citizen = "";
            if (CY.isSelected()) {
                citizen = "Yes";
            } else if (CN.isSelected()) {
                citizen = "No";
            }
            String existingac = "";
            if (EY.isSelected()) {
                existingac = "Yes";
            } else if (EN.isSelected()) {
                existingac = "No";
            }
            String span =panTextField.getText().trim().toUpperCase();
            String saadhar =aadharTextField.getText().trim();

            if (Religion.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,"Please select your religion.");
                return;
            }
            if (Category.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,"Please select your category.");
                return;
            }
            if (Income.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,"Please select your income.");
                return;
            }
            if (Education.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,"Please select your educational qualification.");
                return;
            }
            if (Occupation.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,"Please select your occupation.");
                return;
            }
            if (span.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please enter PAN number.");
                panTextField.requestFocus();
                return;
            }
            
            if (!span.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
                JOptionPane.showMessageDialog(this,"Please enter a valid PAN number.\n" + "Example: ABCDE1234F");
                panTextField.requestFocus();
                return;
            }
            if (saadhar.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please enter Aadhaar number.");
                aadharTextField.requestFocus();
                return;
            }
            
            if (!saadhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(this,"Aadhaar number must contain exactly 12 digits.");
                aadharTextField.requestFocus();
                return;
            }
            if (!CY.isSelected() && !CN.isSelected()) {
                JOptionPane.showMessageDialog(this,"Please select Senior Citizen status.");
                return;
            }
            if (!EY.isSelected() && !EN.isSelected()) {
                JOptionPane.showMessageDialog(this,"Please select Existing Account status.");
                return;
            }

            Conn c = null;
            PreparedStatement ps = null;
            try {
                c = new Conn();
                String query ="INSERT INTO signuptwo " + "(formno, religion, category, income, education, " + "occupation, seniorcitizen, existingaccount, pan, aadhar) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                ps = c.c.prepareStatement(query);
                ps.setString(1, formno);
                ps.setString(2, sreligion);
                ps.setString(3, scategory);
                ps.setString(4, sincome);
                ps.setString(5, seducation);
                ps.setString(6, soccupation);
                ps.setString(7, citizen);
                ps.setString(8, existingac);
                ps.setString(9, span);
                ps.setString(10, saadhar);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Additional details saved successfully.");

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Database Error: " + ex.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
    }

    static class RoundedBorder extends AbstractBorder {
        private int radius;
        private Color color;

        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }
        
        public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
            Graphics2D g2 =(Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(x,y,width - 1,height - 1,radius,radius);
            g2.dispose();
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(8,12,8,12);
        }
        
        public Insets getBorderInsets(Component c,Insets insets) {
            insets.left = 12;
            insets.right = 12;
            insets.top = 8;
            insets.bottom = 8;
            return insets;
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            SignupTwo s2 = new SignupTwo("1234");
            s2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
