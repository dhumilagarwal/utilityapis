package BillSharingSystem;
import java.util.Random;

public class UserIdGenerator {
    public static int userId;

    public UserIdGenerator(){
        userId = 0;
    }
    public int generateUserId(){
        userId++;
        return userId;
    }
}
