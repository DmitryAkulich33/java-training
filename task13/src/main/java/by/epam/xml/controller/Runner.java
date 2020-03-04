package by.epam.xml.controller;

public class Runner {
    public static void main(String[] args) {
        String filename = "src/main/resources/xml/orders.xml";
        Controller controller = new Controller();
        controller.execute(filename);
    }
}
