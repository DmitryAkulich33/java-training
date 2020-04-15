package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class ChangeOrderCommand implements Command {
    private static final String CHANGE_PRODUCTION_DATE = "productionDate";
    private static final String CHANGE_DELIVERY_DATE = "deliveryDate";
    private static final String CHANGE_STATUS = "changeStatus";
    private static final String ID_ORDER = "changeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newProductionDate = request.getParameter(CHANGE_PRODUCTION_DATE);
        String newDeliveryDate = request.getParameter(CHANGE_DELIVERY_DATE);
        String newStatus = request.getParameter(CHANGE_STATUS);
        int orderId = Integer.parseInt(request.getParameter(ID_ORDER));
        if(!newProductionDate.isEmpty()){
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(newProductionDate);
                serviceFactory.getOrderService().changeProductionDate(localDateTime, orderId );
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        if(!newDeliveryDate.isEmpty()){
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(newDeliveryDate);
                serviceFactory.getOrderService().changeDeliveryDate(localDateTime, orderId );
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        if(!newStatus.isEmpty()){
            try {
                serviceFactory.getOrderService().changeStatus(newStatus, orderId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_order_product&page=1");
    }
}
