package by.epam.bakery.domain;

public class User extends Entity {
    private String login;
    private String password;
    private int role;

    public User() {
    }

    public User(int id, String login, String password, int role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User" + super.toString() +
                ", login: " + login +
                ", password: " + password +
                ", role:" + role;
    }
}
