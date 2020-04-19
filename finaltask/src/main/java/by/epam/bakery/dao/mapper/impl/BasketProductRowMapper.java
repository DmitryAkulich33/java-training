package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketProductRowMapper implements RowMapper<BasketProduct> {
    @Override
    public BasketProduct map(ResultSet resultSet) throws SQLException {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setId(resultSet.getInt("id_basket_product"));
        Pie pie = new Pie();
        pie.setId(resultSet.getInt("id_pie"));
        pie.setName(resultSet.getString("name_pie"));
        pie.setWeight(resultSet.getInt("weight"));
        pie.setPrice(resultSet.getDouble("price"));
        pie.setDescription(resultSet.getString("description"));
        pie.setPicture(resultSet.getString("picture"));
        basketProduct.setPie(pie);
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
        basketProduct.setBasket(basket);
        basketProduct.setAmount(resultSet.getInt("basket_amount"));
        basketProduct.setCost(resultSet.getDouble("basket_cost"));

        return basketProduct;
    }
}
