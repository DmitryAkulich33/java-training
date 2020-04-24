package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAddNewUserForOrder implements Command {
    private static final String USER_FOR_ORDER_ID = "userForOrderId";
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String WRONG = "wrong";
    private static final String WRONG_MESSAGE = "The entered data is not correct!";
    private static final String WRONG_ID = "The entered id not found in database";
    private static final String NO_RECORDS = "No records";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        String userId = request.getParameter(USER_FOR_ORDER_ID);
        User user;
        try {
            user = serviceFactory.getUserService().findClientById(userId);
            session.setAttribute(USER_FOR_ORDER, user);
        } catch (ValidatorException ex){
            request.setAttribute(WRONG, WRONG_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/admin/admin_account.jsp");
        } catch (ServiceException e) {
            if(e.getCause().getMessage().equals(NO_RECORDS)){
                request.setAttribute(WRONG, WRONG_ID);
                return CommandResult.forward("/WEB-INF/jsp/admin/admin_account.jsp");
            } else {
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
