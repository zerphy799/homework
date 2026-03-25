import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private String cvv;
    private String userType;
    private List<RegisteredUsers> registeredUsers=new ArrayList<>();
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public RegisteredUsers(String cardExpiryDate, String cardNumber, String cardProvider, String cvv, String dateOfBirth, String emailAddress, String fullName, String userType) {
        this.cardExpiryDate = cardExpiryDate;
        this.cardNumber = cardNumber;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.userType = userType;
    }

    public RegisteredUsers() {
    }

    @Override
    public String toString() {
        return "RegisteredUsers{" +
                "cardExpiryDate='" + cardExpiryDate + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardProvider='" + cardProvider + '\'' +
                ", cvv='" + cvv + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
    public void userManagementOption() {
        System.out.println("Welcome to E-Ryder Administrator Panel.\n" +
                "What do you want to do?\n" +
                "1. " + "Add New Users\n" +
                "2. " + "View Registered Users\n" +
                "3. " + "Remove Registered Users\n" +
                "4. " + "Update Registered Users\n" +
                "5. " + "EXIT");
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:addNewUser();break;
                case 2:viewRegisteredUsers();break;
                case 3:removeRegisteredUsers();break;
                case 4:updateRegisteredUsers();break;
                case 5:
                    System.out.println("Good bye");break;
                default:
                    System.out.println("Invalid choice"+"\nPlease try again");break;
            }
            if (choice == 5)
            {
                break;
            }
         }
    }
private void addNewUser() {
    System.out.println(" how many users the admin would like to add");
    Scanner scanner = new Scanner(System.in);
    int num=scanner.nextInt();
    for (int i = 0; i < num; i++) {
        System.out.println("please enter the information");
        fullName=scanner.next();
        emailAddress=scanner.next();
        cardNumber=scanner.next();
        cardProvider=scanner.next();
        cvv=scanner.next();
        dateOfBirth=scanner.next();
        cardExpiryDate=scanner.next();
        userType=scanner.next();
        RegisteredUsers re =new RegisteredUsers(cardExpiryDate,cardNumber,cardProvider,cvv,dateOfBirth,emailAddress,fullName,userType);
        registeredUsers.add(re);
        System.out.println("please enter the last three trip");
        String[] trip =new String[3];
        for (int i1 = 0; i1 < 3; i1++) {
            String date=scanner.next();
            String source=scanner.next();
            String destination=scanner.next();
            String fare=scanner.next();
            String feed=scanner.next();
            StringBuilder s = new StringBuilder();
            s.append("Date"+date);
            s.append("\tSource"+source);
            s.append("\tDestination"+destination);
            s.append("\tFare"+fare);
            s.append("\tFeed"+feed);
            trip[i1]=s.toString();
        }
        System.out.println("thank you");
    }
}
private void viewRegisteredUsers() {
        if(registeredUsers.isEmpty()){
            System.out.println("There are no registered users in the system");
}else registeredUsers.forEach(System.out::println);
}
private void removeRegisteredUsers() {
        if(registeredUsers.isEmpty()){
            System.out.println("There are no registered users in the system");
        }else{
            System.out.println(" Ask for the email address of the user that must be removed");
            Scanner scanner = new Scanner(System.in);
            String email=scanner.next();
            boolean b = registeredUsers.removeIf(registeredUser -> registeredUser.getEmailAddress().equals(email));
            if(b){
                System.out.println("Remove successful");
            }else System.out.println("Remove failed");
        }
}
private void updateRegisteredUsers() {
        if(registeredUsers.isEmpty()){
            System.out.println("There are no registered users in the system");
        }else{
            System.out.println(" Ask for the email address of the user that must be updated");
            Scanner scanner = new Scanner(System.in);
            String email=scanner.next();
            registeredUsers.forEach(registeredUser -> {
                if(registeredUser.getEmailAddress().equals(email)){
                    System.out.println("enter the new one");
                    String newEmail=scanner.next();
                 String  newfullName=scanner.next();
                 String  newcardNumber=scanner.next();
                  String  newcardProvider=scanner.next();
                  String  newcvv=scanner.next();
                  String  newdateOfBirth=scanner.next();
                  String  newcardExpiryDate=scanner.next();
                  String  newuserType=scanner.next();
                    registeredUser.setEmailAddress(newEmail);
                    registeredUser.setFullName(newfullName);
                    registeredUser.setCardNumber(newcardNumber);
                    registeredUser.setCardProvider(newcardProvider);
                    registeredUser.setCvv(newcvv);
                    registeredUser.setDateOfBirth(newdateOfBirth);
                   registeredUser.setEmailAddress(newuserType);
                   registeredUser.setCardExpiryDate(newcardExpiryDate);
                }else{
                    System.out.println("can't find the email address");
                }
            });
        }
}
}
