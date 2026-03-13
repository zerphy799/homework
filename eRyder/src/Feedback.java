public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewId;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation) {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
            longFeedback = checkFeedbackLength(completeFeedback);
            reviewId = createReviewId(firstName, lastName, completeFeedback);
        } else {
            completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
            longFeedback = checkFeedbackLength(completeFeedback);
            reviewId = createReviewId(firstName, lastName, completeFeedback);
        }
    }

    public boolean checkFeedbackLength(String str) {
        if (str.length() > 500) {
            return true;
        } else {
            return false;
        }
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback = sent1 + sent2 + sent3 + sent4 + sent5;
        return concatenatedFeedback;
    }

    private String feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1);
        sb.append(sent2);
        sb.append(sent3);
        sb.append(sent4);
        sb.append(sent5);
        return sb.toString();
    }

    private String createReviewId(String firstName, String lastName, String completeFeedback) {
        StringBuilder id = new StringBuilder(firstName);
        id.append(lastName);
        String upperCase = id.substring(2, 6).toUpperCase();
        String lowerCase = completeFeedback.substring(10, 15).toLowerCase();
        String str = upperCase + lowerCase + "_" + completeFeedback.length();
        return str.replace(" ", "");
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", longFeedback=" + longFeedback +
                ", completeFeedback='" + completeFeedback + '\'' +
                ", reviewId='" + reviewId + '\'' +
                '}';
    }
}
