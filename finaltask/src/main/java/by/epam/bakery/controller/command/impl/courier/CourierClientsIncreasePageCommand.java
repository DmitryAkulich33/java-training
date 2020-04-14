package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierClientsIncreasePageCommand implements Command {
    private static final String CLIENTS = "clients";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int increasePage = currentPage + 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<User> clients;
        if (increasePage <= count) {
            try {
                clients = serviceFactory.getUserService().findLimitClients((increasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(CLIENTS, clients);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, increasePage);
        } else {
            try {
                clients = serviceFactory.getUserService().findLimitClients((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(CLIENTS, clients);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        return CommandResult.forward("/WEB-INF/jsp/courier_clients.jsp");
    }
}
