import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    public void trackActiveRentals(){
        if(activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment");
        }else activeRentalsList.forEach(System.out::println);
    }
    public void endRental(String bikeID){
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getBikeID().equals(bikeID)){
                iterator.remove();
                break;
            }
        }
        BikeDatabase.bikes.forEach(Bike -> {
            if (Bike.getBikeID().equals(bikeID)) {
                Bike.setAvailable(true);
                System.out.println(" Your trip has ended. Thank you for riding with us.");
            }
        });
    }
    public void startRental(String bikeID) {
        if(!bikeID.isEmpty()){
            BikeDatabase.bikes.forEach(Bike -> {if (Bike.getBikeID().equals(bikeID)) {
                tripStartTime = LocalDateTime.now();
                Bike.setAvailable(false);
                Bike.setLastUsedTime(tripStartTime);
                System.out.println(": Reserving the bike with the (bikeID). Please following the on-screen instructions\n" +
                        "to locate the bike and start your pleasant journey.");
                ActiveRental activeRental = new ActiveRental(bikeID,emailAddress,tripStartTime);
                activeRentalsList.add(activeRental);
            }});
        }else System.out.println("Sorry, no bikes are available at the location you");
    }
}
