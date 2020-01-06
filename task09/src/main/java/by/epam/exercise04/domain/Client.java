package by.epam.exercise04.domain;

import java.util.List;

public class Client {
    private String name;
    private List<Bill> bills;

    public Client(String name, List<Bill> bills) {
        this.name = name;
        this.bills = bills;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        String line = "\n" + name + " :\n";
        for (Bill bill : bills) {
            line = line + bill;
        }
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        return bills != null ? bills.equals(client.bills) : client.bills == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (bills != null ? bills.hashCode() : 0);
        return result;
    }
}
