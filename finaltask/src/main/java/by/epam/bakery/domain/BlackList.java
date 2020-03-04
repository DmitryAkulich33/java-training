package by.epam.bakery.domain;

public class BlackList extends Entity {
    private Client client;

    public BlackList() {
    }

    public BlackList(int id, Client client) {
        super(id);
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "client=" + client +
                '}';
    }
}
