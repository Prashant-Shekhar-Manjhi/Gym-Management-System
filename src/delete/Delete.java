package delete;

import jdbc.JdbcConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Delete extends JFrame implements ActionListener {
    private JButton btnBack, btnSearch, btnDelete;
    private JTextField nameInput, emailInput, addressInput, contactInput, dojInput, dobInput, memberId;
    private  JPanel deleteMemberPanel;
    JComboBox genderInput, timeInput,  trainerInput, feeInput;
    public Delete(){
        super("Gym Management System");
        Font textFont = new Font("serif", Font.PLAIN, 22);
        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);


        //Header
        JPanel header;
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1200, 50);
        add(header);

        //back button
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 80, 20);
        btnBack.addActionListener(this);
        header.add(btnBack);

        JLabel memberIdLabel = new JLabel("Member Id");
        memberIdLabel.setBounds(400, 20, 120, 20);
        memberIdLabel.setFont(textFont);
        header.add(memberIdLabel);
        memberId = new JTextField();
        memberId.setBounds(520, 20, 150, 25);
        memberId.setFont(new Font("serif", Font.PLAIN, 14));
        memberId.setMargin(new Insets(2, 2, 2, 2));
        header.add(memberId);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(680, 20, 100, 25);
        btnSearch.setFont(new Font("serif", Font.PLAIN, 18));
        btnSearch.addActionListener(this);
        header.add(btnSearch);



        //update Member Panel
        deleteMemberPanel = new JPanel();
        deleteMemberPanel.setLayout(null);
        deleteMemberPanel.setBounds(180, 100, 850, 500);
        JLabel deleteMemberHeading = new JLabel("Delete Member");
        deleteMemberHeading.setBounds(350, 5, 180, 40);
        deleteMemberHeading.setFont(subHeadingFont);
        deleteMemberPanel.add(deleteMemberHeading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 80, 80, 20);
        nameLabel.setFont(textFont);
        deleteMemberPanel.add(nameLabel);
        nameInput = new JTextField();
        nameInput.setBounds(160, 80, 200, 25);
        nameInput.setFont(new Font("serif", Font.PLAIN, 14));
        nameInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(nameInput);

        JLabel contactLabel = new JLabel("Phone");
        contactLabel.setBounds(50, 140, 80, 20);
        contactLabel.setFont(textFont);
        deleteMemberPanel.add(contactLabel);
        contactInput = new JTextField();
        contactInput.setBounds(160, 142, 200, 25);
        contactInput.setFont(new Font("serif", Font.PLAIN, 14));
        contactInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(contactInput);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 200, 80, 20);
        genderLabel.setFont(textFont);
        deleteMemberPanel.add(genderLabel);
        String[] genderOpt = {"", "Male", "Female"};
        genderInput = new JComboBox(genderOpt);
        genderInput.setBounds(160, 200, 200, 25);
        deleteMemberPanel.add(genderInput);

        JLabel timeLabel = new JLabel("Time");
        timeLabel.setBounds(50, 260, 80, 20);
        timeLabel.setFont(textFont);
        deleteMemberPanel.add(timeLabel);
        String[] timeOpt = {"","Morning", "Evening"};
        timeInput = new JComboBox(timeOpt);
        timeInput.setBounds(160, 260, 200, 25);
        deleteMemberPanel.add(timeInput);

        JLabel feeLabel = new JLabel("Fee");
        feeLabel.setBounds(50, 320, 80, 20);
        feeLabel.setFont(textFont);
        deleteMemberPanel.add(feeLabel);
        String[] feeOpt = {"","650", "1250"};
        feeInput = new JComboBox(feeOpt);
        feeInput.setBounds(160, 320, 200, 25);
        deleteMemberPanel.add(feeInput);


        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(460, 80, 80, 20);
        emailLabel.setFont(textFont);
        deleteMemberPanel.add(emailLabel);
        emailInput = new JTextField();
        emailInput.setBounds(550, 80, 200, 25);
        emailInput.setFont(new Font("serif", Font.PLAIN, 14));
        emailInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(emailInput);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(460, 140, 80, 20);
        addressLabel.setFont(textFont);
        deleteMemberPanel.add(addressLabel);
        addressInput = new JTextField();
        addressInput.setBounds(550, 140, 200, 25);
        addressInput.setFont(new Font("serif", Font.PLAIN, 14));
        addressInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(addressInput);

        JLabel dobLabel = new JLabel("DOB");
        dobLabel.setBounds(460, 200, 80, 20);
        dobLabel.setFont(textFont);
        deleteMemberPanel.add(dobLabel);
        dobInput = new JTextField();
        dobInput.setBounds(550, 200, 200, 25);
        dobInput.setFont(new Font("serif", Font.PLAIN, 14));
        dobInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(dobInput);

        JLabel dojLabel = new JLabel("DOJ");
        dojLabel.setBounds(460, 260, 80, 20);
        dojLabel.setFont(textFont);
        deleteMemberPanel.add(dojLabel);
        dojInput = new JTextField();
        dojInput.setBounds(550, 260, 200, 25);
        dojInput.setFont(new Font("serif", Font.PLAIN, 14));
        dojInput.setMargin(new Insets(2, 2, 2, 2));
        deleteMemberPanel.add(dojInput);

        JLabel trainerLabel = new JLabel("Trainer");
        trainerLabel.setBounds(460, 320, 80, 20);
        trainerLabel.setFont(textFont);
        deleteMemberPanel.add(trainerLabel);
        String[] trainerOpt = getTrainerList();
        trainerInput = new JComboBox(trainerOpt);
        trainerInput.setBounds(550, 320, 200, 25);
        deleteMemberPanel.add(trainerInput);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(50, 380, 150, 30);
        btnDelete.setFont(new Font("serif", Font.PLAIN, 18));
        btnDelete.addActionListener(this);
        deleteMemberPanel.add(btnDelete);
        add(deleteMemberPanel);


        //Frame...
        setLayout(null);
        setSize(1200, 700);
        setLocation(150, 50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSearch){searchMember();}
        if(e.getSource()==btnDelete){deleteMember();}
        if(e.getSource()==btnBack){dispose();}
    }

    private void deleteMember() {
        try{
            JdbcConnection con = new JdbcConnection();
            int lid = Integer.parseInt(memberId.getText());
            String query = "Delete from members where id ="+lid;
            con.stm.executeUpdate(query);

            JOptionPane.showMessageDialog(this, "Successfully Deleted!", "Deleted", JOptionPane.PLAIN_MESSAGE);

            con.stm.close();
            con.con.close();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Try Again", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchMember() {
        try{
            String memberIdLoc = memberId.getText();

            if(memberIdLoc.isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter valid fields!", "Try Again", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT * FROM members WHERE id = '"+memberIdLoc+"'";
            ResultSet resultSet = connection.stm.executeQuery(query);

            if(resultSet.next()){
                nameInput.setText(resultSet.getString("name"));
                contactInput.setText(resultSet.getString("contact_no"));
                emailInput.setText(resultSet.getString("email"));
                dobInput.setText(resultSet.getString("date_of_birth"));
                dojInput.setText(resultSet.getString("date_of_joining"));
                addressInput.setText(resultSet.getString("address"));
                genderInput.setSelectedItem(resultSet.getString("gender"));
                timeInput.setSelectedItem(resultSet.getString("gym_time"));
                feeInput.setSelectedItem(resultSet.getString("fee"));
                trainerInput.setSelectedItem(resultSet.getString("trainer_name"));
            }else{
                JOptionPane.showMessageDialog(this, "Try Again", "Not Found", JOptionPane.ERROR_MESSAGE);
            }

        }catch(Exception exception){
            JOptionPane.showMessageDialog(this, "Try Again", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] getTrainerList() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        JdbcConnection connection = new JdbcConnection();
        String query = "SELECT name FROM trainers";
        try{
            ResultSet resultSet = connection.stm.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                list.add(name);
            }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        String[] res = list.toArray(new String[list.size()]);
        return res;
    }

    public static void main(String[] args) {
        new Delete();
    }
}
