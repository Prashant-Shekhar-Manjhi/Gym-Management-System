package payment;

import encoder.JavaBase64;
import jdbc.JdbcConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    private JTextField paymentId, paymentDate;
    private JComboBox monthInput,amountInput;
    private JButton btnSubmit, btnCancel;
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
        String[] months = {"","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthInput = new JComboBox(months);
        monthInput.setBounds(160, 160, 200, 25);
        monthInput.setFont(new Font("serif", Font.PLAIN, 16));
        add(monthInput);


        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30, 195, 100, 50);
        amountLabel.setFont(textFont);
        add(amountLabel);
        String[] amounts = {"", "650", "1250"};
        amountInput = new JComboBox(amounts);
        amountInput.setBounds(160, 210, 200, 25);
        amountInput.setFont(new Font("serif", Font.PLAIN, 16));
        add(amountInput);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(30, 265, 150, 30);
        btnSubmit.setFont(new Font("serif", Font.PLAIN, 16));
        btnSubmit.addActionListener(this);
        add(btnSubmit);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 265, 150, 30);
        btnCancel.setFont(new Font("serif", Font.PLAIN, 16));
        btnCancel.addActionListener(this);
        add(btnCancel);

        //Frame...
        setLayout(null);
        setSize(400, 400);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCancel){
            dispose();
        }
        if(e.getSource() == btnSubmit){
            String memberId = paymentId.getText();
            String date = paymentDate.getText();
            String month = monthInput.getSelectedItem().toString();
            String amount = amountInput.getSelectedItem().toString();

            if(memberId.isEmpty() || date.isEmpty() || month.isEmpty() || amount.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter valid Fields", "Try Again!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            makePayment(Integer.parseInt(memberId), date, month, amount);
        }
    }

    private void makePayment(int memberId, String date, String month, String amount) {
        try{
            JdbcConnection con = new JdbcConnection();
            String query = "insert into payments (member_id, amount, month, date_of_payment) values('"+memberId+"', '"+amount+"', '"+month+"','"+date+"')";
            con.stm.executeUpdate(query);

            JOptionPane.showMessageDialog(this, "Payment Successful!", "", JOptionPane.PLAIN_MESSAGE);

            con.stm.close();
            con.con.close();
            this.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Try Again", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

}
