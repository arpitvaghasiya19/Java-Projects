package universitymanagementsystem;

import java.sql.*;

public class Connec {

    Connection c;
    Statement s;

    Connec() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universityManagement", "root", "Abv#19553");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

