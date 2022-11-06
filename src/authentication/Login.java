package authentication;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

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
        JTextField email = new JTextField();
        email.setBounds(130, 80, 200, 35);
        email.setFont(textFont);
        email.setMargin(new Insets(5, 5, 5, 5));
        email.setBackground(new Color(0, 0, 0));
        email.setForeground(Color.WHITE);
        login.add(email);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 125, 100, 50);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(textFont);
        login.add(passwordLabel);
        JPasswordField password = new JPasswordField();
        password.setBounds(130, 135,200, 35 );
        password.setFont(textFont);
        password.setMargin(new Insets(5, 5, 5, 5));
        password.setBackground(new Color(0, 0, 0));
        password.setForeground(Color.WHITE);
        login.add(password);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(20, 220, 310, 30);
        login.add(btnLogin);
        JButton btnSign = new JButton("Sign up");
        btnSign.setBounds(20, 260, 310, 30);
        login.add(btnSign);


        //frame
        setLayout(new GridLayout());
        setSize(1200, 700);
        setLocation(150, 50);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //background
        ImageIcon bgImg = new ImageIcon("src/images/background_1.jpg");
        JLabel background = new JLabel("",bgImg, JLabel.CENTER);
        add(background);
        background.add(header);
        background.add(login);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

}
