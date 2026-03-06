public class Bike {
    private String bikeId;
    private int batterylevel;
    private boolean isAvailable;
    private double kmDriven;

    public Bike() {
    }

    public Bike(int batterylevel, String bikeId, boolean isAvailable, double kmDriven) {
        this.batterylevel = batterylevel;
        this.bikeId = bikeId;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    public int getBatterylevel() {
        return batterylevel;
    }

    public void setBatterylevel(int batterylevel) {
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
        }
    }
    public void printBikeDetails(){
        System.out.println("ID:"+bikeId+"\nbatterylevel:"+batterylevel+"\nisavailable:"+isAvailable+"\nkmDriven:"+kmDriven+"km");
    }
}
