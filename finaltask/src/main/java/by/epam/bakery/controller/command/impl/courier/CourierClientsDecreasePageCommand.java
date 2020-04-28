package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierClientsDecreasePageCommand implements Command {
    private static final String CLIENTS = "clients";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;
    private static Logger log = LogManager.getLogger(CourierClientsDecreasePageCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Page number reduction for clients started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int decreasePage = currentPage - 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<User> clients;
        if (decreasePage >= 1) {
            try {
                clients = serviceFactory.getUserService().findLimitClients((decreasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(CLIENTS, clients);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, decreasePage);
        } else {
            try {
                clients = serviceFactory.getUserService().findLimitClients((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(CLIENTS, clients);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        log.debug("Page number reduction for clients finished.");
        return CommandResult.forward("/WEB-INF/jsp/courier/courier_clients.jsp");
    }
}
