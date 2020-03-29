package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;

import java.util.List;
import java.util.Optional;

public interface PieDao extends Dao<Pie> {
    List<Pie> sortByIncreasePrice() throws DaoException;
    List<Pie> sortByReducePrice() throws DaoException;
    List<Pie> findByWeight(int weight) throws DaoException;
    Pie findByName(String name) throws DaoException;
    void changeName(String newName, int pieId) throws DaoException;
    void changePicture(String newPicture, int pieId) throws DaoException;
    void changeDescription(String newDescription, int pieId) throws DaoException;
    void changeWeight(int newWeight, int pieId) throws DaoException;
    void changePrice(double newPrice, int pieId) throws DaoException;
    List<Pie> findPieByBasketId(int basketId) throws DaoException;
}
