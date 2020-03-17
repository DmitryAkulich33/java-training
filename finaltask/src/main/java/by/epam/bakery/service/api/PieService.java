package by.epam.bakery.service.api;

import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface PieService {
    List<Pie> showAllPies() throws ServiceException;
    List<Pie> sortByPriceIncrease() throws ServiceException;
    List<Pie> sortByPriceReduce() throws ServiceException;
}
