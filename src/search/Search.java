package search;

import jdbc.JdbcConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Search extends JFrame implements ActionListener {
    private JPanel searchMemberPanel;
    private JButton btnBack, btnSearchByName, btnSearchById;

    private JTextField searchById, searchByName;
    private String memberData[][];
    private String memberColumn[] = {"ID", "Name", "Email ID", "Phone No.", "Address", "Gender", "DOB", "DOJ", "Gym Time", "Trainer", "Fee Details"};
    private JTable memberTable;
    public Search(){
        super("Gym Management System");

        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);

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

        JLabel searchMemberHeading = new JLabel("Search Members");
        searchMemberHeading.setBounds(650, 20, 180, 40);
        searchMemberHeading.setFont(subHeadingFont);
        header.add(searchMemberHeading);



        //View member panel...
        searchMemberPanel = new JPanel();
        searchMemberPanel.setLayout(null);
        searchMemberPanel.setBounds(20, 100, 1500, 850);

        JLabel searchIdLabel = new JLabel("Search by Id");
        searchIdLabel.setBounds(250, 5, 200, 25);
        searchIdLabel.setFont(new Font("serif", Font.PLAIN, 16));
        searchMemberPanel.add(searchIdLabel);
        searchById = new JTextField();
        searchById.setBounds(350, 5, 150, 25);
        searchMemberPanel.add(searchById);
        btnSearchById = new JButton("Search");
        btnSearchById.setBounds(500, 5, 75, 24);
        btnSearchById.addActionListener(this);
        searchMemberPanel.add(btnSearchById);


        JLabel searchNameLabel = new JLabel("Search by Name");
        searchNameLabel.setBounds(900, 5, 200, 25);
        searchNameLabel.setFont(new Font("serif", Font.PLAIN, 16));
        searchMemberPanel.add(searchNameLabel);
        searchByName = new JTextField();
        searchByName.setBounds(1020, 5, 150, 25);
        searchMemberPanel.add(searchByName);
        btnSearchByName = new JButton("Search");
        btnSearchByName.setBounds(1170, 5, 75, 24);
        btnSearchByName.addActionListener(this);
        searchMemberPanel.add(btnSearchByName);

        add(searchMemberPanel);



        String memberColumn[] = {"ID", "Name", "Email ID", "Phone No.", "Address", "Gender", "DOB", "DOJ", "Gym Time", "Trainer", "Fee Details"};
        DefaultTableModel memberTableModel = new DefaultTableModel(memberData, memberColumn);
        memberTable = new JTable(memberTableModel);
        memberTable.setBounds(0, 60, 1500, 200);
        memberTable.setRowHeight(25);
        memberTable.setIntercellSpacing(new Dimension(5, 4));
        JScrollPane sp=new JScrollPane(memberTable);
        sp.setBounds(0, 60, 1500, 200);
        searchMemberPanel.add(sp);
        searchMemberPanel.validate();



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
        if(e.getSource() == btnBack){
            dispose();
        }

        if(e.getSource() == btnSearchByName){
            memberData = getMembersByName(searchByName.getText());
            if(memberData.length != 0){
                DefaultTableModel memberTableModel = new DefaultTableModel(memberData, memberColumn);
                memberTable.setModel(memberTableModel);
            }
        }

        if(e.getSource() == btnSearchById){
            int id = Integer.parseInt(searchById.getText());
            memberData = getMembersById(id);
            if(memberData.length != 0) {
                DefaultTableModel memberTableModel = new DefaultTableModel(memberData, memberColumn);
                memberTable.setModel(memberTableModel);
            }
        }
    }

    private String[][] getMembersById(int id) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT * FROM members where id="+id;
            ResultSet resultSet = connection.stm.executeQuery(query);

            if (resultSet.next()){
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
            }else {
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

    private String[][] getMembersByName(String name) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try{
            JdbcConnection connection = new JdbcConnection();
            String query = "SELECT * FROM members where name='"+name+"'";
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
