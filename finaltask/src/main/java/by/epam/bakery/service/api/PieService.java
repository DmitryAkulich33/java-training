package by.epam.bakery.service.api;

import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.util.List;

public interface PieService {
    List<Pie> showAllPies() throws ServiceException;
    List<Pie> sortByPriceIncrease() throws ServiceException;
    List<Pie> sortByPriceReduce() throws ServiceException;
    Pie findPieById (String pieId) throws ServiceException, ValidatorException;
    Pie findPieByName (String name) throws ServiceException, ValidatorException;
    void deletePie (int id) throws ServiceException;
    void addPie(String name, String weight, String price, String description, String picture) throws ServiceException, ValidatorException;
    void changeName(String newName, int pieId) throws ServiceException, ValidatorException;
    void changePicture(String newPicture, int pieId) throws ServiceException, ValidatorException;
    void changeDescription(String newDescription, int pieId) throws ServiceException, ValidatorException;
    void changeWeight(String newWeight, int pieId) throws ServiceException, ValidatorException;
    void changePrice(String newPrice, int pieId) throws ServiceException, ValidatorException;
    List<Pie> getSortPieList (String value, String increase, String reduce) throws ServiceException;
}
