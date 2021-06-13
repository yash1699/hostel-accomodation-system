package HostelAccommodationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Calendar;

public class NewStudent extends JFrame implements ActionListener {

    private JTextField nameTextField, ageTextField, enNumberTextField, phoneTextField, emailTextField, roomNumTextField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox courseComboBox, batchComboBox, bedTypeComboBox;
    private JButton submitButton, getRoomNumButton;
    private DB_Connection connection = new DB_Connection();

    NewStudent(){

        setLayout(null);
        setBounds(420,190,800,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        nameLabel.setBounds(60,30,120,30);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(200,30,150,30);
        add(nameTextField);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        ageLabel.setBounds(60,80,120,30);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(200,80,150,30);
        add(ageTextField);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        genderLabel.setBounds(60,130,120,30);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200,130,70,30);
        maleRadioButton.setBackground(Color.white);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280,130,70,30);
        femaleRadioButton.setBackground(Color.white);
        add(femaleRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        JLabel courseLabel = new JLabel("COURSE");
        courseLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        courseLabel.setBounds(60,180,120,30);
        add(courseLabel);

        String[] courses = {"SELECT COURSE","B.Tech", "BCA", "BBA", "BHM", "M.Tech","MCA", "MBA"};
        courseComboBox = new JComboBox<String>(courses);
        courseComboBox.setBounds(200,180,150,30);
        courseComboBox.setBackground(Color.white);
        add(courseComboBox);

        JLabel batchLabel = new JLabel("BATCH");
        batchLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        batchLabel.setBounds(60,230,120,30);
        add(batchLabel);

        String[] batch = getAllBatch();
        batchComboBox = new JComboBox<String>(batch);
        batchComboBox.setBounds(200,230,150,30);
        batchComboBox.setBackground(Color.white);
        add(batchComboBox);

        JLabel enNumberLabel = new JLabel("En. NUMBER");
        enNumberLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        enNumberLabel.setBounds(60,280,120,30);
        add(enNumberLabel);

        enNumberTextField = new JTextField();
        enNumberTextField.setBounds(200,280,150,30);
        add(enNumberTextField);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        phoneLabel.setBounds(60,330,120,30);
        add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(200,330,150,30);
        add(phoneTextField);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        emailLabel.setBounds(60,380,120,30);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(200,380,150,30);
        add(emailTextField);

        JLabel bedTypeLabel = new JLabel("BED TYPE");
        bedTypeLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        bedTypeLabel.setBounds(60,430,120,30);
        add(bedTypeLabel);

        bedTypeComboBox = new JComboBox<String>(new String[]{"Single Bed", "Double Bed"});
        bedTypeComboBox.setBounds(200,430,150,30);
        bedTypeComboBox.setBackground(Color.white);
        add(bedTypeComboBox);

        JLabel roomNumLabel = new JLabel("ROOM NO.");
        roomNumLabel.setFont(new Font("tahoma", Font.PLAIN, 17));
        roomNumLabel.setBounds(60,480,120,30);
        add(roomNumLabel);

        getRoomNumButton = new JButton("Get Room");
        getRoomNumButton.setBackground(Color.black);
        getRoomNumButton.setForeground(Color.white);
        getRoomNumButton.setBounds(200,480,150,30);
        getRoomNumButton.addActionListener(this);
        add(getRoomNumButton);

        roomNumTextField = new JTextField();
        roomNumTextField.setBounds(200,480,150,30);
        roomNumTextField.setVisible(false);
        add(roomNumTextField);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.white);
        submitButton.setBounds(200,530,150,30);
        submitButton.addActionListener(this);
        add(submitButton);

        Image scaledImage = new ImageIcon(ClassLoader.getSystemResource("Images/student.png")).getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(350,0,500,500);
        add(imageLabel);

        JLabel newEntryLabel = new JLabel("NEW ENTRY");
        newEntryLabel.setForeground(Color.blue);
        newEntryLabel.setFont(new Font("tahoma",Font.PLAIN,30));
        newEntryLabel.setBounds(180,30,300,30);
        imageLabel.add(newEntryLabel);
    }

    private String[] getAllBatch() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int[] batch = new int[4];
        batch[0] = currentYear;
        for (int i=1;i<4;i++){
            batch[i] = --currentYear;
        }
        String[] strBatch = new String[5];
        strBatch[0] = "SELECT BATCH";
        for(int i=1;i<5;i++){
            strBatch[i] = String.valueOf(batch[i-1]);
        }
        return strBatch;
    }

    private String[] getRoomNum(String bedType, String gender){
        String hostel = gender.equals("male")?"boys_hostel":"girls_hostel";
        String query = "SELECT * FROM " + hostel + " WHERE room_type='" + bedType + "' AND available>=1";
        String data[] = new String[3];
        try{
            ResultSet resultSet = connection.statement.executeQuery(query);
            if(resultSet.next()){
                data[0] = resultSet.getString("room_num");
                data[1] = resultSet.getString("available");
                data[2] = hostel;
                return data;
            }
            else{
                data[0] = "-";
                data[1] = "-";
                data[2] = "-";
                return data;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        String age = ageTextField.getText();
        String enNumber = enNumberTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String gender = maleRadioButton.isSelected()?"male":femaleRadioButton.isSelected()?"female":null;
        String course = (String)courseComboBox.getSelectedItem();
        String batch = (String)batchComboBox.getSelectedItem();
        String bedType = (String) bedTypeComboBox.getSelectedItem();
        String[] data = getRoomNum(bedType,gender);
        String roomNum = data[0];
        int available = data[1].equals("-")?0:Integer.parseInt(data[1]);
        String hostel = data[2];
        String query = "insert into students values('"+name+"', '"+age+"', '"+gender+"', '"+enNumber+"', " +
                "'"+phone+"', '"+email+"', '"+course+"', '"+batch+"', '"+roomNum+"')";
        if(e.getSource() == getRoomNumButton){
            if(roomNum.equals("-")){
                JOptionPane.showMessageDialog(null, "Chosen bed type has no vacancy");
            }
            else {
                getRoomNumButton.setVisible(false);
                roomNumTextField.setText(roomNum);
                roomNumTextField.setEditable(false);
                roomNumTextField.setVisible(true);
            }
        }
        else if(e.getSource() == submitButton){
            try {
                connection.statement.executeUpdate(query);
                available--;
                String modQuery = "UPDATE " + hostel + " SET available=" + available + " WHERE room_num='" + roomNum + "'";
                connection.statement.executeUpdate(modQuery);
                JOptionPane.showMessageDialog(null,"Entry Added!");
            } catch (Exception e1){
                JOptionPane.showMessageDialog(null, "!Error Occurred!");
                e1.printStackTrace();
            }
            roomNumTextField.setVisible(false);
            getRoomNumButton.setVisible(true);
        }
    }
}
