package by.epam.xml.xmlorders;

public enum  OrderEnum {
    ORDERS("orders"),
    ID("id"),
    STATUS("status"),
    ORDER("order"),
    CLIENT("client"),
    SURNAME("surname"),
    NAME("name"),
    PATRONYMIC("patronymic"),
    ADDRESS("address"),
    PHONE("phone"),
    NOTE("note"),
    PIE("pie"),
    WEIGHT("weight"),
    PRICE("price"),
    DESCRIPTION("description"),
    PRODUCTIONDATE("productionDate"),
    TITLE("title"),
    DELIVERYDATE("deliveryDate");

    private String value;

    OrderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
