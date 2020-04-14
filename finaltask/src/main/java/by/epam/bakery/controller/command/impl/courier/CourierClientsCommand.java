package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierClientsCommand implements Command {
    private static final String CLIENTS = "clients";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        List<User> clients;
        try {
            clients = serviceFactory.getUserService().findLimitClients((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(CLIENTS, clients);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            int count = serviceFactory.getUserService().findClientPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/courier_clients.jsp");
    }
}
