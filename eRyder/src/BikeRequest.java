import java.time.LocalDateTime;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeRequest {
    private String userEmail;
    private String location;
    private LocalDateTime requestTime;

    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "User: " + userEmail + " | Location: " + location + " | Time: " + requestTime;
    }

    private static Queue<BikeRequest> requestQueue = new ArrayDeque<>();

    public static void addRequest(String userEmail, String location) {
        BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
        requestQueue.add(request);
    }

    public static BikeRequest assignNextRequest() {
        if (!requestQueue.isEmpty()) {
            return requestQueue.poll();
        }
        return null;
    }

    public static void viewQueue() {
        System.out.println("\n=== Pending Bike Requests ===");
        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        for (BikeRequest req : requestQueue) {
            System.out.println(req);
        }
    }

    public static void removeFirstRequest() {
        if (!requestQueue.isEmpty()) {
            requestQueue.poll();
            System.out.println("First request removed.");
        } else {
            System.out.println("Queue is empty.");
        }
    }
}
