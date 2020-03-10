package by.epam.bakery.dao.mapper.impl;

import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.Pie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PieRowMapper implements RowMapper<Pie> {
    @Override
    public Pie map(ResultSet resultSet) throws SQLException {
        Pie pie = new Pie();
        pie.setId(resultSet.getInt("id_pie"));
        pie.setName(resultSet.getString("name_pie"));
        pie.setWeight(resultSet.getInt("weight"));
        pie.setPrice(resultSet.getDouble("price"));
        pie.setDescription(resultSet.getString("description"));
        pie.setPicture(resultSet.getString("picture"));

        return pie;
    }
}
