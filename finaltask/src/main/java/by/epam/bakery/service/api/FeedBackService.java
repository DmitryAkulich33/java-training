package by.epam.bakery.service.api;

import by.epam.bakery.domain.FeedBack;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedBackService {
    void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException;
    List<FeedBack> showAllFeedBacks() throws ServiceException;
}
