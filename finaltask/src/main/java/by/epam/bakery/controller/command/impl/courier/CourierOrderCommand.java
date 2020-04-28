package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierOrderCommand implements Command {
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;
    private static Logger log = LogManager.getLogger(CourierOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Loading list of order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<OrderProduct> orderProducts;
        int page = Integer.parseInt(request.getParameter(PAGE));
        try {
            orderProducts = serviceFactory.getOrderProductService().findLimitOrderProduct((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(ORDER_PRODUCTS, orderProducts);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            int count = serviceFactory.getOrderService().findOrderPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PAGE, page);
        log.debug("Loading list of order finished.");
        return CommandResult.forward("/WEB-INF/jsp/courier/courier_order.jsp");
    }
}
