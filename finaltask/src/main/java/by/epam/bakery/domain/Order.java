package by.epam.bakery.domain;

import java.text.DateFormat;

public class Order extends Entity{
    private Client client;
    private Pie pie;
    private DateFormat productionDate;
    private DateFormat deliveryDate;
    private Status status;

    public Order() {
    }

    public Order(int id, Client client, Pie pie, DateFormat productionDate, DateFormat deliveryDate, Status status) {
        super(id);
        this.client = client;
        this.pie = pie;
        this.productionDate = productionDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }


    public DateFormat getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(DateFormat productionDate) {
        this.productionDate = productionDate;
    }

    public DateFormat getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(DateFormat deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", pie=" + pie +
                ", productionDate=" + productionDate +
                ", deliveryDate=" + deliveryDate +
                ", status=" + status +
                '}';
    }
}
