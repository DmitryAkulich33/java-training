package by.epam.xml.xmlorders;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Order {
    private int id;
    private StatusEnum statusEnum;
    private Client client = new Client();
    private Pie pie = new Pie();
    private LocalDateTime productionDate;
    private LocalDateTime deliveryDate;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
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

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    @Override
    public String toString() {
        return "Order: " +
                "id: " + id +
                ", status: " + statusEnum.getValue() +
                ", client: " + client +
                ", pie: " + pie +
                ", productionDate: " + productionDate +
                ", deliveryDate: " + deliveryDate + "\n";
    }
}
