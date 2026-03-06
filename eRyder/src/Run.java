public class Run {
public static void main(String[] args) {
    Bike bike = new Bike();
    bike.printBikeDetails();
    Bike newBike = new Bike(85,"123456",true,42.2);
    newBike.printBikeDetails();
    newBike.ride();
}
}
