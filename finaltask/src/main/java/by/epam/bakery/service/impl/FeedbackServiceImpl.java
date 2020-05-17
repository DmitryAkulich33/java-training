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

/**
 * Implementation of {@link FeedbackService} interface. Provides access to {@link by.epam.bakery.service.api.FeedbackService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link Feedback}
 *
 * @see DaoHelper
 */
public class FeedbackServiceImpl implements FeedbackService {
    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(FeedbackServiceImpl.class.getName());

    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Validator for this service
     */
    private FeedbackDataValidator feedbackDataValidator = new FeedbackDataValidator();

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Save feedback
     *
     * @param userId       user's id
     * @param feedbackDate feedback's date of posting
     * @param review       user's feedback
     * @throws ServiceException   if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException, ValidatorException {
        log.debug("Service: saving feedback started.");
        if (!feedbackDataValidator.isFeedbackValid(review)) {
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

    /**
     * Delete feedback
     *
     * @param id feedback's id
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void deleteFeedback(int id) throws ServiceException {
        log.debug("Service: deleting feedback started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting feedback finished.");
    }

    /**
     * Find number of feedbacks
     *
     * @return number of feedbacks
     * @throws ServiceException if there is an error on DAO layer
     */
    private int findFeedbackAmount() throws ServiceException {
        log.debug("Service: search feedback.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            FeedbackDao dao = helper.createFeedBackDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Find number of pages with feedbacks
     *
     * @param pageAmount number feedbacks on page
     * @return number of pages with feedbacks
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public int findFeedbackPageAmount(int pageAmount) throws ServiceException {
        log.debug("Service: search feedback page amount.");
        int amountAllFeedbacks = findFeedbackAmount();
        return (int) Math.ceil((double) amountAllFeedbacks / pageAmount);
    }

    /**
     * Get list of feedbacks on page
     *
     * @param start  index of first ffedbacks on page
     * @param amount number feedbacks on page
     * @return number of pages with feedbacks
     * @throws ServiceException if there is an error on DAO layer
     */
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
