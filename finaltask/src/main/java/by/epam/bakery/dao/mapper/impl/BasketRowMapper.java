package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketRowMapper implements RowMapper<Basket> {
    @Override
    public Basket map(ResultSet resultSet) throws SQLException {
        Basket basket = new Basket();
        basket.setId(resultSet.getInt("id_basket"));
        basket.setTotal(resultSet.getDouble("total"));
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
        basket.setUser(user);

        return basket;
    }
}
