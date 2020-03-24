package by.epam.bakery.service.api;

import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface PieService {
    List<Pie> showAllPies() throws ServiceException;
    List<Pie> sortByPriceIncrease() throws ServiceException;
    List<Pie> sortByPriceReduce() throws ServiceException;
    Pie findPieById (int pieId) throws ServiceException;
    Pie findPieByName (String name) throws ServiceException;
    void deletePie (int id) throws ServiceException;
    void addPie (String name, int weight, double price, String description, String picture) throws ServiceException;
}
