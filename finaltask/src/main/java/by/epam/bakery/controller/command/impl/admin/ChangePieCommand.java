package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePieCommand implements Command {
    private static final String CHANGE_NAME = "changeName";
    private static final String CHANGE_PICTURE = "changePicture";
    private static final String CHANGE_WEIGHT = "changeWeight";
    private static final String CHANGE_PRICE = "changePrice";
    private static final String CHANGE_DESCRIPTION = "changeDescription";
    private static final String CHANGE_ID = "changeId";
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_MESSAGE = "wrongMessage";
    private static final String RIGHT_MESSAGE = "rightPie";
    private static Logger log = LogManager.getLogger(ChangePieCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Changing pie started.");
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String name = request.getParameter(CHANGE_NAME);
        String picture = request.getParameter(CHANGE_PICTURE);
        String description = request.getParameter(CHANGE_DESCRIPTION);
        String weight = request.getParameter(CHANGE_WEIGHT);
        String price = request.getParameter(CHANGE_PRICE);
        int pieId = Integer.parseInt(request.getParameter(CHANGE_ID));
        try {
            if (name.isEmpty() & picture.isEmpty() & description.isEmpty() & weight.isEmpty() & price.isEmpty()) {
                session.setAttribute(WRONG, WRONG_MESSAGE);
            } else {
                if (!name.isEmpty()) {
                    serviceFactory.getPieService().changeName(name, pieId);
                }
                if (!picture.isEmpty()) {
                    serviceFactory.getPieService().changePicture(picture, pieId);
                }
                if (!description.isEmpty()) {
                    serviceFactory.getPieService().changeDescription(description, pieId);
                }
                if (!weight.isEmpty()) {
                    serviceFactory.getPieService().changeWeight(weight, pieId);
                }
                if (!price.isEmpty()) {
                    serviceFactory.getPieService().changePrice(price, pieId);
                }
                session.setAttribute(RIGHT, RIGHT_MESSAGE);
            }
        } catch (ValidatorException ex) {
            log.error(this.getClass() + ":" + ex.getMessage());
            session.setAttribute(WRONG, WRONG_MESSAGE);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Changing pie finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
    }
}
