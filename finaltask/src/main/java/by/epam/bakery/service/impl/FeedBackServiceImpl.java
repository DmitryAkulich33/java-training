package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedBackDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.service.api.FeedBackService;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;

public class FeedBackServiceImpl implements FeedBackService {
    private DaoHelperFactory daoHelperFactory;

    public FeedBackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedBackDao dao = helper.createFeedBackDao();
            dao.save(userId, feedbackDate, review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
