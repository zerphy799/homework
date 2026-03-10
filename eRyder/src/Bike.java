
public class Bike {
    private String bikeId;
    private int batterylevel;
    private boolean isAvailable;
    private double kmDriven;
    private String company_Name="hello eRyder";
    private double base_Fare=1.0;
    private double per_Minute_Fare=0.5;
    private final String linked_Account;
    private final String linked_PhoneNumber;
    private double total_Fare;
    private int totalUsageINMinutes;
    public Bike(int batterylevel, String bikeId, boolean isAvailable, double kmDriven) {
        this.batterylevel = batterylevel;
        this.bikeId = bikeId;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.linked_Account = String.valueOf((int)(Math.random()*100000));
        this.linked_PhoneNumber = "184"+ (int) (Math.random() * 10000000);
    }

    public Bike(int batterylevel, String bikeId, boolean isAvailable, double kmDriven,String linked_Account, String linked_PhoneNumber) {
        this.batterylevel = batterylevel;
        this.linked_Account = linked_Account;
        this.linked_PhoneNumber = linked_PhoneNumber;
        this.bikeId = bikeId;
        this.kmDriven = kmDriven;
        this.isAvailable = isAvailable;
    }

    public int getBatterylevel() {
        return batterylevel;
    }

    public void setBatterylevel(int batterylevel) {
        if(batterylevel < 0||batterylevel > 100){
            System.out.println("Baterylevel must be between 0 and 100");
            return;
        }
        this.batterylevel = batterylevel;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }
    public void ride(){
        if(isAvailable&&batterylevel>0&&batterylevel<100){
            System.out.println("ID:"+bikeId+" this bike is available");
        }else{
            System.out.println("ID:"+bikeId+" this bike is not available");
        }
    }
    public void printBikeDetails(){
        System.out.println("ID:"+bikeId+"\nbatterylevel:"+batterylevel+"\nisavailable:"+isAvailable+"\nkmDriven:"+kmDriven+"km"+"\ncompany:"+company_Name);
    }
    public void printRideDetails(int usageInMinutes){
        System.out.println("account:"+linked_Account+"\nphone number:"+linked_PhoneNumber+"\nID:"+bikeId
        +"\ntotal Fare:"+calculateFare(usageInMinutes)+"￥\ntotalUsageINMinutes:"+usageInMinutes+" minutes"
        );
    }
    private double calculateFare(int usageInMinutes){
       return total_Fare=base_Fare+per_Minute_Fare*usageInMinutes;
    }
}
