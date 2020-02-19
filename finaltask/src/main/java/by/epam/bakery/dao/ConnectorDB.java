package by.epam.bakery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bakery_db";
        String user = "root";
        String pass = "5646130";
        return DriverManager.getConnection(url, user, pass);
    }
}
