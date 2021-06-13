package HostelAccommodationProject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchStudent extends JFrame implements ActionListener {

    private JTable table;
    private JComboBox<String> searchByComboBox;
    private JTextField inputTextField;
    private JButton loadButton;
    SearchStudent(){
        setLayout(null);
        setBounds(300,160,1000,650);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] searchBy = {"-Search By-", "Name", "En Number", "Phone", "Email", "Room No."};
        searchByComboBox = new JComboBox<>(searchBy);
        searchByComboBox.setBackground(Color.white);
        searchByComboBox.setBounds(370,20,120,30);
        add(searchByComboBox);

        inputTextField = new JTextField();
        inputTextField.setBounds(510,20,120,30);
        add(inputTextField);

        loadButton = new JButton("Load");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setBounds(440,70,120,30);
        loadButton.addActionListener(this);
        add(loadButton);

        table = new JTable();
        table.setBounds(0,190,1000,500);
        table.setEnabled(false);
        add(table);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(35,110,70,30);
        add(nameLabel);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setBounds(150,110,70,30);
        add(ageLabel);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setBounds(250,110,70,30);
        add(genderLabel);

        JLabel enNumLabel= new JLabel("En NO.");
        enNumLabel.setBounds(370,110,70,30);
        add(enNumLabel);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setBounds(470,110,70,30);
        add(phoneLabel);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setBounds(590,110,70,30);
        add(emailLabel);

        JLabel courseLabel = new JLabel("COURSE");
        courseLabel.setBounds(700,110,70,30);
        add(courseLabel);

        JLabel batchLabel = new JLabel("BATCH");
        batchLabel.setBounds(810,110,70,30);
        add(batchLabel);

        JLabel roomNumLabel = new JLabel("ROOM NO.");
        roomNumLabel.setBounds(905,110,70,30);
        add(roomNumLabel);
    }

    public String getSearchByComboBox() {
        String searchBy= "";
        String selected = (String)searchByComboBox.getSelectedItem();
        if(selected.equals("Name")){
             searchBy = "name";
        } else if(selected.equals("En Number")){
            searchBy = "en_num";
        } else if(selected.equals("Phone")){
            searchBy = "phone";
        } else if(selected.equals("Email")){
            searchBy = "email";
        } else if(selected.equals("Room No.")){
            searchBy = "room_num";
        }
        return searchBy;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inputTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please input selected tag of the student");
        }
        else{
            String searchBy = getSearchByComboBox();
            String input = inputTextField.getText();
            String query = "SELECT * FROM students WHERE " + searchBy + "='" + input + "'";
            DB_Connection connection = new DB_Connection();
            try {
                ResultSet resultSet = connection.statement.executeQuery(query);
                if (!(resultSet.isBeforeFirst()))
                    JOptionPane.showMessageDialog(null,"No match found");
                else
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
