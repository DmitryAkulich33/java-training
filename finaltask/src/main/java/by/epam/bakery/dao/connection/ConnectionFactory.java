package by.epam.bakery.dao.connection;

import by.epam.bakery.dao.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Logger log = LogManager.getLogger(ConnectionFactory.class.getName());
    private static final String CONNECTION_ERROR = "Failed to create a database connection";
    private static final String READ_ERROR ="Could not read the property file to create a database connection";
//    private static final String PATH_TO_PROPERTIES = "d:/java-training/finaltask/src/main/resources/database.properties";
    private static final String PATH_TO_PROPERTIES = "/database.properties";
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public ConnectionFactory(){
        Properties properties = new Properties();
//        try (InputStream input = Files.newInputStream(Paths.get(PATH_TO_PROPERTIES))) {
//            properties.load(input);
//        } catch (IOException e) {
//            log.error("Could not read the property file!");
//            throw new ConnectionException(READ_ERROR, e);
//        }
        try (InputStream input = ConnectionPool.class.getResourceAsStream(PATH_TO_PROPERTIES)) {
            properties.load(input);
        } catch (IOException e) {
            log.error("Could not read the property file!");
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
        log.debug("Creating connection started.");
        try {
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
        } catch (SQLException e) {
            log.error("Failed to create a database connection!");
            throw new ConnectionException(CONNECTION_ERROR, e);
        }
        log.debug("Creating connection finished");
        return connection;
    }
}
