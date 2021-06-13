package HostelAccommodationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    private JTextField roomNumTextField;
    private JComboBox roomTypeComboBox, hostelTypeComboBox;
    private JButton addRoomButton;

    AddRoom(){

        setBounds(300,200,1000,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel addRoomLabel = new JLabel("ADD ROOM");
        addRoomLabel.setBounds(100,20,150,20);
        addRoomLabel.setFont(new Font("tahoma",Font.BOLD,18));
        add(addRoomLabel);

        JLabel hostelTypeLabel = new JLabel("Hostel Type");
        hostelTypeLabel.setFont(new Font("tahoma",Font.PLAIN,16));
        hostelTypeLabel.setBounds(60,80,120,30);
        add(hostelTypeLabel);

        hostelTypeComboBox = new JComboBox(new String[] {"Boys Hostel", "Girls Hostel"});
        hostelTypeComboBox.setBounds(200,80,150,30);
        hostelTypeComboBox.setBackground(Color.white);
        add(hostelTypeComboBox);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setFont(new Font("tahoma",Font.PLAIN,16));
        roomNum.setBounds(60,130,120,30);
        add(roomNum);

        roomNumTextField = new JTextField();
        roomNumTextField.setBounds(200,130,150,30);
        add(roomNumTextField);

        JLabel roomTypeLabel = new JLabel("Room Type");
        roomTypeLabel.setFont(new Font("tahoma",Font.PLAIN,16));
        roomTypeLabel.setBounds(60,180,120,30);
        add(roomTypeLabel);

        roomTypeComboBox = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        roomTypeComboBox.setBackground(Color.white);
        roomTypeComboBox.setBounds(200,180,150,30);
        add(roomTypeComboBox);

        addRoomButton = new JButton("Add Room");
        addRoomButton.setBounds(130,230,120,30);
        addRoomButton.setBackground(Color.black);
        addRoomButton.setForeground(Color.white);
        addRoomButton.addActionListener(this);
        add(addRoomButton);

        Image scaledImage = new ImageIcon(ClassLoader.getSystemResource("Images/room.jpg")).getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(400,50,500,300);
        add(imageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hostelType = (String) hostelTypeComboBox.getSelectedItem();
        String roomNum = roomNumTextField.getText();
        String roomType = (String) roomTypeComboBox.getSelectedItem();
        String price = roomType.equals("Single Bed")?"RS.90000 p.a":"RS.45000 p.a";
        String query = null;
        int available = roomType.equals("Single Bed")?1:2;

        if(hostelType.equals("Boys Hostel")){
            query = "insert into boys_hostel values( '"+roomNum+"', '"+roomType+"', '"+price+"', '"+available+"' )";
        } else if(hostelType.equals("Girls Hostel")){
            query = "insert into girls_hostel values( '"+roomNum+"', '"+roomType+"', '"+price+"', '"+available+"' )";
        }

        DB_Connection connection = new DB_Connection();
        try {
            connection.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Room Added!");
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,"!Error Occurred!");
            e1.printStackTrace();
        }
    }
}
