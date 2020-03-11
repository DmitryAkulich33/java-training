package by.epam.bakery.dao;

import by.epam.bakery.dao.connection.ConnectionPool;

public class DaoHelperFactory {

    public DaoHelper create(){
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
