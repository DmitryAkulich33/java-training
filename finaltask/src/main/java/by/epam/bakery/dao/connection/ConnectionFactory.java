package by.epam.bakery.dao.connection;

import by.epam.bakery.dao.exception.ConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String CONNECTION_ERROR = "Failed to create a database connection";
    private static final String READ_ERROR ="Could not read the property file to create a database connection";
    private static final String PATH_TO_PROPERTIES = "d:/java-training/finaltask/src/main/resources/database.properties";
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public ConnectionFactory(){
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(PATH_TO_PROPERTIES))) {
            properties.load(input);
        } catch (IOException e) {
            throw new ConnectionException(READ_ERROR, e);
        }
        final String url = "url";
        final String username = "username";
        final String password = "password";
        databaseUrl = properties.getProperty(url);
        databaseUsername = properties.getProperty(username);
        databasePassword = properties.getProperty(password);
    }

    public Connection create() {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new ConnectionException(CONNECTION_ERROR, e);
        }
        return connection;
    }

}
