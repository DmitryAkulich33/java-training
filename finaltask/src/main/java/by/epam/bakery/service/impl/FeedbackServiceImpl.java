package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedbackDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.api.FeedbackService;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private DaoHelperFactory daoHelperFactory;

    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.save(userId, feedbackDate, review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> showAllFeedBacks() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> findFeedbackByUserId(int userId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.getFeedbackByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteFeedback (int id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> findNecessaryFeedbackAmount(int amount, List<Feedback> allFeedback){
        int size = allFeedback.size();
        if(size >= amount) {
            return new ArrayList<>(allFeedback.subList(0, amount));
        } else {
            return allFeedback;
        }
    }
}
