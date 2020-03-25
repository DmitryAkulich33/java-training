package by.epam.bakery.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Feedback extends Entity implements Serializable {
    private User user;
    private LocalDateTime localDateTime;
    private String review;

    public Feedback() {
    }

    public Feedback(int id, User user, LocalDateTime localDateTime, String review) {
        super(id);
        this.user = user;
        this.localDateTime = localDateTime;
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        if (!super.equals(o)) return false;

        Feedback feedBack = (Feedback) o;

        if (user != null ? !user.equals(feedBack.user) : feedBack.user != null) return false;
        if (localDateTime != null ? !localDateTime.equals(feedBack.localDateTime) : feedBack.localDateTime != null)
            return false;
        return review != null ? review.equals(feedBack.review) : feedBack.review == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "FeedBack user: " + user +
                ", localDateTime: " + localDateTime +
                ", note: " + review;
    }
}
