package HostelAccommodationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RemoveStudent extends JFrame implements ActionListener {

    private JTextField enrollNumTextField;
    private JButton removeButton;

    RemoveStudent(){
        setLayout(null);
        setBounds(580,200,360,300);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel enrollNumLabel = new JLabel("Enroll Num");
        enrollNumLabel.setBounds(40,20,100,30);
        add(enrollNumLabel);

        enrollNumTextField = new JTextField();
        enrollNumTextField.setBounds(200,20,120,30);
        add(enrollNumTextField);

        removeButton = new JButton("Remove");
        removeButton.setBackground(Color.black);
        removeButton.setForeground(Color.white);
        removeButton.setBounds(110,70,120,30);
        removeButton.addActionListener(this);
        add(removeButton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String enrollNum = enrollNumTextField.getText();
        String query = "SELECT * FROM students WHERE en_num='" + enrollNum + "'";
        String removeQuery = "DELETE FROM students WHERE en_num='"+ enrollNum + "'";
        DB_Connection connection = new DB_Connection();
        try{
            ResultSet resultSet = connection.statement.executeQuery(query);
            if(resultSet.next()){
                connection.statement.executeUpdate(removeQuery);
                JOptionPane.showMessageDialog(null, "Student Removed!");
            } else{
                JOptionPane.showMessageDialog(null, "No student found.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
