package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Feedback;

import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {
    List<Feedback> findLimitFeedback(int start, int amount) throws DaoException;
    List<Feedback> getFeedbackByUserId(int userId) throws DaoException;
    List<Feedback> getNecessaryFeedbackAmount(int amount) throws DaoException;
}
