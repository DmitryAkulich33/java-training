package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierFindClientBySurnameCommand implements Command {
    private static final String USER_SURNAME = "userSurname";
    private static final String CLIENTS = "clients";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String surname = request.getParameter(USER_SURNAME);
        List<User> clients = null;
        try {
            clients = serviceFactory.getUserService().findClientBySurname(surname);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(CLIENTS, clients);
        return CommandResult.forward("/WEB-INF/jsp/courier_clients.jsp");
    }
}
