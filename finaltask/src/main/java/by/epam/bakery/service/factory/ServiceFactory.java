package by.epam.bakery.service.factory;

import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.service.api.FeedBackService;
import by.epam.bakery.service.api.PieService;
import by.epam.bakery.service.api.UserService;
import by.epam.bakery.service.impl.FeedBackServiceImpl;
import by.epam.bakery.service.impl.PieServiceImpl;
import by.epam.bakery.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final PieService pieService = new PieServiceImpl(new DaoHelperFactory());
    private final UserService userService = new UserServiceImpl(new DaoHelperFactory());
    private final FeedBackService feedBackService = new FeedBackServiceImpl(new DaoHelperFactory());

    private ServiceFactory() {
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

    public FeedBackService getFeedBackService() {
        return feedBackService;
    }
}
