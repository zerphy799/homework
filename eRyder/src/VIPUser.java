
public class VIPUser extends RegisteredUsers {

    public VIPUser(String fullName, String emailAddress, String dateOfBirth,
                   String cardNumber, String cardProvider, String cardExpiryDate,
                   String cvv, String userType) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType);
    }

    @Override
    public double calculateFare(double baseFare) {
        return baseFare * 0.8;
    }
    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }
}
