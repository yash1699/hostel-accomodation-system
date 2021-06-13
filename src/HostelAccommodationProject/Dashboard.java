package HostelAccommodationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu adminMenu;
    private  JMenuItem logoutMenuItem ,addRoomMenuItem, removeStudentMenuItem;
    private JButton newStudentButton, roomDetailsButton, searchStudentButton, allStudentInfoButton;

    Dashboard(){
        menuBar = new JMenuBar();
        add(menuBar);

        adminMenu = new JMenu("Admin");
        adminMenu.setForeground(Color.blue);
        menuBar.add(adminMenu);

        menuBar.setBounds(0,0,1920,30);

        addRoomMenuItem = new JMenuItem("Add Room");
        addRoomMenuItem.addActionListener(this);
        adminMenu.add(addRoomMenuItem);

        removeStudentMenuItem = new JMenuItem("Remove Student");
        removeStudentMenuItem.addActionListener(this);
        adminMenu.add(removeStudentMenuItem);

        logoutMenuItem = new JMenuItem("Logout");
        logoutMenuItem.addActionListener(this);
        adminMenu.add(logoutMenuItem);

        newStudentButton = new JButton("New Student");
        newStudentButton.setBackground(Color.BLUE);
        newStudentButton.setForeground(Color.white);
        newStudentButton.setFont(new Font("tahoma",Font.PLAIN,16));
        newStudentButton.setBounds(250,420,150,50);
        newStudentButton.addActionListener(this);
        add(newStudentButton);

        roomDetailsButton = new JButton("Room Details");
        roomDetailsButton.setBackground(Color.red);
        roomDetailsButton.setForeground(Color.white);
        roomDetailsButton.setFont(new Font("tahoma",Font.PLAIN,16));
        roomDetailsButton.setBounds(550,420,150,50);
        roomDetailsButton.addActionListener(this);
        add(roomDetailsButton);

        searchStudentButton = new JButton("Search Student");
        searchStudentButton.setBackground(Color.red);
        searchStudentButton.setForeground(Color.white);
        searchStudentButton.setFont(new Font("tahoma",Font.PLAIN,16));
        searchStudentButton.setBounds(850,420,150,50);
        searchStudentButton.addActionListener(this);
        add(searchStudentButton);

        allStudentInfoButton = new JButton("All Student Info");
        allStudentInfoButton.setBackground(Color.blue);
        allStudentInfoButton.setForeground(Color.white);
        allStudentInfoButton.setFont(new Font("tahoma",Font.PLAIN,16));
        allStudentInfoButton.setBounds(1150,420,150,50);
        allStudentInfoButton.addActionListener(this);
        add(allStudentInfoButton);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Images/dashboard.jpg"));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0,0,1920,1080);
        add(imageLabel);

        JLabel nameLabel = new JLabel("WELCOME TO IEM-UEM HOSTEL");
        nameLabel.setBounds(450,80,750,50);
        nameLabel.setForeground(Color.red);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN,50));
        imageLabel.add(nameLabel);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(null);
        setBounds(0,0, (int)dimension.getWidth(), (int)dimension.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newStudentButton){
            new NewStudent().setVisible(true);
        } else if(e.getSource() == roomDetailsButton){
            new RoomDetails().setVisible(true);
        } else if(e.getSource() == searchStudentButton){
            new SearchStudent().setVisible(true);
        } else if(e.getSource() == allStudentInfoButton){
            new AllStudentInfo().setVisible(true);
        } else if(e.getActionCommand().equals("Add Room")){
            new AddRoom().setVisible(true);
        } else if(e.getActionCommand().equals("Logout")){
            new Login().setVisible(true);
            this.dispose();
        } else if(e.getActionCommand().equals("Remove Student")){
            new RemoveStudent().setVisible(true);
        }
    }
}
