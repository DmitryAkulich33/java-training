package by.epam.exercise04.domain;

public class Bill {
    String number;
    int balance;
    boolean acces;

    public Bill(String number, int balance, boolean acces) {
        this.number = number;
        this.balance = balance;
        this.acces = acces;
    }

    public Bill() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isAcces() {
        return acces;
    }

    public void setAcces(boolean acces) {
        this.acces = acces;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", acces=" + acces +
                '}';
    }
}
