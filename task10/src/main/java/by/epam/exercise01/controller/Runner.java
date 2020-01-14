package by.epam.exercise01.controller;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        Controller controller = new Controller();

        Directory directory = controller.createDirectory(viewer.printCreatingDirectory());
        if(directory != null) {
            while (true) {
                String request = viewer.printCommandMenu();
                if (request.equals("0")) {
                    return;
                } else {
                    viewer.printRequest(controller.executeTask(request, directory));
                }
                viewer.printNewAttempt();
            }
        }
    }
}
