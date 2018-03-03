package BillSharingSystem;
import java.util.HashMap;
public class UsersDatabase {

    HashMap<Integer,User> userDatabase;
    int usersCount;
    public UsersDatabase(){
        userDatabase = new HashMap<Integer, User>();
        usersCount = 0;
    }

    public User getUserById(int id){
        // May return null
        User answer = userDatabase.get(id);
        return answer;
    }

    public boolean addUserToDatabase(User user){
        int id = user.userid;
        userDatabase.put(id,user);
        usersCount++;
        return true;
    }

    public boolean deleteUserFromDatabase(int userid){
        userDatabase.remove(userid);
        usersCount--;
        return true;
    }

    public int getUsersCountInDatabase(){
        return usersCount;
    }
}
