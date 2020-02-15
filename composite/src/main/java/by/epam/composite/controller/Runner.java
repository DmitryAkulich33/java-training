package by.epam.composite.controller;


import by.epam.composite.domain.Component;
import by.epam.composite.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Viewer viewer = new Viewer();
        Component component = controller.splitTextFromFile("src\\main\\resources\\composite\\wholeText.txt");
        if (component != null) {
            while (true) {
                String request = viewer.printCommandMenu();
                if (request.equals("0")) {
                    return;
                } else {
                    viewer.printResponse(controller.executeTask(request, component));
                }
                viewer.printNewAttempt();
            }
        }
    }
}
