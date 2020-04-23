package by.epam.bakery.service.api;

import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedbackService {
    void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException, ValidatorException;
    void deleteFeedback (int id) throws ServiceException;
    int findFeedbackPageAmount (int pageAmount) throws ServiceException;
    List<Feedback> findLimitFeedback(int start, int amount) throws ServiceException;
}
