package by.epam.bakery.domain;

import java.io.Serializable;

public class BlackList extends Entity implements Serializable {
    private User user;

    public BlackList() {
    }

    public BlackList(int id, User user) {
        super(id);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlackList)) return false;
        if (!super.equals(o)) return false;

        BlackList blackList = (BlackList) o;

        return user != null ? user.equals(blackList.user) : blackList.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BlackList user: " + user;
    }
}
