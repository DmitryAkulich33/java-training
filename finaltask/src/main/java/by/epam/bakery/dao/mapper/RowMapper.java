package by.epam.bakery.dao.mapper;

import by.epam.bakery.dao.exception.UnknownTableException;
import by.epam.bakery.dao.mapper.impl.*;
import by.epam.bakery.domain.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Entity> {
    String UNKNOWN_TABLE = "Unknown table = ";

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Entity> create (String table) throws UnknownTableException {
        switch (table){
            case "user": return new UserRowMapper();
            case "pie": return new PieRowMapper();
            case "order": return new OrderRowMapper();
            case "black_list": return new BlackListRowMapper();
            case "feedback": return new FeedBackRowMapper();

            default: throw new UnknownTableException(UNKNOWN_TABLE + table);

        }
    }


}
