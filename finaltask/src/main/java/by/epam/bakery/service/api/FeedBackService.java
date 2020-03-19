package by.epam.bakery.service.api;

import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;

public interface FeedBackService {
    void save(int userId, LocalDateTime feedbackDate, String review) throws ServiceException;

}
