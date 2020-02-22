package by.epam.bakery.dao;

import by.epam.bakery.domain.Pie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PieDAOImpl {
    public static final String SQL_SELECT_ALL_PIES = "SELECT id, name, weight, price, description FROM pie";
    public static final String SQL_DELETE_PIE = "DELETE FROM pie WHERE id = '%d'";
    public static final String SQL_FIND_PIE_BY_WEIGHT = "SELECT * FROM pie WHERE weight = '%d'";

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

    public void deletePie(int id){
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            st.executeUpdate(String.format(SQL_DELETE_PIE, id));
        } catch (SQLException ex){
            System.err.println("SQL exception (request or table failed): " + ex);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Pie> findPieByWeight(int weight){
        List<Pie> pies = new ArrayList<Pie>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(String.format(SQL_FIND_PIE_BY_WEIGHT, weight));
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
