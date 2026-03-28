import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class UserRegistration {
    private final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 0.25;
    private final double VIP_DISCOUNT_UNDER_18 = 0.20;
    private final double VIP_BASE_FEE =100.0;
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid=false;
    private boolean minorAndBirthday=false;
    private boolean minor=false;
    private boolean ageValid=false;
    private boolean cardNumberValid=false;
    private boolean validCVV=false;
    private boolean cardStillValid=false;
    public  void registration(){
        while(true) {
            System.out.println("Welcome to the ERyder Registration.\n" +
                    "Here are your two options:\n" +
                    "1. Register as a Regular User\n" +
                    "2. Register as a VIP User\n" +
                    "Please enter your choice (1 or 2):");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    userType = "REGULAR USER";
                    break;
                default:
                    userType = "VIP USER";
                    break;
            }
            System.out.println("Please enter their full name");
            fullName = sc.next();
            System.out.println("Please enter the email address");
            sc.nextLine();
            emailAddress = sc.next();
            analyseEmail();
            if(!emailValid){
                continue;
            }
            System.out.println("Please enter the date of birth,the formater is YYYY-MM-DD");
            dateOfBirth = sc.next();
            LocalDate dob = LocalDate.parse(dateOfBirth);
            ageValid = analyseAge(dob);
            if(!ageValid){
                continue;
            }
            System.out.println("Please enter the card number" + "\nPlease attention that only Visa, MasterCard, and American Express cards are accepted.");
            cardNumber = sc.nextLong();
            cardNumberValid = analyseCardNumber();
            if(!cardNumberValid){
                continue;
            }
            System.out.println("Please enter the card expiry date");
            cardExpiryDate = sc.next();
            cardStillValid = analyseCardExpiryDate();
            if(!cardStillValid){
                continue;
            }
            System.out.println("Please enter the cvv");
            cvv = sc.nextInt();
            validCVV = analyseCVV();
            if(!validCVV){
                continue;
            }
            finalCaheckpoint();
            if(emailValid&&ageValid&&cardNumberValid&&cardStillValid&&validCVV){
                System.out.println(this);
                break;
            }
        }
    }
    private boolean analyseEmail(){
        if(emailAddress.contains("@")&&emailAddress.contains(".")){
            System.out.println("Email is valid");
            return emailValid=true;
        }else{
            System.out.println("Email is not valid.Please try again");
            registration();
            return emailValid=false;
        }
    }
    private boolean analyseAge(LocalDate dob){
        LocalDate currentDate = LocalDate.now();
        long years = ChronoUnit.YEARS.between(dob,currentDate);
        Period period = Period.between(dob,currentDate);
        boolean isBirthday = false;
        if(period.getMonths()==0&&period.getDays()==0){
            isBirthday=true;
        }
        if(userType.equals("VIP USER")){
            if(years<18&&years>12){
                if(isBirthday){
                    System.out.println("Happy Birthday to you"+"\nYou get 25% discount on the VIP subscription fee for being born today and being under 18! ");
                    minorAndBirthday= true;
                    return true;
                }
                else{
                    minor=true;
                    System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                    return true;
                }
            }else if(years>120||years<12){
                System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day");
                System.exit(0);
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    private boolean analyseCardNumber(){
        String  cardNumberStr=String.valueOf(cardNumber);
        int firstTwoDigits;
        String s = cardNumberStr.substring(0, 2);
        firstTwoDigits = Integer.parseInt(s);
        int firstFourDigits;
        firstFourDigits = Integer.parseInt(cardNumberStr.substring(0,4));
        if(cardNumberStr.length()==13||cardNumberStr.length()==15){
            if(cardNumberStr.startsWith("4")){
                cardProvider="VISA";
                return true;
            }
            if(cardNumberStr.length()==15){
            if(cardNumberStr.startsWith("34")||cardNumberStr.startsWith("37")){
                cardProvider="American Express";
                return true;
            }
            }
        }else if(cardNumberStr.length()==16){
            if(firstTwoDigits>=51&&firstTwoDigits<=55){
                cardProvider="MasterCard";
                return true;
            }else if(firstFourDigits>=2221&&firstFourDigits<=2720){
                cardProvider="MasterCard";
                return true;
            }
        }else {
            System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.\n" +
                    "Going back to the start of the registration. ");
            return  false;
        }
        return false;
    }
    private boolean analyseCardExpiryDate(){
        int month=Integer.parseInt(cardExpiryDate.substring(0,2));
        int year=Integer.parseInt(cardExpiryDate.substring(2,5))+2000;
        LocalDate currentDate =LocalDate.now();
        int currentMonth=currentDate.getMonthValue();
        int currentYear=currentDate.getYear();
        if(currentYear<=year&&currentMonth<=month){
            System.out.println("The card is still valid");
            return true;
        }
        System.out.println("Sorry, your card has expired. Please use a different card.\n" +
                "Going back to the start fo the registration process…");
        return  false;
    }
    private  boolean analyseCVV(){
        String  cvvStr=String.valueOf(cvv);
        if((cardProvider.equals("American Express")&&cvvStr.length()==4)||(cardProvider.equals("MasterCard")&&cvvStr.length()==3)||(cardProvider.equals("VISA")&&cvvStr.length()==3)){
            System.out.println("The card is still valid");
            return true;
        }
        System.out.println("Invalid CVV for the given card.\n" +
                "Going back to the start of the registration process");
        return  false;
    }
    private void finalCaheckpoint(){
        boolean a=false;
        if(emailValid&&ageValid&&cardNumberValid&&cardStillValid&&validCVV){
          chargeFees();
        }else if(!emailValid){
            a=true;
            System.out.println("Invalid email address");
        }else if(!cardNumberValid){
            a=true;
            System.out.println("Invalid card number");
        }else if(!cardStillValid){
            a=true;
            System.out.println(" Card has expired");
        }else if(!validCVV){
            a=true;
            System.out.println("Invalid CVV");
        }else if(!ageValid) {
            a=true;
            System.out.println("Invalid age");
        }
        if(a){
            System.out.println("Going back to the start of the registration process.");
        }
    }
    private void chargeFees() {
        if (userType.equals("VIP USER")) {
            if (minorAndBirthday) {
                feeToCharge = VIP_DISCOUNT_UNDER_18_BIRTHDAY * VIP_BASE_FEE;
            } else if (minor) {
                feeToCharge = VIP_DISCOUNT_UNDER_18 * VIP_BASE_FEE;
            } else {
                feeToCharge = VIP_BASE_FEE;
            }
            String string = String.valueOf(cardNumber);

            System.out.println("Thank you for your payment. \n" +
                    "A fee of " + feeToCharge + "has been charged to your card ending with " + string.substring(string.length() - 4) + "\n");
        }else {
            System.out.println("You don't need pay for anything");
        }
    }
    @Override
    public String toString() {
        String cardNumberStr=String.valueOf(cardNumber);
        String censoredNumber=cardNumberStr.substring(0,cardNumberStr.length()-4).replaceAll(".","*")+cardNumberStr.substring(cardNumberStr.length()-4);
        return "Registration successful! Here are your details:\n" +
                "User Type: "+userType +
                "\nFull Name: "+fullName +
                "\nEmail Address: " +emailAddress+
                "\nDate of Birth: "+dateOfBirth +
                "\nCard Number: "+censoredNumber +
                "\nCard Provider:"+cardProvider +
                "\nCard Expiry Date:"+cardExpiryDate;
    }
}

