package HostelAccommodationProject;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private JLabel nameLabel, passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    Login() {
        setBounds(500, 200, 600, 250);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        nameLabel = new JLabel("Username");
        nameLabel.setBounds(40, 20, 100, 30);
        add(nameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        add(passwordLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 20, 150, 30);
        add(nameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.setBounds(40, 150, 120, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);
        cancelButton.setBounds(180, 150, 120, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        Image scaledImage = new ImageIcon(ClassLoader.getSystemResource("Images/second.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(350, 10, 200, 200);
        add(imageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userName = nameField.getText();
            String password = passwordField.getText();
            DB_Connection connection = new DB_Connection();

            String query = "select * from login where username ='"+ userName + "' and password = '" + password + "';";
            try{
                ResultSet resultSet = connection.statement.executeQuery(query);
                if(resultSet.next()){
                    this.dispose();
                    new Dashboard().setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }
}
