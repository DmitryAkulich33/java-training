package by.epam.bakery.service.api;

import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User login(String login, String password) throws ServiceException;
    void changeName(String newName, int userId) throws ServiceException;
    void changeSurname(String newSurname, int userId) throws ServiceException;
    void changePatronymic(String newPatronymic, int userId) throws ServiceException;
    void changeAddress(String newAddress, int userId) throws ServiceException;
    void changePhone(String newPhone, int userId) throws ServiceException;
    List<User> showAllUsers() throws ServiceException;
    void deleteUser (int id) throws ServiceException;
}
