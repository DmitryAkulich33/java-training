package by.epam.bakery.controller.command;

import by.epam.bakery.controller.command.impl.ShowMainPageCommand;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.service.PieService;

public class CommandFactory {
    private static final String UNKNOWN_COMMAND = "Unknown command";

    public Command findCommand(String command) {
        System.out.println(command);
        switch (command) {
            case CommandName.SHOW_MAIN_PAGE:
                return new ShowMainPageCommand(new PieService(new DaoHelperFactory()));
            default:
                throw new SecurityException("eeee");
        }
    }
}
