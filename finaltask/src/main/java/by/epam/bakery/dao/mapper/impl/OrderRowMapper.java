package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id_order"));
        order.setTotal(resultSet.getDouble("total"));
        String productionDate = resultSet.getString("productionDate");
        if(productionDate == null){
            order.setProductionDate(null);
        } else {
            order.setProductionDate(LocalDateTime.parse(productionDate.replace(" ", "T")));
        }
        String deliveryDate = resultSet.getString("deliveryDate");
        if(deliveryDate == null){
            order.setDeliveryDate(null);
        } else {
            order.setDeliveryDate(LocalDateTime.parse(deliveryDate.replace(" ", "T")));
        }
        order.setStatus(StatusEnum.valueOf(resultSet.getString("status").replace(" ", "_").toUpperCase()));
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
        order.setUser(user);
        return order;
    }
}
