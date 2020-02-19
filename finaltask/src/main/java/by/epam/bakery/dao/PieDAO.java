package by.epam.bakery.dao;

import by.epam.bakery.domain.Pie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PieDAO {
    public static final String SQL_SELECT_ALL_PIES = "SELECT id, name, weight, price, description FROM pie";

    public List<Pie> findAll(){
        List<Pie> pies = new ArrayList<Pie>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_PIES);
            while (resultSet.next()) {
                Pie pie = new Pie();
                pie.setId(resultSet.getInt("id"));
                pie.setName(resultSet.getString("name"));
                pie.setWeight(resultSet.getInt("weight"));
                pie.setPrice(resultSet.getDouble("price"));
                pie.setDiscription(resultSet.getString("description"));
                pies.add(pie);
            }
        } catch (SQLException ex){
            System.err.println("SQL exception (request or table failed): " + ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pies;
    }
}
