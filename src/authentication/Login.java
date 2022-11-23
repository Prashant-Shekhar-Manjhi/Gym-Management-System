package authentication;

import encoder.JavaBase64;
import home.Home;
import jdbc.JdbcConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    private JTextField email;
    private JPasswordField password;
    private JButton btnLogin;
    private JButton btnSign;

    public Login() {
        super("GYM MANAGEMENT SYSTEM");

        //Font
        Font headFont = new Font("serif", Font.BOLD, 48);
        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);
        Font textFont = new Font("serif", Font.PLAIN, 20);

        //Header
        JPanel header;
        header = new JPanel();
        header.setBackground(new Color(0, 0, 0, 60));
        header.setBounds(0, 0, 1540, 100);
        header.setLayout(new GridLayout());
        JLabel headingName = new JLabel("Gym Management System");
        headingName.setHorizontalAlignment(JLabel.CENTER);
        headingName.setVerticalAlignment(JLabel.CENTER);
        headingName.setFont(headFont);
        headingName.setForeground(Color.WHITE);
        header.add(headingName);



        //Login
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBounds(600, 220, 350, 350);
        login.setBackground(new Color(0,0,0, 95));


        JLabel loginLabel = new JLabel("Login Page");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(subHeadingFont);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabel.setBounds(70, 0, 200, 50);
        login.add(loginLabel);

        JLabel userNameLabel = new JLabel("Email");
        userNameLabel.setBounds(20, 70, 100, 50);
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setFont(textFont);
        login.add(userNameLabel);
        email = new JTextField();
        email.setBounds(130, 80, 200, 35);
        email.setFont(new Font("serif", Font.PLAIN, 18));
        email.setMargin(new Insets(5, 5, 5, 5));
        email.setBackground(new Color(0, 0, 0));
        email.setForeground(Color.WHITE);
        login.add(email);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 125, 100, 50);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(textFont);
        login.add(passwordLabel);
        password = new JPasswordField();
        password.setBounds(130, 135,200, 35 );
        password.setFont(new Font("serif", Font.PLAIN, 18));
        password.setMargin(new Insets(5, 5, 5, 5));
        password.setBackground(new Color(0, 0, 0));
        password.setForeground(Color.WHITE);
        login.add(password);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(20, 220, 310, 30);
        btnLogin.setFont(new Font("serif", Font.PLAIN, 16));
        btnLogin.addActionListener(this);
        login.add(btnLogin);
        btnSign = new JButton("Sign Up");
        btnSign.setBounds(20, 260, 310, 30);
        btnSign.setFont(new Font("serif", Font.PLAIN, 16));
        login.add(btnSign);
        btnSign.addActionListener(this);


        //frame
        setLayout(new GridLayout());
        setSize(1200, 700);
        setLocation(150, 50);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //background
        ImageIcon bgImg = new ImageIcon("src/images/background_1.jpg");
        JLabel background = new JLabel("",bgImg, JLabel.CENTER);
        add(background);
        background.add(header);
        background.add(login);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            try{
                String emailInput = email.getText();
                String passwordInput = String.valueOf(password.getPassword());

                if(emailInput.isEmpty() || passwordInput.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Enter valid fields!", "Try Again", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JdbcConnection connection = new JdbcConnection();
                JavaBase64 encoderDecoder = new JavaBase64();
                String query = "SELECT * FROM admins WHERE email = '"+emailInput+"'";
                ResultSet resultSet = connection.stm.executeQuery(query);

                if(resultSet.next()){
                    String encodedPassword = resultSet.getString("password");
                    if(passwordInput.equals(encoderDecoder.decodePassword(encodedPassword))){
                        new Home();
                        this.dispose();
                    }else {
                        JOptionPane.showMessageDialog(this, "Incorrect Password", "Try Again!", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Please Sign Up First!", "Not Registered", JOptionPane.ERROR_MESSAGE);
                }

            }catch(Exception exception){
                JOptionPane.showMessageDialog(this, "Try Again", "Failed", JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource() == btnSign){
            new SignUp();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
