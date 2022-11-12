package add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;

public class Add extends JFrame implements ActionListener {
    private JButton btnChoice;
    JRadioButton btnAddMember, btnAddTrainer;
    JPanel addMemberPanel, addTrainerPanel;
    public Add(){
        super("GYM MANAGEMENT SYSTEM");

        Font textFont = new Font("serif", Font.PLAIN, 22);
        Font subHeadingFont = new Font("serif", Font.PLAIN, 24);


        //Header
        JPanel header;
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1200, 50);
        add(header);

        //option
        btnAddMember = new JRadioButton("Add Member", true);
        btnAddTrainer = new JRadioButton("Add Trainer");
        btnAddMember.setBounds(440, 15, 120, 40);
        btnAddTrainer.setBounds(558, 15, 120, 40);
        btnAddMember.setFont(new Font("serif", Font.PLAIN, 16));
        btnAddTrainer.setFont(new Font("serif", Font.PLAIN, 16));
        ButtonGroup bg=new ButtonGroup();
        bg.add(btnAddMember);bg.add(btnAddTrainer);
        header.add(btnAddMember);header.add(btnAddTrainer);
        btnChoice = new JButton("choose");
        btnChoice.setBounds(680, 25, 80, 20);
        btnChoice.setFont(new Font("serif", Font.PLAIN, 14));
        btnChoice.addActionListener(this);
        header.add(btnChoice);

        //Add Member
        addMemberPanel = new JPanel();
        addMemberPanel.setLayout(null);
        addMemberPanel.setBounds(180, 100, 850, 500);
        JLabel addMemberHeading = new JLabel("Add Member");
        addMemberHeading.setBounds(350, 5, 150, 40);
        addMemberHeading.setFont(subHeadingFont);
        addMemberPanel.add(addMemberHeading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 80, 80, 20);
        nameLabel.setFont(textFont);
        addMemberPanel.add(nameLabel);
        JTextField nameInput = new JTextField();
        nameInput.setBounds(160, 80, 200, 25);
        nameInput.setFont(new Font("serif", Font.PLAIN, 14));
        nameInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(nameInput);

