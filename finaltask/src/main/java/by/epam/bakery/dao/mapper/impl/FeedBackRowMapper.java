package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.FeedBack;
import by.epam.bakery.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FeedBackRowMapper implements RowMapper<FeedBack> {
    @Override
    public FeedBack map(ResultSet resultSet) throws SQLException {
        FeedBack feedBack = new FeedBack();
        feedBack.setId(resultSet.getInt("id_feedback"));
        feedBack.setLocalDateTime(LocalDateTime.parse(resultSet.getString("feedback_date").replace(" ", "T")));
        feedBack.setReview(resultSet.getString("review"));
        User user = new User();
        user.setId(resultSet.getInt("id_user"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getInt("role"));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("name_user"));
        user.setPatronymic(resultSet.getString("patronymic"));
        user.setAddress(resultSet.getString("address"));
        user.setPhone(resultSet.getString("phone"));
        user.setNote(resultSet.getString("note"));
        feedBack.setUser(user);

        return feedBack;
    }
}
