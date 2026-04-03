import java.time.LocalDateTime;
import java.util.Stack;

public class ERyderLog {
    private static Stack<ERyderLog> logStack = new Stack<>();
    private String log;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String log, String event, LocalDateTime timeStamp) {
        this.log = log;
        this.event = event;
        this.timeStamp = timeStamp;
    }

    public static void pushLog(String logId, String event) {
        ERyderLog logEntry = new ERyderLog(logId, event, LocalDateTime.now());
        logStack.push(logEntry);
    }

    public static void viewSystemLogs() {
        System.out.println("\n=== System Logs ===");
        for (ERyderLog log : logStack) {
            System.out.println(log);
        }
    }

    public String getLog() {
        return log;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return log + " - " + event + " - " + timeStamp;
    }
}
