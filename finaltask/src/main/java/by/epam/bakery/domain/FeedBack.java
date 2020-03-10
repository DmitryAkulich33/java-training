package by.epam.bakery.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FeedBack extends Entity implements Serializable {
    private User user;
    private LocalDateTime localDateTime;
    private String note;

    public FeedBack() {
    }

    public FeedBack(int id, User user, LocalDateTime localDateTime, String note) {
        super(id);
        this.user = user;
        this.localDateTime = localDateTime;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedBack)) return false;
        if (!super.equals(o)) return false;

        FeedBack feedBack = (FeedBack) o;

        if (user != null ? !user.equals(feedBack.user) : feedBack.user != null) return false;
        if (localDateTime != null ? !localDateTime.equals(feedBack.localDateTime) : feedBack.localDateTime != null)
            return false;
        return note != null ? note.equals(feedBack.note) : feedBack.note == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeedBack user: " + user +
                ", localDateTime: " + localDateTime +
                ", note: " + note;
    }
}
