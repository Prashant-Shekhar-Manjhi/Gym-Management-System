package view;

import jdbc.JdbcConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class View extends JFrame implements ActionListener {
    private JRadioButton btnViewMember, btnViewTrainer;
    private JButton btnChoice, btnBack;
    private JPanel viewMemberPanel, viewTrainerPanel;
    public View(){
        super("GYM MANAGEMENT SYSTEM");

        //fonts
        Font headFont = new Font("serif", Font.BOLD, 48);
        Font textFont = new Font("serif", Font.PLAIN, 16);
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




        //option
        btnViewMember = new JRadioButton("View Member", true);
        btnViewTrainer = new JRadioButton("View Trainer");
        btnViewMember.setBounds(590, 15, 120, 40);
        btnViewTrainer.setBounds(710, 15, 120, 40);
        btnViewMember.setFont(new Font("serif", Font.PLAIN, 16));
        btnViewTrainer.setFont(new Font("serif", Font.PLAIN, 16));
        ButtonGroup bg=new ButtonGroup();
        bg.add(btnViewMember);bg.add(btnViewTrainer);
        header.add(btnViewMember);header.add(btnViewTrainer);
        btnChoice = new JButton("choose");
        btnChoice.setBounds(840, 25, 80, 20);
        btnChoice.setFont(new Font("serif", Font.PLAIN, 14));
        btnChoice.addActionListener(this);
        header.add(btnChoice);



        //View member panel...
        viewMemberPanel = new JPanel();
        viewMemberPanel.setLayout(null);
        viewMemberPanel.setBounds(20, 100, 1500, 850);
        JLabel viewMemberHeading = new JLabel("Total Members");
        viewMemberHeading.setBounds(650, 5, 150, 40);
        viewMemberHeading.setFont(subHeadingFont);
        viewMemberPanel.add(viewMemberHeading);
        add(viewMemberPanel);

        String memberData[][] = getAllMembers();

        String memberColumn[] = {"ID", "Name", "Email ID", "Phone No.", "Address", "Gender", "DOB", "DOJ", "Gym Time", "Trainer", "Fee Details"};
        DefaultTableModel memberTableModel = new DefaultTableModel(memberData, memberColumn);
        JTable memberTable = new JTable(memberTableModel);
        memberTable.setBounds(0, 60, 1500, 500);
        memberTable.setRowHeight(25);
        memberTable.setIntercellSpacing(new Dimension(5, 4));
        JScrollPane sp=new JScrollPane(memberTable);
        sp.setBounds(0, 60, 1500, 500);
        viewMemberPanel.add(sp);
        viewMemberPanel.validate();



        //View member panel...
        viewTrainerPanel = new JPanel();
        viewTrainerPanel.setLayout(null);
        viewTrainerPanel.setBounds(20, 100, 1500, 850);
        JLabel viewTrainerHeading = new JLabel("Total Trainers");
        viewTrainerHeading.setBounds(650, 5, 150, 40);
        viewTrainerHeading.setFont(subHeadingFont);
        viewTrainerPanel.add(viewTrainerHeading);
        viewTrainerPanel.setVisible(false);
        add(viewTrainerPanel);


        String trainerData[][] = getAllTrainers();
        String trainerColumn[] = {"ID", "Name", "Email ID", "Phone No.", "Address"};
        DefaultTableModel trainerTableModel = new DefaultTableModel(trainerData, trainerColumn);
        JTable trainerTable = new JTable(trainerTableModel);
        trainerTable.setBounds(0, 60, 1500, 500);
        trainerTable.setRowHeight(25);
        trainerTable.setIntercellSpacing(new Dimension(5, 4));
        JScrollPane sp1=new JScrollPane(trainerTable);
        sp1.setBounds(0, 60, 1500, 500);
        viewTrainerPanel.add(sp1);
        viewTrainerPanel.validate();


        //Frame...
        setLayout(null);
        setSize(1200, 700);
        setLocation(150, 50);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnChoice){
            if(btnViewMember.isSelected()){
                viewTrainerPanel.setVisible(false);
                viewMemberPanel.setVisible(true);
            } if (btnViewTrainer.isSelected()) {
                viewMemberPanel.setVisible(false);
                viewTrainerPanel.setVisible(true);
            }
        }
        if(e.getSource() == btnBack){
            dispose();
        }
    }

    private String[][] getAllMembers(){
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT * FROM members";
            ResultSet resultSet = connection.stm.executeQuery(query);

            while (resultSet.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(resultSet.getString("id"));
                temp.add(resultSet.getString("name"));
                temp.add(resultSet.getString("email"));
                temp.add(resultSet.getString("contact_no"));
                temp.add(resultSet.getString("address"));
                temp.add(resultSet.getString("gender"));
                temp.add(resultSet.getString("date_of_birth"));
                temp.add(resultSet.getString("date_of_joining"));
                temp.add(resultSet.getString("gym_time"));
                temp.add(resultSet.getString("trainer_name"));
                temp.add(resultSet.getString("fee"));

                list.add(temp);
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
        String[][] res = list.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);
        return res;
    }

    private String[][] getAllTrainers(){
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT * FROM trainers";
            ResultSet resultSet = connection.stm.executeQuery(query);

            while (resultSet.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(resultSet.getString("id"));
                temp.add(resultSet.getString("name"));
                temp.add(resultSet.getString("email"));
                temp.add(resultSet.getString("contact_no"));
                temp.add(resultSet.getString("address"));
                list.add(temp);
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
