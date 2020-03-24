package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SavePieCommand implements Command {
    private static final String SAVE_NAME = "saveName";
    private static final String SAVE_PICTURE = "savePicture";
    private static final String SAVE_WEIGHT = "saveWeight";
    private static final String SAVE_PRICE = "savePrice";
    private static final String SAVE_DESCRIPTION = "saveDescription";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String name = request.getParameter(SAVE_NAME);
        String picture = request.getParameter(SAVE_PICTURE);
        String description = request.getParameter(SAVE_DESCRIPTION);
        int weight = Integer.parseInt(request.getParameter(SAVE_WEIGHT));
        double price = Double.parseDouble(request.getParameter(SAVE_PRICE));
        try {
            serviceFactory.getPieService().addPie(name, weight, price, description, picture);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
    }
}
