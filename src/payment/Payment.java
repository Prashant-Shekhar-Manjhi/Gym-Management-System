package payment;

import javax.swing.*;
import java.awt.*;

public class Payment extends JFrame {
    private JTextField paymentId, paymentDate;
    public Payment(){
        super("GYM MANAGEMENT SYSTEM");

        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);
        Font textFont = new Font("serif", Font.PLAIN, 20);


        JLabel paymentHeading = new JLabel("Payment");
        paymentHeading.setFont(subHeadingFont);
        paymentHeading.setBounds(145, 0, 200, 50);
        add(paymentHeading);

        JLabel memberIdLabel = new JLabel("Member Id");
        memberIdLabel.setBounds(30, 45, 100, 50);
        memberIdLabel.setFont(textFont);
        add(memberIdLabel);
        paymentId = new JTextField();
        paymentId.setBounds(160, 60, 200, 25);
        paymentId.setFont(new Font("serif", Font.PLAIN, 14));
        paymentId.setMargin(new Insets(2, 2, 2, 2));
        add(paymentId);

        JLabel paymentDateLabel = new JLabel("Date");
        paymentDateLabel.setBounds(30, 95, 100, 50);
        paymentDateLabel.setFont(textFont);
        add(paymentDateLabel);
        paymentDate = new JTextField();
        paymentDate.setBounds(160, 110, 200, 25);
        paymentDate.setFont(new Font("serif", Font.PLAIN, 14));
        paymentDate.setMargin(new Insets(2, 2, 2, 2));
        add(paymentDate);

        JLabel monthLabel = new JLabel("Month");
        monthLabel.setBounds(30, 145, 100, 50);
        monthLabel.setFont(textFont);
        add(monthLabel);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox monthInput = new JComboBox(months);
        monthInput.setBounds(160, 160, 200, 25);
        monthInput.setFont(new Font("serif", Font.PLAIN, 16));
        add(monthInput);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30, 195, 100, 50);
        amountLabel.setFont(textFont);
        add(amountLabel);
        String[] amounts = {"650", "1250"};
        JComboBox amountInput = new JComboBox(amounts);
        amountInput.setBounds(160, 210, 200, 25);
        amountInput.setFont(new Font("serif", Font.PLAIN, 16));
        add(amountInput);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(30, 265, 150, 30);
        btnSubmit.setFont(new Font("serif", Font.PLAIN, 16));
//        btnSubmit.addActionListener(this);
        add(btnSubmit);
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 265, 150, 30);
        btnCancel.setFont(new Font("serif", Font.PLAIN, 16));
//        btnCancel.addActionListener(this);
        add(btnCancel);

        //Frame...
        setLayout(null);
        setSize(400, 400);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment();
    }
}
