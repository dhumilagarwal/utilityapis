package AutomatedParkingSystem;

public enum PaymentGateway {
    billdesk,
    companyowned,
    techprocess;

    public static final String billDeskUrl = "BillDeskUrl";
    public static final String companyOwnedUrl = "BillDeskUrl";
    public static final String techProcessUrl = "BillDeskUrl";

    public String getUrl() {
        switch (this){
            case billdesk: return billDeskUrl;
            case techprocess: return companyOwnedUrl;
            case companyowned: return techProcessUrl;
        }
        return "No Payment Gateway available";
    }
}
