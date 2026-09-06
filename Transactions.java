package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, cash, fast_cash, pin, mini_statement, balance, exit;
    String pinnumber;

    Color darkBlue = new Color(8, 30, 68);
    Color blue = new Color(35, 91, 210);
    Color lightBlue = new Color(235, 242, 255);
    Color textColor = new Color(20, 35, 65);
    Color gray = new Color(100, 110, 125);

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Bank Management System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel =new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 251));

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(250, 650));
        sidebar.setBackground(darkBlue);
        sidebar.setLayout(null);

        JLabel bankIcon =new JLabel("₹");
        bankIcon.setFont(new Font("Segoe UI",Font.BOLD,48));
        bankIcon.setForeground(Color.WHITE);
        bankIcon.setHorizontalAlignment(SwingConstants.CENTER);
        bankIcon.setBounds(80,30,90,70);
        sidebar.add(bankIcon);

        JLabel bankName =new JLabel("<html><center>BANK<br>"+ "MANAGEMENT<br>"+ "SYSTEM</center></html>");
        bankName.setFont(new Font("Segoe UI",Font.BOLD,18));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.CENTER);
        bankName.setBounds(25,100,200,85);
        sidebar.add(bankName);

        JPanel separator =new JPanel();
        separator.setBackground(new Color(70, 100, 160));
        separator.setBounds(30,205,190,2);
        sidebar.add(separator);

        JButton dashboard =createSideButton("⌂   Dashboard");
        dashboard.setBounds(20,230,210,45);
        sidebar.add(dashboard);
        
        JButton depositMenu =createSideButton("＋   Deposit");
        depositMenu.setBounds(20,285,210,45);
        depositMenu.addActionListener(this);
        sidebar.add(depositMenu);

        JButton withdrawMenu =createSideButton("−   Withdraw");
        withdrawMenu.setBounds(20,340,210,45);
        withdrawMenu.addActionListener(this);
        sidebar.add(withdrawMenu);

        JButton fastCashMenu =createSideButton("⚡   Fast Cash");
        fastCashMenu.setBounds(20,395,210,45);
        fastCashMenu.addActionListener(this);
        sidebar.add(fastCashMenu);

        JButton statementMenu =createSideButton("▤   Mini Statement");
        statementMenu.setBounds(20,450,210,45);
        statementMenu.addActionListener(this);
        sidebar.add(statementMenu);

        JButton logout =createSideButton("↪   Logout");
        logout.setBounds(20,560,210,45);
        logout.addActionListener(e -> {setVisible(false);new BMS();});
        sidebar.add(logout);

        mainPanel.add(sidebar,BorderLayout.WEST);

        JPanel content =new JPanel();
        content.setBackground(new Color(245, 247, 251));
        content.setLayout(null);

        JLabel heading =new JLabel("Dashboard");
        heading.setFont(new Font("Segoe UI",Font.BOLD,30));
        heading.setForeground(textColor);
        heading.setBounds(40,30,300,45);
        content.add(heading);

        JLabel welcome =new JLabel("Welcome back!");
        welcome.setFont(new Font("Segoe UI",Font.PLAIN,15));
        welcome.setForeground(gray);
        welcome.setBounds(40,72,250,30);
        content.add(welcome);

        JLabel user =new JLabel("👤");
        user.setFont(new Font("Segoe UI Emoji",Font.PLAIN,26));
        user.setHorizontalAlignment(SwingConstants.CENTER);
        user.setBackground(lightBlue);
        user.setOpaque(true);
        user.setBounds(650,35,55,55);
        content.add(user);

        JPanel accountCard =new JPanel();
        accountCard.setLayout(null);
        accountCard.setBackground(darkBlue);
        accountCard.setBounds(40,125,665,135);
        content.add(accountCard);

        JLabel accountTitle =new JLabel("ACCOUNT");
        accountTitle.setFont(new Font("Segoe UI",Font.BOLD,13));
        accountTitle.setForeground(new Color(170, 190, 225));
        accountTitle.setBounds(25,20,150,25);
        accountCard.add(accountTitle);

        JLabel accountNumber =new JLabel("••••  ••••  ••••");
        accountNumber.setFont(new Font("Segoe UI",Font.BOLD,21));
        accountNumber.setForeground(Color.WHITE);
        accountNumber.setBounds(25,45,300,35);
        accountCard.add(accountNumber);

        JLabel status =new JLabel("● ACTIVE");
        status.setFont(new Font("Segoe UI",Font.BOLD,12));
        status.setForeground(new Color(80,220,120));
        status.setBounds(530,25,100,25);
        accountCard.add(status);
        
        JLabel secure =new JLabel("Your account is secure");
        secure.setFont(new Font("Segoe UI",Font.PLAIN,13));
        secure.setForeground(new Color(190, 205, 230));
        secure.setBounds(25,90,250,25);
        accountCard.add(secure);

        JLabel transactionTitle =new JLabel("Banking Services");
        transactionTitle.setFont(new Font("Segoe UI",Font.BOLD,22));
        transactionTitle.setForeground(textColor);
        transactionTitle.setBounds(40,285,300,35);
        content.add(transactionTitle);

        deposit =createServiceButton("DEPOSIT","Add money to account");
        deposit.setBounds(40,335,200,90);
        content.add(deposit);
        
        cash =createServiceButton("WITHDRAW","Withdraw money");
        cash.setBounds(270,335,200,90);
        content.add(cash);
        
        fast_cash =createServiceButton("FAST CASH","Quick cash withdrawal");
        fast_cash.setBounds(500,335,205,90);
        content.add(fast_cash);
        
        mini_statement =createServiceButton("MINI STATEMENT","View recent transactions");
        mini_statement.setBounds(40,445,200,90);
        content.add(mini_statement);
        
        balance =createServiceButton("BALANCE ENQUIRY","Check account balance");
        balance.setBounds(270,445,200,90);
        content.add(balance);
        
        pin =createServiceButton("PIN CHANGE","Change your ATM PIN");
        pin.setBounds(500,445,205,90);
        content.add(pin);

        exit =new JButton("EXIT");
        exit.setFont(new Font("Segoe UI",Font.BOLD,13));
        exit.setForeground(new Color(200,55,55));
        exit.setBackground(Color.WHITE);
        exit.setFocusPainted(false);
        exit.setBorder(BorderFactory.createLineBorder(new Color(230,200,200)));
        exit.setBounds(610,555,95,35);
        exit.addActionListener(this);
        content.add(exit);
        
        mainPanel.add(content,BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }
    private JButton createSideButton(String text)
    {
        JButton button =new JButton(text);
        button.setFont(new Font("Segoe UI",Font.BOLD,14));
        button.setForeground(new Color(215,225,245));
        button.setBackground(darkBlue);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(new EmptyBorder(0,18,0,0));
        button.setFocusPainted(false);
        return button;
    }
    private JButton createServiceButton(String title,String subtitle) 
    {
        JButton button =new JButton();
        button.setLayout(null);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(225,230,240)));
        
        JLabel titleLabel =new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
        titleLabel.setForeground(textColor);
        titleLabel.setBounds(20,18,170,25);
        button.add(titleLabel);
        
        JLabel subtitleLabel =new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Segoe UI",Font.PLAIN,11));
        subtitleLabel.setForeground(gray);
        subtitleLabel.setBounds(20,48,175,20);
        button.add(subtitleLabel);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == cash) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fast_cash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == mini_statement) {
            new Ministatement(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == pin) {
            setVisible(false);
          new Pinchange(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == balance) {
            setVisible(false);
           new Balance(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Transactions(""));
    }
}
