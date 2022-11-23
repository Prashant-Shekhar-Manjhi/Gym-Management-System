package Members;

import jdbc.JdbcConnection;

import javax.swing.*;

public class Member {
    private String email;
    private String name;
    private String contactNo;
    private String address;
    private String gender;
    private String dateOfJoining;
    private String gymTime;
    private String dateOfBirth;
    private String fee;
    private String trainer;

    public  Member(
            String name,
            String phone,
            String email,
            String dob,
            String doj,
            String address,
            String gender,
            String time,
            String fee,
            String trainer
            ){
        this.name = name;
        this.contactNo = phone;
        this.email = email;
        this.dateOfBirth = dob;
        this.dateOfJoining = doj;
        this.address = address;
        this.gender = gender;
        this.fee = fee;
        this.gymTime = time;
        this.trainer = trainer;
    }
    public void showMemberDetails(){}
    public void updateMemberDetails(){}
    public boolean addMemberToDB(){
        try {
            //JDBC connection...
            JdbcConnection con = new JdbcConnection();
            String query = "insert into members (name, email, contact_no, address, gender, date_of_birth, fee, date_of_joining, gym_time, trainer_name) values('"+name+"', '"+email+"', '"+contactNo+"','"+address+"', '"+gender+"', '"+dateOfBirth+"', '"+fee+"', '"+dateOfJoining+"', '"+gymTime+"', '"+trainer+"')";
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
