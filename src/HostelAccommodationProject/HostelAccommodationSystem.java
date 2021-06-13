package HostelAccommodationProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostelAccommodationSystem extends JFrame implements ActionListener {

    // Constructor to crate a frame
    HostelAccommodationSystem(){

//        Setting location and dimensions of the frame
        setBounds(300,150,960,540);

//        Default layout is border layout. Setting it to null.
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Getting image from the system
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Images/first.jpg"));
        JLabel imageLabel = new JLabel(image);

//        Setting up image location in JFrame and its dimensions
        imageLabel.setBounds(0,0,960,540);
        add(imageLabel);

//        Name Label
        JLabel nameLabel = new JLabel("Hostel Accommodation System");
        nameLabel.setBounds(150,50,800,100);
        nameLabel.setForeground(Color.yellow);
        nameLabel.setFont(new Font("serif", Font.PLAIN,50));
        imageLabel.add(nameLabel);

//        Next Button
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(Color.white);
        nextButton.setForeground(Color.black);
        nextButton.setBounds(770,440,100,30);
        nextButton.addActionListener(this);
        imageLabel.add(nextButton);

        setVisible(true);

//        Infinite loop to make the name label blink every 500ms
        while(true){
            nameLabel.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            nameLabel.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new Login().setVisible(true);
    }

    public static void main(String[] args){
        new HostelAccommodationSystem();
    }
}