        JLabel contactLabel = new JLabel("Phone");
        contactLabel.setBounds(50, 140, 80, 20);
        contactLabel.setFont(textFont);
        addMemberPanel.add(contactLabel);
        JTextField contactInput = new JTextField();
        contactInput.setBounds(160, 142, 200, 25);
        contactInput.setFont(new Font("serif", Font.PLAIN, 14));
        contactInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(contactInput);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 200, 80, 20);
        genderLabel.setFont(textFont);
        addMemberPanel.add(genderLabel);
        String[] genderOpt = {"", "Male", "Female"};
        JComboBox genderInput = new JComboBox(genderOpt);
        genderInput.setBounds(160, 200, 200, 25);
        addMemberPanel.add(genderInput);

        JLabel timeLabel = new JLabel("Time");
        timeLabel.setBounds(50, 260, 80, 20);
        timeLabel.setFont(textFont);
        addMemberPanel.add(timeLabel);
        String[] timeOpt = {"","Morning", "Evening"};
        JComboBox timeInput = new JComboBox(timeOpt);
        timeInput.setBounds(160, 260, 200, 25);
        addMemberPanel.add(timeInput);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(460, 80, 80, 20);
        emailLabel.setFont(textFont);
        addMemberPanel.add(emailLabel);
        JTextField emailInput = new JTextField();
        emailInput.setBounds(550, 80, 200, 25);
        emailInput.setFont(new Font("serif", Font.PLAIN, 14));
        emailInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(emailInput);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(460, 140, 80, 20);
        addressLabel.setFont(textFont);
        addMemberPanel.add(addressLabel);
        JTextField addressInput = new JTextField();
        addressInput.setBounds(550, 140, 200, 25);
        addressInput.setFont(new Font("serif", Font.PLAIN, 14));
        addressInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(addressInput);

        JLabel dobLabel = new JLabel("DOB");
        dobLabel.setBounds(460, 200, 80, 20);
        dobLabel.setFont(textFont);
        addMemberPanel.add(dobLabel);
        JTextField dobInput = new JTextField();
        dobInput.setBounds(550, 200, 200, 25);
        dobInput.setFont(new Font("serif", Font.PLAIN, 14));
        dobInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(dobInput);

        JLabel dojLabel = new JLabel("DOJ");
        dojLabel.setBounds(460, 260, 80, 20);
        dojLabel.setFont(textFont);
        addMemberPanel.add(dojLabel);
        JTextField dojInput = new JTextField();
        dojInput.setBounds(550, 260, 200, 25);
        dojInput.setFont(new Font("serif", Font.PLAIN, 14));
        dojInput.setMargin(new Insets(2, 2, 2, 2));
        addMemberPanel.add(dojInput);

        JButton submitAddMemberBtn = new JButton("Submit");
        submitAddMemberBtn.setBounds(50, 320, 150, 30);
        submitAddMemberBtn.setFont(new Font("serif", Font.PLAIN, 18));
        addMemberPanel.add(submitAddMemberBtn);
        JButton cancelAddMemberBtn = new JButton("Cancel");
        cancelAddMemberBtn.setBounds(210, 320, 150, 30);
        cancelAddMemberBtn.setFont(new Font("serif", Font.PLAIN, 18));
        addMemberPanel.add(cancelAddMemberBtn);

        add(addMemberPanel);


        //Add Trainer
        addTrainerPanel = new JPanel();
        addTrainerPanel.setLayout(null);
        addTrainerPanel.setBounds(180, 100, 850, 500);
        JLabel addTrainerHeading = new JLabel("Add Trainer");
        addTrainerHeading.setBounds(350, 5, 150, 40);
        addTrainerHeading.setFont(subHeadingFont);
        addTrainerPanel.add(addTrainerHeading);

        JLabel tnameLabel = new JLabel("Name");
        tnameLabel.setBounds(260, 80, 80, 20);
        tnameLabel.setFont(textFont);
        addTrainerPanel.add(tnameLabel);
        JTextField tnameInput = new JTextField();
        tnameInput.setBounds(370, 80, 200, 25);
        tnameInput.setFont(new Font("serif", Font.PLAIN, 14));
        tnameInput.setMargin(new Insets(2, 2, 2, 2));
        addTrainerPanel.add(tnameInput);

        JLabel temailLabel = new JLabel("Email");
        temailLabel.setBounds(260, 140, 80, 20);
        temailLabel.setFont(textFont);
        addTrainerPanel.add(temailLabel);
        JTextField temailInput = new JTextField();
        temailInput.setBounds(370, 142, 200, 25);
        temailInput.setFont(new Font("serif", Font.PLAIN, 14));
        temailInput.setMargin(new Insets(2, 2, 2, 2));
        addTrainerPanel.add(temailInput);

        JLabel tcontactLabel = new JLabel("Phone");
        tcontactLabel.setBounds(260, 200, 80, 20);
        tcontactLabel.setFont(textFont);
        addTrainerPanel.add(tcontactLabel);
        JTextField tcontactInput = new JTextField();
        tcontactInput.setBounds(370, 200, 200, 25);
        addTrainerPanel.add(tcontactInput);

        JLabel taddressLabel = new JLabel("Address");
        taddressLabel.setBounds(260, 260, 80, 20);
        taddressLabel.setFont(textFont);
        addTrainerPanel.add(taddressLabel);
        JTextField taddressInput = new JTextField();
        taddressInput.setBounds(370, 260, 200, 25);
        addTrainerPanel.add(taddressInput);


        JButton submitAddTrainerBtn = new JButton("Submit");
        submitAddTrainerBtn.setBounds(260, 320, 150, 30);
        submitAddTrainerBtn.setFont(new Font("serif", Font.PLAIN, 18));
        addTrainerPanel.add(submitAddTrainerBtn);
        JButton cancelAddTrainerBtn = new JButton("Cancel");
        cancelAddTrainerBtn.setBounds(420, 320, 150, 30);
        cancelAddTrainerBtn.setFont(new Font("serif", Font.PLAIN, 18));
        addTrainerPanel.add(cancelAddTrainerBtn);

        addTrainerPanel.setVisible(false);
        add(addTrainerPanel);

        //Frame...
        setLayout(null);
        setSize(1200, 700);
        setLocation(150, 50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Add();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnChoice){
            if(btnAddMember.isSelected()){
                addTrainerPanel.setVisible(false);
                addMemberPanel.setVisible(true);
            } if (btnAddTrainer.isSelected()) {
                addMemberPanel.setVisible(false);
                addTrainerPanel.setVisible(true);
            }
        }
    }
}
