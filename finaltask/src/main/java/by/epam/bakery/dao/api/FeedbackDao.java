package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Feedback;

import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {
    void changeReview (String newReview, int feedbackId) throws DaoException;
    List<Feedback> findAll() throws DaoException;
    List<Feedback> getFeedbackByUserId(int userId) throws DaoException;
}
