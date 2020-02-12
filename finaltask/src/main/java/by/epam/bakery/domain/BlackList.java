package by.epam.bakery.domain;

public class BlackList extends Entity {
    private int clientId;

    public BlackList() {
    }

    public BlackList(int id, int clientId) {
        super(id);
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return super.toString() + " clientId: " + clientId;
    }
}
