package authentication;

import jdbc.JdbcConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUp extends JFrame implements ActionListener {

    private JTextField email;
    private JTextField name;
    private JPasswordField password;
    private JPasswordField confirmPassword;

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

        email = new JTextField();
        email.setBounds(150, 60, 250, 30);
        email.setFont(new Font("serif", Font.PLAIN, 16));
        email.setMargin(new Insets(5, 5, 5, 5));
        add(email);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 95, 100, 50);
        nameLabel.setFont(textFont);
        add(nameLabel);

        name = new JTextField();
        name.setBounds(150, 110, 250, 30);
        name.setFont(new Font("serif", Font.PLAIN, 16));
        name.setMargin(new Insets(5, 5, 5, 5));
        add(name);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 145, 100, 50);
        passwordLabel.setFont(textFont);
        add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(150, 160, 250, 30);
        password.setMargin(new Insets(5,5,5,5));
        add(password);

        JLabel confirmPasswordLabel = new JLabel("Confirm");
        confirmPasswordLabel.setBounds(30, 195, 100, 50);
        confirmPasswordLabel.setFont(textFont);
        add(confirmPasswordLabel);

        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(150, 210, 250, 30);
        confirmPassword.setMargin(new Insets(5,5,5,5));
        add(confirmPassword);

        JButton btnSignUp = new JButton("Create New Account");
        btnSignUp.setBounds(30, 280, 370, 40);
        btnSignUp.setFont(new Font("serif", Font.PLAIN, 16));
        btnSignUp.addActionListener(this);
        add(btnSignUp);

        //Frame...
        setLayout(null);
        setSize(450, 400);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = this.email.getText().toLowerCase();
        String name = this.name.getText();
        String password = String.valueOf(this.password.getPassword());
        String confirmPassword = String.valueOf(this.confirmPassword.getPassword());

        if(email.isEmpty() && name.isEmpty() && password.isEmpty() && confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter All Fields", "Try Again!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "Try Again!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        addUserNameToDatabase(email, name, password);
    }

    private void addUserNameToDatabase(String email, String name, String password) {
        try{
            JdbcConnection con = new JdbcConnection();
            String query = "insert into admins (email, name, password) values('"+email+"', '"+name+"', '"+password+"')";
            con.stm.executeUpdate(query);

            JOptionPane.showMessageDialog(this, "You are registered as admin!", "congratulation", JOptionPane.PLAIN_MESSAGE);

            con.stm.close();
            con.con.close();
            this.dispose();
        }catch (Exception e){e.printStackTrace();}
    }
}
