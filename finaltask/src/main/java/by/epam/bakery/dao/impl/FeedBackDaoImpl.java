package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.FeedBackDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.FeedBack;

import java.sql.Connection;
import java.util.List;

public class FeedBackDaoImpl extends AbstractDao<FeedBack> implements FeedBackDao {
    private static final String FEEDBACK_TABLE = "feedback";
    private static final String ID_FEEDBACK = "id_feedback";
    private static final String FIND_ALL_FEEDBACK = "SELECT * FROM user INNER JOIN feedback ON user.id_user=feedback.user_id";
    private static final String SAVE_FEEDBACK = "INSERT INTO feedback (user_id, feedback_date, review)" +
            " VALUES(?, ?, ?)";

    public FeedBackDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<FeedBack> findAll() throws DaoException {
        String table = getTableName();
        RowMapper<FeedBack> mapper = (RowMapper<FeedBack>) RowMapper.create(table);
        return executeQuery(FIND_ALL_FEEDBACK, mapper);
    }

    @Override
    public void changeReview(String newReview, int feedbackId) throws DaoException {

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
}
