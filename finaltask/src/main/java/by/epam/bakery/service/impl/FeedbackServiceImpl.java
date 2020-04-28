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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static Logger log = LogManager.getLogger(FeedbackServiceImpl.class.getName());
    private DaoHelperFactory daoHelperFactory;
    private FeedbackDataValidator feedbackDataValidator = new FeedbackDataValidator();

    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException, ValidatorException {
        log.debug("Service: saving feedback started.");
        if(!feedbackDataValidator.isFeedbackValid(review)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.save(userId, feedbackDate, review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving feedback finished.");
    }

    @Override
    public void deleteFeedback (int id) throws ServiceException {
        log.debug("Service: deleting feedback started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting feedback finished.");
    }

    private int findFeedbackAmount () throws ServiceException{
        log.debug("Service: search feedback.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findFeedbackPageAmount (int pageAmount) throws ServiceException{
        log.debug("Service: search feedback page amount.");
        int amountAllFeedbacks = findFeedbackAmount();
        return (int) Math.ceil((double) amountAllFeedbacks/pageAmount);
    }

    @Override
    public List<Feedback> findLimitFeedback(int start, int amount) throws ServiceException {
        log.debug("Service: search limit feedback on page.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findLimitFeedback(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
