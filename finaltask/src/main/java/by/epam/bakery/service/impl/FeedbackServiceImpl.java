package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedbackDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.api.FeedbackService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.FeedbackDataValidator;

import java.time.LocalDateTime;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private DaoHelperFactory daoHelperFactory;
    private FeedbackDataValidator feedbackDataValidator = new FeedbackDataValidator();

    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException, ValidatorException {
        if(!feedbackDataValidator.isFeedbackValid(review)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.save(userId, feedbackDate, review);
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

    private int findFeedbackAmount () throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findFeedbackPageAmount (int pageAmount) throws ServiceException{
        int amountAllFeedbacks = findFeedbackAmount();
        return (int) Math.ceil((double) amountAllFeedbacks/pageAmount);
    }

    @Override
    public List<Feedback> findLimitFeedback(int start, int amount) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findLimitFeedback(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
