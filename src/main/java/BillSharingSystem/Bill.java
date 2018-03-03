package BillSharingSystem;
import java.util.ArrayList;
import java.util.HashMap;

public class Bill {

    double billAmount;
    public ArrayList<Integer> userids;
    public ArrayList<Double> consumptions;
    public ArrayList<Double> dues;

    public void addBillBetweenIndividuals(double amounts[],double percentageShares[],int ids[]){
        int len = amounts.length;
        billAmount = 0;
        for(int i=0;i<len;i++){
            billAmount = billAmount + amounts[i];
            userids.add(ids[i]);
            consumptions.add(0.0);
             dues.add(0.0);
        }
        for(int i=0;i<len;i++){
            double consumption = (percentageShares[i] * billAmount)/100;
            consumptions.set(i,consumption);
            // Due value is amount to be paid.
            dues.set(i,consumption - amounts[i]);
        }


    }

    public void createShares(){
        int len = userids.size();

    }
    public Bill(){
        userids = new  ArrayList<Integer>();
        consumptions = new ArrayList<Double>();
        dues = new ArrayList<Double>();
        billAmount = 0;
    }

    public void printDues(HashMap<Integer,User> userDatabase){
        int len = userids.size();
        for(int i=0;i<len;i++){
            int id = userids.get(i);
            User user= userDatabase.get(id);
            System.out.print(user.name + " : ");
            System.out.println(dues.get(i).intValue());
        }
    }


}
