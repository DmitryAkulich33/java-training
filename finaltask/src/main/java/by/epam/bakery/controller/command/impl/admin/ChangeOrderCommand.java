package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class ChangeOrderCommand implements Command {
    private static final String CHANGE_PRODUCTION_DATE = "productionDate";
    private static final String CHANGE_DELIVERY_DATE = "deliveryDate";
    private static final String CHANGE_STATUS = "changeStatus";
    private static final String ID_ORDER = "changeId";
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_MESSAGE = "The entered data is not correct!";
    private static final String RIGHT_MESSAGE = "The order was changed successfully!";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newProductionDate = request.getParameter(CHANGE_PRODUCTION_DATE);
        String newDeliveryDate = request.getParameter(CHANGE_DELIVERY_DATE);
        String newStatus = request.getParameter(CHANGE_STATUS);
        int orderId = Integer.parseInt(request.getParameter(ID_ORDER));
        try{
            if(newProductionDate.isEmpty() & newDeliveryDate.isEmpty() & newStatus.isEmpty()){
                session.setAttribute(WRONG, WRONG_MESSAGE);
            } else {
                if(!newProductionDate.isEmpty()){
                    serviceFactory.getOrderService().changeProductionDate(newProductionDate, orderId );
                }
                if(!newDeliveryDate.isEmpty()){
                    serviceFactory.getOrderService().changeDeliveryDate(newDeliveryDate, orderId );
                }
                if(!newStatus.isEmpty()){
                    serviceFactory.getOrderService().changeStatus(newStatus, orderId);
                }
                session.setAttribute(RIGHT, RIGHT_MESSAGE);
            }
        } catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_MESSAGE);
        } catch (ServiceException e){
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_order_product&page=1");
    }
//    @Override
//    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
//        ServiceFactory serviceFactory = ServiceFactory.getInstance();
//        String newProductionDate = request.getParameter(CHANGE_PRODUCTION_DATE);
//        String newDeliveryDate = request.getParameter(CHANGE_DELIVERY_DATE);
//        String newStatus = request.getParameter(CHANGE_STATUS);
//        int orderId = Integer.parseInt(request.getParameter(ID_ORDER));
//        if(!newProductionDate.isEmpty()){
//            try {
//                LocalDateTime localDateTime = LocalDateTime.parse(newProductionDate);
//                serviceFactory.getOrderService().changeProductionDate(localDateTime, orderId );
//            } catch (ServiceException e) {
//                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
//            }
//        }
//        if(!newDeliveryDate.isEmpty()){
//            try {
//                LocalDateTime localDateTime = LocalDateTime.parse(newDeliveryDate);
//                serviceFactory.getOrderService().changeDeliveryDate(localDateTime, orderId );
//            } catch (ServiceException e) {
//                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
//            }
//        }
//        if(!newStatus.isEmpty()){
//            try {
//                serviceFactory.getOrderService().changeStatus(newStatus, orderId);
//            } catch (ServiceException e) {
//                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
//            } catch (ValidatorException e) {
//                e.printStackTrace();
//            }
//        }
//        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_order_product&page=1");
//    }
}
