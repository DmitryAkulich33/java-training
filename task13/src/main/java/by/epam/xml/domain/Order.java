package by.epam.xml.domain;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private StatusEnum statusEnum;
    private Client client = new Client();
    private Pie pie = new Pie();
    private LocalDateTime productionDate;
    private LocalDateTime deliveryDate;

    public Order() {
    }

    public Order(int id, StatusEnum statusEnum, Client client, Pie pie, LocalDateTime productionDate, LocalDateTime deliveryDate) {
        this.id = id;
        this.statusEnum = statusEnum;
        this.client = client;
        this.pie = pie;
        this.productionDate = productionDate;
        this.deliveryDate = deliveryDate;
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
                ", deliveryDate: " + deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (statusEnum != order.statusEnum) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        if (pie != null ? !pie.equals(order.pie) : order.pie != null) return false;
        if (productionDate != null ? !productionDate.equals(order.productionDate) : order.productionDate != null)
            return false;
        return deliveryDate != null ? deliveryDate.equals(order.deliveryDate) : order.deliveryDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusEnum != null ? statusEnum.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        result = 31 * result + (productionDate != null ? productionDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        return result;
    }
}
