package HostelAccommodationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class AllStudentInfo extends JFrame implements ActionListener {

    private JTable table;
    private JButton refreshButton;
    AllStudentInfo(){
        setLayout(null);
        setBounds(300,160,1000,650);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        table = new JTable();
        table.setBounds(0,40,1000,500);
        table.setEnabled(false);
        add(table);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(35,10,70,20);
        add(nameLabel);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setBounds(150,10,70,20);
        add(ageLabel);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setBounds(250,10,70,20);
        add(genderLabel);

        JLabel enNumLabel = new JLabel("EN NUM");
        enNumLabel.setBounds(360,10,70,20);
        add(enNumLabel);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setBounds(470,10,70,20);
        add(phoneLabel);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setBounds(590,10,70,20);
        add(emailLabel);

        JLabel courseLabel = new JLabel("COURSE");
        courseLabel.setBounds(690,10,70,20);
        add(courseLabel);

        JLabel batchLabel = new JLabel("BATCH");
        batchLabel.setBounds(810,10,70,20);
        add(batchLabel);

        JLabel roomNumLabel = new JLabel("ROOM NO.");
        roomNumLabel.setBounds(905,10,70,30);
        add(roomNumLabel);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(435,560,120,30);
        refreshButton.setBackground(Color.black);
        refreshButton.setForeground(Color.white);
        refreshButton.addActionListener(this);
        add(refreshButton);

        loadTableData();
    }

    private void loadTableData(){
        try{
            DB_Connection connection = new DB_Connection();
            String query = "SELECT * FROM students";
            ResultSet resultSet = connection.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loadTableData();
    }
}
