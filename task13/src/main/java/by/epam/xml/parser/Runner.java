package by.epam.xml.parser;

public class Runner {
    public static void main(String[] args) {
        OrderSAXBuilder saxBuilder = new OrderSAXBuilder();
        saxBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(saxBuilder.getOrders());
    }
}
