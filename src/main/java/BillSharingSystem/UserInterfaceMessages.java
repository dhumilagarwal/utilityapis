package BillSharingSystem;
public class UserInterfaceMessages {
    public static final String welcomeMessage = "Welcome to Bill Sharing System";
    public static final String optionsList[] = {"Register Yourself" , "Delete Yourself", "Add Bill",
        "Get balance of group","Get my balances","Exit"};
    public static final int exitOptionNumber = 5;
    public static final String basicOptionsDisplay = "Choose any option. " + "\n";
    public static final String secondaryOptionsListRegister[] = {"Name","EmailId"};
    public static final String secondaryOptionsListDelete[] = {"Are you sure",
            "You cannot be deleted as your balances are not clear"};
    public static final String secondaryOptionsListAddBill[] = {"Do not share","Share with individuals",
                                                                "Share with groups"};
    public static final String secondaryOptionsListGroupBalances[] = {"Select group"};

    public static final String registrationSuccessMessage = "Registration completed successfully";

    public static final String idValuegeneration = "Your registration id is : ";
    public static final String idCount = "Enter number of people involved";
    public static final String idValues = "Enter ids of users involved";
    public static final String amounts = "Enter contributions by each in same order as ids";
    public static final String percentages = "Enter percentage share of each";


}
