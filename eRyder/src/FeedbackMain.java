import java.util.SortedMap;

public class FeedbackMain {
    public static void main(String[] args) {
        Feedback feedback = new Feedback("Tom", "Xinpusen", "4668884@123.com");
        String sent1 = "I was very satisfied with the service.", sent2 = "The e-Bike is quite comfortable to ride.", sent3 = "The battery life of the e-Bike is impressive.",
                sent4 = "The customer support was helpful and responsive.",
                sent5 = "I would recommend this e-Bike to my friends and family.";
        long l = System.currentTimeMillis();
        feedback.analyseFeedback(true, sent1, sent2, sent3, sent4, sent5);
        System.out.println(feedback);
        long l1 = System.currentTimeMillis();
        System.out.println("--------------");
        System.out.println("Time taken to analyse feedback is: " + (l1 - l)+"ms"+"\n---------------------");
        long l2 = System.currentTimeMillis();
        feedback.analyseFeedback(false, sent1, sent2, sent3, sent4, sent5);
        System.out.println(feedback);
        long l3 = System.currentTimeMillis();
        System.out.println("--------------");
        System.out.println("Time taken to analyse feedback is: " + (l3 - l2)+"ms"+"\n---------------------");
    }
}
