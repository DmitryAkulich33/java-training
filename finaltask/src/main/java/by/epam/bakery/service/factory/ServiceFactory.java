package by.epam.bakery.service.factory;

import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.service.api.*;
import by.epam.bakery.service.impl.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final PieService pieService = new PieServiceImpl(new DaoHelperFactory());
    private final UserService userService = new UserServiceImpl(new DaoHelperFactory());
    private final FeedbackService feedBackService = new FeedbackServiceImpl(new DaoHelperFactory());
    private final BasketService basketService = new BasketServiceImpl(new DaoHelperFactory());
    private final OrderService orderService = new OrderServiceImpl(new DaoHelperFactory());

    private ServiceFactory() {
    }

    public BasketService getBasketService() {
        return basketService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public PieService getPieService() {
        return pieService;
    }

    public UserService getUserService() {
        return userService;
    }

    public FeedbackService getFeedBackService() {
        return feedBackService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
