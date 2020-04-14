package by.epam.bakery.service.api;

import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedbackService {
    void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException;
    List<Feedback> showAllFeedBacks() throws ServiceException;
    List<Feedback> findFeedbackByUserId(int userId) throws ServiceException;
    void deleteFeedback (int id) throws ServiceException;
    List<Feedback> findNecessaryFeedbackAmount(int amount) throws ServiceException;
    int findFeedbackPageAmount (int pageAmount) throws ServiceException;
    List<Feedback> findLimitFeedback(int start, int amount) throws ServiceException;
}
