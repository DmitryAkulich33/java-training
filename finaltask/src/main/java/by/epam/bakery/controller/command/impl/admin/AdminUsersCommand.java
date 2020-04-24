package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminUsersCommand implements Command {
    private static final String USERS = "users";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        List<User> users;
        try {
            users = serviceFactory.getUserService().findLimitUser((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(USERS, users);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            int count = serviceFactory.getUserService().findUserPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_users.jsp");
    }
}
