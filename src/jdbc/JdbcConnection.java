package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JdbcConnection {
    public Connection con;
    public Statement stm;
    public JdbcConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/gym_management_system";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
