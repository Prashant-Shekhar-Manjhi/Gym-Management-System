package Members;

import jdbc.JdbcConnection;

import javax.swing.*;

public class Trainer {
    private String name;
    private String email;
    private String contactNo;
    private String address;

    public Trainer(String name, String email, String contactNo, String address){
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
    }

    public boolean addTrainer(){
        try {
            //JDBC connection...
            JdbcConnection con = new JdbcConnection();
            String query = "insert into trainers (name, email, contact_no, address) values('"+name+"', '"+email+"', '"+contactNo+"','"+address+"')";
            con.stm.executeUpdate(query);
            con.stm.close();
            con.con.close();
            return true;
        }catch (Exception exc){
            exc.printStackTrace();
            return false;
        }
    }
}
