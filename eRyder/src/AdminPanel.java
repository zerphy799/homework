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
                        rentalService.startRental(startBikeId);break;
                      case 2:  System.out.println("Enter RentalID");
                      String startRentalId=sc.next();
                      rentalService.endRental(startRentalId);break;
                      case 3:
                      rentalService.trackActiveRentals();break;
                    }
                }break;

            }





        }
    }

}
