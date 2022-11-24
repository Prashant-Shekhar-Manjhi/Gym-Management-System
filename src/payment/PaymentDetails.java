package payment;

import jdbc.JdbcConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentDetails extends JFrame implements ActionListener {
    private JButton btnBack, btnSearchByMonth, searchAllDetails;
    private JTextField searchByMonth;
    private  JPanel paymentDetailsPanel;
    private JTable paymentTable;
    private String paymentData[][];
    private String paymentColumn[] = {"Member Id", "Name", "Email", "Phone No.", "Fee", "Amount Paid", "month", "Date of Payment"};
    public PaymentDetails(){
        super("Gym Management System");

        Font subHeadingFont = new Font("serif", Font.PLAIN, 28);


        //Header
        JPanel header;
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1500, 100);
        add(header);

        //back button
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 80, 20);
        btnBack.addActionListener(this);
        header.add(btnBack);

        JLabel searchMemberHeading = new JLabel("Payment Details");
        searchMemberHeading.setBounds(650, 20, 200, 40);
        searchMemberHeading.setFont(subHeadingFont);
        header.add(searchMemberHeading);




        //View member panel...
        paymentDetailsPanel = new JPanel();
        paymentDetailsPanel.setLayout(null);
        paymentDetailsPanel.setBounds(20, 100, 1500, 850);

        JLabel searchIdLabel = new JLabel("Search by Month");
        searchIdLabel.setBounds(230, 5, 200, 25);
        searchIdLabel.setFont(new Font("serif", Font.PLAIN, 16));
        paymentDetailsPanel.add(searchIdLabel);
        searchByMonth = new JTextField();
        searchByMonth.setBounds(350, 5, 150, 25);
        paymentDetailsPanel.add(searchByMonth);
        btnSearchByMonth = new JButton("Search");
        btnSearchByMonth.setBounds(500, 5, 75, 24);
        btnSearchByMonth.addActionListener(this);
        paymentDetailsPanel.add(btnSearchByMonth);

        searchAllDetails = new JButton("All Details");
        searchAllDetails.setBounds(1400, 5, 100, 24);
        searchAllDetails.addActionListener(this);
        paymentDetailsPanel.add(searchAllDetails);

        add(paymentDetailsPanel);


        paymentData = getAllPaymentDetails();
        DefaultTableModel memberTableModel = new DefaultTableModel(paymentData, paymentColumn);
        paymentTable = new JTable(memberTableModel);
        paymentTable.setBounds(0, 60, 1500, 400);
        paymentTable.setRowHeight(25);
        paymentTable.setIntercellSpacing(new Dimension(5, 4));
        JScrollPane sp=new JScrollPane(paymentTable);
        sp.setBounds(0, 60, 1500, 400);
        paymentDetailsPanel.add(sp);
        paymentDetailsPanel.validate();



        //Frame...
        setLayout(null);
        setSize(1200, 700);
        setLocation(150, 50);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private String[][] getAllPaymentDetails() {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT members.id, members.name,  members.email, members.contact_no, members.fee, payments.amount, payments.month, payments.date_of_payment FROM members INNER JOIN payments ON members.id = payments.member_id";
            ResultSet resultSet = connection.stm.executeQuery(query);

            while (resultSet.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(resultSet.getString("id"));
                temp.add(resultSet.getString("name"));
                temp.add(resultSet.getString("email"));
                temp.add(resultSet.getString("contact_no"));
                temp.add(resultSet.getString("fee"));
                temp.add(resultSet.getString("amount"));
                temp.add(resultSet.getString("month"));
                temp.add(resultSet.getString("date_of_Payment"));
                list.add(temp);
            }
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this, "Try Again", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
        String[][] res = list.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);
        return res;
    }

    public static void main(String[] args) {
        new PaymentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            dispose();
        }
        if(e.getSource() == btnSearchByMonth){
            paymentData = getAllPaymentDetailsByMonth(searchByMonth.getText());
            if(paymentData.length != 0){
                DefaultTableModel memberTableModel = new DefaultTableModel(paymentData, paymentColumn);
                paymentTable.setModel(memberTableModel);
            }
        }
        if(e.getSource() == searchAllDetails){
            paymentData = getAllPaymentDetails();
            if(paymentData.length != 0){
                DefaultTableModel memberTableModel = new DefaultTableModel(paymentData, paymentColumn);
                paymentTable.setModel(memberTableModel);
            }
        }
    }

    private String[][] getAllPaymentDetailsByMonth(String month) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "select * from (SELECT members.id, members.name,  members.email, members.contact_no, members.fee, payments.amount, payments.month, payments.date_of_payment FROM members INNER JOIN payments ON members.id = payments.member_id) as payment_details where month = '"+month+"'";
            ResultSet resultSet = connection.stm.executeQuery(query);

            while (resultSet.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(resultSet.getString("id"));
                temp.add(resultSet.getString("name"));
                temp.add(resultSet.getString("email"));
                temp.add(resultSet.getString("contact_no"));
                temp.add(resultSet.getString("fee"));
                temp.add(resultSet.getString("amount"));
                temp.add(resultSet.getString("month"));
                temp.add(resultSet.getString("date_of_Payment"));
                list.add(temp);
            }
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this, "Try Again", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
        String[][] res = list.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);
        return res;
    }
}
