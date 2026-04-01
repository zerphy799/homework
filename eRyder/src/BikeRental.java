import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    public BikeRental() {
    }
   public void simulateApplicationInput(){
       System.out.println(" This is the simulation of the e-bike rental process.");
       Scanner scanner = new Scanner(System.in);
       isRegisteredUser = scanner.nextBoolean();
       scanner.next();
       emailAddress = scanner.nextLine();
       location = scanner.nextLine();
       System.out.println(" Simulating the analysis of the rental request.");
       bikeID=analyseRequest();
       if(!locationValid){
           return ;
       }
       System.out.println("Simulating e-bike reservation…");
       reserverBike(bikeID);
       System.out.println(" Displaying the active rentals…");
       viewActiveRentals();
       System.out.println(": Simulating the end of the trip…");
       removeTrip(bikeID);
       System.out.println(" Displaying the active rentals after trip end…");
       viewActiveRentals();
   }
   private String analyseRequest(){
       if(isRegisteredUser){
           System.out.println(" Welcome back, (emailAddress value)!");
       }else{
           System.out.println("You’re not our registered user. Please consider registering.");
           UserRegistration us = new UserRegistration();
           us.registration();
       }
   return validateLocation(location);
   }
   private String validateLocation(String location) {
       for (Bike bike : BikeDatabase.bikes) {
           if (bike.getLocation().equals(location) && bike.isAvailable()) {
               locationValid = true;
               return bike.getBikeID();
           }
       }
       System.out.println(" Sorry, no bikes are available at the location you\n" +
               "requested. Please try again later.");
       return null;
   }
   private void reserverBike(String bikeID) {
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
   private void viewActiveRentals(){
       if(activeRentalsList.isEmpty()){
           System.out.println("No active rentals at the moment");
       }else activeRentalsList.forEach(System.out::println);
   }
   private void removeTrip(String bikeID){
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

}
