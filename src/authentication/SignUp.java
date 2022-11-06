package authentication;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {
    public SignUp(){
        super("GYM MANAGEMENT SYSTEM");

        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);
        Font textFont = new Font("serif", Font.PLAIN, 22);


        JLabel signUpHeading = new JLabel("Admin Sign Up");
        signUpHeading.setFont(subHeadingFont);
        signUpHeading.setBounds(140, 0, 200, 50);
        add(signUpHeading);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(30, 45, 100, 50);
        emailLabel.setFont(textFont);
        add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(150, 60, 250, 30);
        email.setFont(new Font("serif", Font.PLAIN, 16));
        email.setMargin(new Insets(5, 5, 5, 5));
        add(email);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 95, 100, 50);
        nameLabel.setFont(textFont);
        add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(150, 110, 250, 30);
        name.setFont(new Font("serif", Font.PLAIN, 16));
        name.setMargin(new Insets(5, 5, 5, 5));
        add(name);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 145, 100, 50);
        passwordLabel.setFont(textFont);
        add(passwordLabel);

        JPasswordField password = new JPasswordField();
        password.setBounds(150, 160, 250, 30);
        password.setMargin(new Insets(5,5,5,5));
        add(password);

        JLabel confirmPasswordLabel = new JLabel("Confirm");
        confirmPasswordLabel.setBounds(30, 195, 100, 50);
        confirmPasswordLabel.setFont(textFont);
        add(confirmPasswordLabel);

        JPasswordField confirmPassword = new JPasswordField();
        confirmPassword.setBounds(150, 210, 250, 30);
        confirmPassword.setMargin(new Insets(5,5,5,5));
        add(confirmPassword);

        JButton btnSignUp = new JButton("Create New Account");
        btnSignUp.setBounds(30, 280, 370, 40);
        btnSignUp.setFont(new Font("serif", Font.PLAIN, 16));
        add(btnSignUp);

        //Frame...
        setLayout(null);
        setSize(450, 400);
        setLocation(550, 200);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
