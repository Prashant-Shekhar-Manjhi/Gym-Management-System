package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JButton addMember;
    private JButton totalMember;
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
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(320, 150, 900, 550);
        menu.setBackground(new Color(0,0,0, 100));

        ImageIcon addMemberIcon = new ImageIcon("src/images/add-user.png");
        Image addMemberScaledImg = addMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        addMember = new JButton(new ImageIcon(addMemberScaledImg));
        addMember.setBounds(70, 60, 110, 110);
        addMember.addActionListener(this);
        addMember.setMargin(new Insets(5, 5, 5, 5));
        menu.add(addMember);
        JLabel addMemberLabel = new JLabel("Add Member");
        addMemberLabel.setBounds(80, 160 ,100, 50);
        addMemberLabel.setForeground(Color.WHITE);
        addMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(addMemberLabel);

        ImageIcon totalMemberIcon = new ImageIcon("src/images/group.png");
        Image totalScaledImg = totalMemberIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        totalMember = new JButton(new ImageIcon(totalScaledImg));
        totalMember.setBounds(250, 60, 110, 110);
        totalMember.addActionListener(this);
        menu.add(totalMember);
        JLabel totalMemberLabel = new JLabel("Total Members");
        totalMemberLabel.setBounds(255, 160 ,105, 50);
        totalMemberLabel.setForeground(Color.WHITE);
        totalMemberLabel.setFont(new Font("serif", Font.BOLD, 16));
        menu.add(totalMemberLabel);

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
            System.out.println("Add member Clicked!");
        } else if (e.getSource() == totalMember) {
            System.out.println("Total Members Clicked");
        }
    }
}
