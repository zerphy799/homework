public class Run {
public static void main(String[] args) {
    Bike bike = new Bike(64,"123555",true,56.2);
    bike.printBikeDetails();
    System.out.println("-------------------");
    bike.printRideDetails(32);
    System.out.println("------------------");
    Bike newBike = new Bike(85,"123456",true,42.2,"411681","18351992562");
    newBike.printBikeDetails();
    System.out.println("-----------------");
    newBike.printRideDetails(15);
    newBike.ride();
}
}
