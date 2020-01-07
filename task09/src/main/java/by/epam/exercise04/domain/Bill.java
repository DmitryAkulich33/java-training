package by.epam.exercise04.domain;

public class Bill {
    private String number;
    private int balance;
    private String nameAccess;
    private boolean access;

    public Bill(String number, int balance, String nameAccess) {
        this.number = number;
        this.balance = balance;
        this.nameAccess = nameAccess;
        access = this.nameAccess.equals("open");
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
        if (this.balance > 0) {
            access = true;
            nameAccess = "open";
        } else {
            access = false;
            nameAccess = "locked";
        }
    }

    public String getNameAccess() {
        return nameAccess;
    }


    public boolean isAccess() {
        return access;
    }

    @Override
    public String toString() {
        return "Bill's number is " + number + ", balance is " + balance + ", access is " + nameAccess + " " + access + "\n";
    }
}
