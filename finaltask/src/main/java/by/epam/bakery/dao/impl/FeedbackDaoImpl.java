package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.FeedbackDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.dao.mapper.impl.FeedBackRowMapper;
import by.epam.bakery.domain.Feedback;

import java.sql.Connection;
import java.util.List;

public class FeedbackDaoImpl extends AbstractDao<Feedback> implements FeedbackDao {
    private static final String FEEDBACK_TABLE = "feedback";
    private static final String ID_FEEDBACK = "id_feedback";
    private static final String FIND_LIMIT_FEEDBACK = "SELECT * FROM user INNER JOIN feedback ON user.id_user=feedback.user_id ORDER BY id_feedback DESC LIMIT ? , ?";
    private static final String SAVE_FEEDBACK = "INSERT INTO feedback (user_id, feedback_date, review)" +
            " VALUES(?, ?, ?)";
    private static final String FIND_FEEDBACK_BY_USER_ID ="SELECT * FROM user INNER JOIN feedback ON user.id_user=feedback.user_id WHERE id_user = ? ";
    private static final String FIND_LAST_FEEDBACK = "SELECT * FROM user INNER JOIN feedback ON user.id_user=feedback.user_id ORDER BY id_feedback DESC LIMIT ?";

    public FeedbackDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Feedback> findLimitFeedback(int start, int amount) throws DaoException {
        String table = getTableName();
        RowMapper<Feedback> mapper = (RowMapper<Feedback>) RowMapper.create(table);
        return executeQuery(FIND_LIMIT_FEEDBACK, mapper, start, amount);
    }


    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_FEEDBACK, parameters);
    }

    @Override
    protected String getTableName() {
        return FEEDBACK_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_FEEDBACK;
    }

    @Override
    public List<Feedback> getFeedbackByUserId(int userId) throws DaoException {
        return executeQuery(FIND_FEEDBACK_BY_USER_ID, new FeedBackRowMapper(), userId);
    }

    @Override
    public List<Feedback> getNecessaryFeedbackAmount(int amount) throws DaoException {
        return executeQuery(FIND_LAST_FEEDBACK, new FeedBackRowMapper(), amount);
    }
}
