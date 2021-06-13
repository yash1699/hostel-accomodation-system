package HostelAccommodationProject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB_Connection {
    Connection conn;
    Statement statement;
    DB_Connection(){
        try{
//            Class.forName("com.mysql.jdbc.Driver"); Loading of this class is deprecated. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/has_project", "root", "root");
            statement = conn.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
