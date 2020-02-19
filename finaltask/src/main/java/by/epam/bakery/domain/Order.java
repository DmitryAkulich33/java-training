package by.epam.bakery.domain;

import java.text.DateFormat;

public class Order extends Entity{
    private int clientId;
    private int pieId;
    private DateFormat productionDate;
    private DateFormat deliveryDate;
    private int statusId;

    public Order() {
    }

    public Order(int id, int clientId, int pieId, DateFormat productionDate, DateFormat deliveryDate, int statusId) {
        super(id);
        this.clientId = clientId;
        this.pieId = pieId;
        this.productionDate = productionDate;
        this.deliveryDate = deliveryDate;
        this.statusId = statusId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPieId() {
        return pieId;
    }

    public void setPieId(int pieId) {
        this.pieId = pieId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Order" + super.toString() +
                ", clientId: " + clientId +
                ", pieId: " + pieId +
                ", productionDate: " + productionDate +
                ", deliveryDate: " + deliveryDate +
                ", statusId: " + statusId;
    }
}
