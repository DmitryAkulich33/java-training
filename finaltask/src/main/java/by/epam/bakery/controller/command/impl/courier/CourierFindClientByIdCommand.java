package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CourierFindClientByIdCommand implements Command {
    private static final String USER_ID = "userId";
    private static final String CLIENTS = "clients";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int userId = Integer.parseInt(request.getParameter(USER_ID));
        List<User> clients = new ArrayList<>();
        User user = null;
        try {
            user = serviceFactory.getUserService().findClientById(userId);
            clients.add(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(CLIENTS, clients);
        return CommandResult.forward("/WEB-INF/jsp/courier_clients.jsp");
    }
}
