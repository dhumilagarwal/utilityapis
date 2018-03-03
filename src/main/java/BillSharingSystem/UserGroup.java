package BillSharingSystem;
import java.util.ArrayList;
public class UserGroup {

    ArrayList<User> groupMembers;
    int userCount;
    ArrayList<Bill> groupBills;

    public boolean addUser(User user){
        // Check if member is already there
        int i=0;
        for(i=0;i<userCount;i++){
            if(groupMembers.get(i).userid==user.userid)
                break;
        }
        // If user is already a member, do not add. return false;
        if(i<userCount) return false;
        groupMembers.add(user);
        userCount++;
        return true;
    }

    public UserGroup(User user){
        groupMembers = new ArrayList<User>();
        userCount = 1;
        groupMembers.add(user);
    }

    public boolean removeUser(int userId){
        return false;
    }


}
