package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderProductCommand implements Command {
    private static final String DELETE_ORDER_PRODUCT_ID = "delId";
    private static Logger log = LogManager.getLogger(DeleteOrderProductCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting product from order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int orderProductId = Integer.parseInt(request.getParameter(DELETE_ORDER_PRODUCT_ID));
        try {
             OrderProduct orderProduct = serviceFactory.getOrderProductService().findOrderProductById(orderProductId);
             double piePrice = orderProduct.getPie().getPrice();
             double total = orderProduct.getOrder().getTotal() - piePrice;
             int orderId = orderProduct.getOrder().getId();
             serviceFactory.getOrderService().changeTotal(total, orderId);
             if(total == 0.0){
                 serviceFactory.getOrderService().deleteOrderById(orderId);
             }
             serviceFactory.getOrderProductService().deleteOrderProductById(orderProductId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Deleting product from order finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_order_product&page=1");
    }
}
