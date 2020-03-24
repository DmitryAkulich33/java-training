package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePieCommand implements Command {
    private static final String CHANGE_NAME = "changeName";
    private static final String CHANGE_PICTURE = "changePicture";
    private static final String CHANGE_WEIGHT = "changeWeight";
    private static final String CHANGE_PRICE = "changePrice";
    private static final String CHANGE_DESCRIPTION = "changeDescription";
    private static final String CHANGE_ID = "changeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String name = request.getParameter(CHANGE_NAME);
        String picture = request.getParameter(CHANGE_PICTURE);
        String description = request.getParameter(CHANGE_DESCRIPTION);
        int weight = Integer.parseInt(request.getParameter(CHANGE_WEIGHT));
        double price = Double.parseDouble(request.getParameter(CHANGE_PRICE));
        int pieId = Integer.parseInt(CHANGE_ID);


        return null;
    }
}
