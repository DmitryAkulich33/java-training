package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderProductRowMapper implements RowMapper<OrderProduct> {
    @Override
    public OrderProduct map(ResultSet resultSet) throws SQLException {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(resultSet.getInt("id_order_product"));
        Order order = new Order();
        order.setId(resultSet.getInt("id_order"));
        order.setTotal(resultSet.getDouble("total"));
        String productionDate = resultSet.getString("productionDate");
        if (productionDate == null) {
            order.setProductionDate(null);
        } else {
            order.setProductionDate(LocalDateTime.parse(productionDate.replace(" ", "T")));
        }
        String deliveryDate = resultSet.getString("deliveryDate");
        if (deliveryDate == null) {
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
        orderProduct.setOrder(order);
        Pie pie = new Pie();
        pie.setId(resultSet.getInt("id_pie"));
        pie.setName(resultSet.getString("name_pie"));
        pie.setWeight(resultSet.getInt("weight"));
        pie.setPrice(resultSet.getDouble("price"));
        pie.setDescription(resultSet.getString("description"));
        pie.setPicture(resultSet.getString("picture"));
        orderProduct.setPie(pie);
        orderProduct.setAmount(resultSet.getInt("order_amount"));
        orderProduct.setCost(resultSet.getDouble("order_cost"));

        return orderProduct;
    }
}
