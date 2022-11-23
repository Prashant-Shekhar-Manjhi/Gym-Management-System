package home;

import add.Add;
import authentication.Login;
import payment.Payment;
import search.Search;
import update.Update;
import view.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JButton addMember;
    private JButton totalMember, feePayment, feeDetails, updateMember, deleteMember, searchMember, logout;
    private  JPanel menu;
    public Home(){
        super("GYM MANAGEMENT SYSTEM");
        //Font
        Font headFont = new Font("serif", Font.BOLD, 48);

        //Header
        JPanel header;
        header = new JPanel();
        header.setBackground(new Color(0, 0, 0, 100));
        header.setBounds(0, 0, 1540, 100);
        header.setLayout(new GridLayout());
        JLabel headingName = new JLabel("Gym Management System");
        headingName.setHorizontalAlignment(JLabel.CENTER);
        headingName.setVerticalAlignment(JLabel.CENTER);
        headingName.setFont(headFont);
        headingName.setForeground(Color.WHITE);
        header.add(headingName);

        //Menu
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(320, 150, 900, 550);
        menu.setBackground(new Color(0,0,0, 160));
        menu.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

        //add member...
        ImageIcon addMemberIcon = new ImageIcon("src/images/add-user.png");
        Image addMemberScaledImg = addMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        addMember = new JButton(new ImageIcon(addMemberScaledImg));
        addMember.setBounds(90, 60, 110, 110);
        addMember.addActionListener(this);
        addMember.setMargin(new Insets(5, 5, 5, 5));
        menu.add(addMember);
        JLabel addMemberLabel = new JLabel("Add Member");
        addMemberLabel.setBounds(100, 160 ,100, 50);
        addMemberLabel.setForeground(Color.WHITE);
        addMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(addMemberLabel);

        //total members
        ImageIcon totalMemberIcon = new ImageIcon("src/images/group.png");
        Image totalScaledImg = totalMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        totalMember = new JButton(new ImageIcon(totalScaledImg));
        totalMember.setBounds(290, 60, 110, 110);
        totalMember.addActionListener(this);
        menu.add(totalMember);
        JLabel totalMemberLabel = new JLabel("Total Members");
        totalMemberLabel.setBounds(295, 160 ,105, 50);
        totalMemberLabel.setForeground(Color.WHITE);
        totalMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(totalMemberLabel);

        //fee payment...
        ImageIcon feePaymentIcon = new ImageIcon("src/images/cash-payment.png");
        Image feePaymentImg = feePaymentIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        feePayment = new JButton(new ImageIcon(feePaymentImg));
        feePayment.setBounds(485, 60, 110, 110);
        feePayment.addActionListener(this);
        menu.add(feePayment);
        JLabel feePaymentLabel = new JLabel("Pay Fee");
        feePaymentLabel.setBounds(513, 160 ,105, 50);
        feePaymentLabel.setForeground(Color.WHITE);
        feePaymentLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(feePaymentLabel);

        //fee details...
        ImageIcon feeDetailsIcon = new ImageIcon("src/images/fee-details.png");
        Image feeDetailsImg = feeDetailsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        feeDetails = new JButton(new ImageIcon(feeDetailsImg));
        feeDetails.setBounds(680, 60, 110, 110);
        feeDetails.addActionListener(this);
        menu.add(feeDetails);
        JLabel feeDetailsLabel = new JLabel("Fee Details");
        feeDetailsLabel.setBounds(700, 160 ,105, 50);
        feeDetailsLabel.setForeground(Color.WHITE);
        feeDetailsLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(feeDetailsLabel);

        //update member
        ImageIcon updateMemberIcon = new ImageIcon("src/images/update.png");
        Image updateMemberImg = updateMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        updateMember = new JButton(new ImageIcon(updateMemberImg));
        updateMember.setBounds(90, 300, 110, 110);
        updateMember.addActionListener(this);
        menu.add(updateMember);
        JLabel updateMemberLabel = new JLabel("Update Member");
        updateMemberLabel.setBounds(90, 400 ,115, 50);
        updateMemberLabel.setForeground(Color.WHITE);
        updateMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(updateMemberLabel);

        //Delete member
        ImageIcon deleteMemberIcon = new ImageIcon("src/images/delete.png");
        Image deleteMemberImg = deleteMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        deleteMember = new JButton(new ImageIcon(deleteMemberImg));
        deleteMember.setBounds(290, 300, 110, 110);
        deleteMember.addActionListener(this);
        menu.add(deleteMember);
        JLabel deleteMemberLabel = new JLabel("Delete Member");
        deleteMemberLabel.setBounds(293, 400 ,115, 50);
        deleteMemberLabel.setForeground(Color.WHITE);
        deleteMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(deleteMemberLabel);

        //Search member
        ImageIcon searchMemberIcon = new ImageIcon("src/images/search.png");
        Image searchMemberImg = searchMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        searchMember = new JButton(new ImageIcon(searchMemberImg));
        searchMember.setBounds(485, 300, 110, 110);
        searchMember.addActionListener(this);
        menu.add(searchMember);
        JLabel searchMemberLabel = new JLabel("Search Member");
        searchMemberLabel.setBounds(487, 400 ,115, 50);
        searchMemberLabel.setForeground(Color.WHITE);
        searchMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(searchMemberLabel);

        //Logout
        ImageIcon logoutIcon = new ImageIcon("src/images/logout.png");
        Image logoutImg = logoutIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logout = new JButton(new ImageIcon(logoutImg));
        logout.setBounds(680, 300, 110, 110);
        logout.addActionListener(this);
        menu.add(logout);
        JLabel logoutLabel = new JLabel("Logout");
        logoutLabel.setBounds(710, 400 ,105, 50);
        logoutLabel.setForeground(Color.WHITE);
        logoutLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(logoutLabel);


        //frame
        setLayout(new GridLayout());
        setBounds(150, 50, 1200, 700);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon bgImg = new ImageIcon("src/images/background_2.jpg");
        Image newImage = bgImg.getImage().getScaledInstance(1600, 800, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        JLabel background = new JLabel("", newImageIcon, JLabel.CENTER);
        add(background);
        background.add(header);
        background.add(menu);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addMember){
            new Add();
        } else if (e.getSource() == totalMember) {
            new View();
        } else if (e.getSource() == feePayment) {
            new Payment();
        } else if (e.getSource() == feeDetails) {
            System.out.println("fee Details clicked");
        }else if (e.getSource() == updateMember) {
            new Update();
        }else if (e.getSource() == deleteMember) {
            System.out.println("delete member clicked");
        }else if (e.getSource() == searchMember) {
            new Search();
        } else if (e.getSource() == logout) {
            dispose();
            new Login();
        }
    }
}
