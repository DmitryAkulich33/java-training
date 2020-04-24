package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SavePieCommand implements Command {
    private static final String SAVE_NAME = "saveName";
    private static final String SAVE_PICTURE = "savePicture";
    private static final String SAVE_WEIGHT = "saveWeight";
    private static final String SAVE_PRICE = "savePrice";
    private static final String SAVE_DESCRIPTION = "saveDescription";
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_MESSAGE = "The entered data is not correct!";
    private static final String RIGHT_MESSAGE = "The pie was added successfully!";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String name = request.getParameter(SAVE_NAME);
        String picture = request.getParameter(SAVE_PICTURE);
        String description = request.getParameter(SAVE_DESCRIPTION);
        String weight = request.getParameter(SAVE_WEIGHT);
        String price = request.getParameter(SAVE_PRICE);
        try {
            serviceFactory.getPieService().addPie(name, weight, price, description, picture);
            session.setAttribute(RIGHT, RIGHT_MESSAGE);
        } catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_MESSAGE);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
    }
}
