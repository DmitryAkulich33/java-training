package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class ChangeOrderStatusCommand implements Command {
    private static final String CHANGE_STATUS = "changeStatus";
    private static final String ID_ORDER = "changeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newStatus = request.getParameter(CHANGE_STATUS);
        int orderId = Integer.parseInt(request.getParameter(ID_ORDER));
        if(!newStatus.isEmpty()){
            try {
                serviceFactory.getOrderService().changeStatus(newStatus, orderId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=courier_order");
    }
}
