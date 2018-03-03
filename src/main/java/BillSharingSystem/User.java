package BillSharingSystem;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

    String name;
    String emailId;
    int userid;

    public void register(int id){

    }

    public User(String n,String email,int id){
        this.userid = id;
        this.emailId = email;
        this.name = n;
    }
}
