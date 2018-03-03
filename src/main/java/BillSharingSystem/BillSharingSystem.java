package BillSharingSystem;
import javafx.scene.chart.ScatterChart;

import java.util.Scanner;
public class BillSharingSystem {
    public UserIdGenerator generator ;
   public  UsersDatabase database ;

    public BillSharingSystem(){
         generator = new UserIdGenerator();
         database = new UsersDatabase();
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        BillSharingSystem system = new BillSharingSystem();
        System.out.println(UserInterfaceMessages.welcomeMessage);
        System.out.println(UserInterfaceMessages.basicOptionsDisplay);
        int listSize = UserInterfaceMessages.optionsList.length;
        for(int i=0;i<listSize;i++){
            System.out.println(i + " : " + UserInterfaceMessages.optionsList[i]);
        }
        int optionSelected = -1;
        optionSelected = scanner.nextInt();
        while (optionSelected!=UserInterfaceMessages.exitOptionNumber){
           // optionSelected = scanner.nextInt();
            switch (optionSelected){
                case 0 : system.register(scanner);optionSelected = scanner.nextInt();
                        break;
                case 1 : system.deleteUser(scanner);optionSelected = scanner.nextInt();break;
                case 2 : system.addBill(scanner);optionSelected = scanner.nextInt();
                    break;
                case 3 : system.getGroupBalances(scanner);optionSelected = scanner.nextInt();break;
                case 4 : system.getMyBalances(scanner);optionSelected = scanner.nextInt();break;
                case UserInterfaceMessages.exitOptionNumber : System.exit(0);
                default : System.exit(1);

            }
            //optionSelected = scanner.nextInt();
        }

    }

    public void register(Scanner scanner){
        System.out.println(UserInterfaceMessages.secondaryOptionsListRegister[0]);
        String name = scanner.next();
        System.out.println(UserInterfaceMessages.secondaryOptionsListRegister[1]);
        String email = scanner.next();
        int id = generator.generateUserId();
        User newUser = new User(name,email,id);
        database.addUserToDatabase(newUser);
        System.out.println(UserInterfaceMessages.registrationSuccessMessage);
        System.out.println(UserInterfaceMessages.idValuegeneration + " " + id);
        return;
    }

    public void addBill(Scanner scanner){
        int len = UserInterfaceMessages.secondaryOptionsListAddBill.length;
        System.out.println(UserInterfaceMessages.basicOptionsDisplay);
        for(int i=0;i<len;i++)
        {
            System.out.println((i+1) + " : " + UserInterfaceMessages.secondaryOptionsListAddBill[i]);

        }
        int response = scanner.nextInt();
        switch (response){
            case 1:break;
            case 2:
                System.out.println(UserInterfaceMessages.idCount);
                int count = scanner.nextInt();
                double percentages[] = new double[count];
                int ids[] = new int[count];
                double amounts[] = new double[count];

                System.out.println(UserInterfaceMessages.idValues);
                for(int i=0;i<count;i++)
                    ids[i] = scanner.nextInt();
                System.out.println(UserInterfaceMessages.amounts);
                for(int i=0;i<count;i++)
                    amounts[i] = scanner.nextDouble();
                System.out.println(UserInterfaceMessages.percentages);
                for(int i=0;i<count;i++)
                    percentages[i] = scanner.nextDouble();
                Bill individualBill = new Bill();
                individualBill.addBillBetweenIndividuals(amounts,percentages,ids);
                individualBill.printDues(database.userDatabase);
                break;
            case 3:break;
            default: return;

        }
    }

    public void getMyBalances(Scanner scanner){

    }

    public void getGroupBalances(Scanner scanner){

    }

    public void deleteUser(Scanner scanner){

    }
}
