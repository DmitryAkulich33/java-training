package by.epam.bakery.dao;

import by.epam.bakery.domain.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl {
    public static final String SQL_SELECT_ALL_CLIENTS = "SELECT id, surname, name, patronymic, address, phone, note FROM client";
    public static final String SQL_DELETE_CLIENT = "DELETE FROM client WHERE id = '%d'";
    public static final String SQL_CHANGE_NOTE = "UPDATE client SET note = '%s' WHERE id = '%d'";

    public List<Client> findAll(){
        List<Client> clients = new ArrayList<Client>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_CLIENTS);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setName(resultSet.getString("name"));
                client.setPatronymic(resultSet.getString("patronymic"));
                client.setAddress(resultSet.getString("address"));
                client.setPhone(resultSet.getString("phone"));
                client.setNote(resultSet.getString("note"));
                clients.add(client);
            }
        } catch (SQLException ex){
            System.err.println("SQL exception (request or table failed): " + ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // TODO log
            }
        }
        return clients;
    }

    public void deleteClient(int id){
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            st.executeUpdate(String.format(SQL_DELETE_CLIENT, id));
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


    public void changeNote(int id, String name){
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            st.executeUpdate(String.format(SQL_CHANGE_NOTE, name, id));
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
}
