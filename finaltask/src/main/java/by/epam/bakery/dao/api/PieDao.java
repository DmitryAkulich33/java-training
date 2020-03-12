package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;

import java.util.List;
import java.util.Optional;

public interface PieDao extends Dao<Pie> {
    List<Pie> sortByIncreasePrice(List<Pie> pies) throws DaoException;
    List<Pie> sortByDecreasePrice(List<Pie> pies) throws DaoException;
    List<Pie> findByWeight(int weight) throws DaoException;
}
