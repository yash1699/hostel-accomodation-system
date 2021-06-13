package HostelAccommodationProject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomDetails extends JFrame implements ActionListener {
    private JTable table;
    private JButton loadButton;
    private JComboBox<String> hostelTypeComboBox;
    RoomDetails(){
        setLayout(null);
        setBounds(300,160,1000,650);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        table = new JTable();
        table.setBounds(0,40,1000,500);
        table.setEnabled(false);
        add(table);

        JLabel roomNumLabel = new JLabel("ROOM NUMBER");
        roomNumLabel.setBounds(80,10,100,20);
        add(roomNumLabel);

        JLabel bedTypeLabel = new JLabel("BED TYPE");
        bedTypeLabel.setBounds(350,10,100,20);
        add(bedTypeLabel);

        JLabel priceLabel = new JLabel("PRICE");
        priceLabel.setBounds(600,10,100,20);
        add(priceLabel);

        JLabel vacancyLabel = new JLabel("VACANCY");
        vacancyLabel.setBounds(820,10,100,20);
        add(vacancyLabel);

        hostelTypeComboBox = new JComboBox<>(new String[]{"-SELECT HOSTEL-","Boys Hostel", "Girls Hostel"});
        hostelTypeComboBox.setBackground(Color.white);
        hostelTypeComboBox.setBounds(350,560,140,30);
        add(hostelTypeComboBox);

        loadButton = new JButton("Load");
        loadButton.setBounds(520,560,120,30);
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.addActionListener(this);
        add(loadButton);
    }

    private void loadTableData(String hostel){
        try{
            DB_Connection connection = new DB_Connection();
            String query = "SELECT * FROM " + hostel;
            ResultSet resultSet = connection.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String hostelType = hostelTypeComboBox.getSelectedItem().equals("Boys Hostel")?"boys_hostel":
                hostelTypeComboBox.getSelectedItem().equals("Girls Hostel")?"girls_hostel":"";
        if(hostelType.equals("")){
            JOptionPane.showMessageDialog(null,"Please select a hostel");
        }
        else
            loadTableData(hostelType);
    }
}
