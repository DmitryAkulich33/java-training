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

public class AdminUsersIncreasePageCommand implements Command {
    private static final String USERS = "users";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
//    private static final String PAGINATION_COMMAND = "paginationCommand";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int increasePage = currentPage + 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<User> users;
        HttpSession session = request.getSession();
//        String command = (String) session.getAttribute(PAGINATION_COMMAND);
//        if(command.equals("admin_users")) {
            if (increasePage <= count) {
                try {
                    users = serviceFactory.getUserService().findLimitUser((increasePage - 1) * AMOUNT, AMOUNT);
                    request.setAttribute(USERS, users);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                request.setAttribute(PAGE, increasePage);
            } else {
                try {
                    users = serviceFactory.getUserService().findLimitUser((currentPage - 1) * AMOUNT, AMOUNT);
                    request.setAttribute(USERS, users);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                request.setAttribute(PAGE, currentPage);
            }
            request.setAttribute(COUNT, count);
            return CommandResult.forward("/WEB-INF/jsp/admin_users.jsp");
//        }
//        else {
//            return CommandResult.forward("/WEB-INF/jsp/admin_users.jsp");
//        }


    }
}
