package by.epam.exercise04.controller;

import by.epam.exercise04.domain.Constants;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Viewer viewer = new Viewer();
        DragonCave dragonCave = controller.createDragonCave(Constants.TREASURE_LIST_PATH);

        if (dragonCave != null) {
            while (true) {
                String request = viewer.printCommandMenu();
                if (request.equals("0")) {
                    return;
                } else {
                    viewer.printRequest(controller.executeTask(request, dragonCave));
                }
                viewer.printNewAttempt();
            }
        }
    }
}
