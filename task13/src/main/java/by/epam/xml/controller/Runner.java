package by.epam.xml.controller;

import by.epam.xml.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        String filename = "src/main/resources/xml/orders.xml";
        Controller controller = new Controller();
        Viewer viewer = new Viewer();
        while (true) {
            String request = viewer.printCommandMenu();
            if (request.equals("0")) {
                return;
            } else {
                viewer.printOrders(controller.execute(request, filename));
            }
            viewer.printNewAttempt();
        }
    }
}
