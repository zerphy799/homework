import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Spliterator;

public class AdminPanel {
    public static void main(String[] args) {
        System.out.println("Welcome Admin Panel");
        int choice=1;
        Scanner sc=new Scanner(System.in);
        while(choice!=0){
            System.out.println("1: userService"+
                    "\n2:bikeService"+"\n3:rentalService");
            choice=sc.nextInt();
            switch(choice){
                case 1:UserService.userService();break;
                case 2:
                    int choice2=6;
                    BikeService bikeService=new BikeService();
                    while(choice2!=0){
                        System.out.println("1: Find available bikes"+"\n2:Validate location"+"\n3:Reserve Bike"+
                                "\n4:release bike"+"\n0:return last system");
                        switch(choice2){
                            case 1:bikeService.viewActiveRentals();break;
                            case 2:
                                System.out.println("Enter location:");
                                String location=sc.next();
                                bikeService.validateLocation(location);break;
                            case 3:
                                System.out.println("Enter bikeId");
                                String bikeId=sc.next();
                                bikeService.reserverBike(bikeId);break;
                            case 4:
                                System.out.println("Enter rentalId");
                                String rentalId=sc.next();
                                bikeService.removeTrip(rentalId);break;
                        }
                    }break;
                case 3: RentalService rentalService=new RentalService();
                int choice3=6;
                while(choice3!=0){
                    System.out.println("1:start rental"+"\n2:End rental"+"\n3:track active bike"+"\n0:return last system");
                    choice3=sc.nextInt();
                    switch(choice3){
                      case 1:  System.out.println("Enter BikeID");
                        String startBikeId=sc.next();
                        rentalService.startRental(startBikeId);
                        break;
                      case 2:  System.out.println("Enter RentalID");
                      String startRentalId=sc.next();
                      rentalService.endRental(startRentalId);break;
                      case 3:
                      rentalService.trackActiveRentals();break;
                    }
                }break;
                case 4: ERyderLog.viewSystemLogs();break;
                case 5:
                    int choice5=6;
                    while(choice5!=0) {
                        System.out.println("1. Add Bike Request");
                        System.out.println("2. View Pending Requests");
                        System.out.println("3. Remove First Request");
                        System.out.println("0: exit");
                        choice5=sc.nextInt();
                    switch(choice5) {
                        case 1:
                            System.out.print("Enter user email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter location: ");
                            String loc = sc.nextLine();
                            BikeRequest.addRequest(email,loc);
                            System.out.println("Request added successfully!");
                            break;

                        case 2:
                            BikeRequest.viewQueue();
                            break;

                        case 3:
                            BikeRequest.removeFirstRequest();
                            break;

                    }
                    }
                    }





        }
    }

}
