
public class RegularUser extends RegisteredUsers {

    public RegularUser(String fullName, String emailAddress, String dateOfBirth,
                       String cardNumber, String cardProvider, String cardExpiryDate,
                       String cvv, String userType) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType);
    }

    @Override
    public double calculateFare(double baseFare) {
        return super.calculateFare(baseFare);
    }

    @Override
    public void displayUserType() {
        System.out.println("Regular User");
    }
}