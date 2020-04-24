package by.epam.bakery.service.api;

import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.LoginIsNotFreeException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.util.List;

public interface UserService {
    User login(String login, String password) throws ServiceException, ValidatorException;
    void changeName(String newName, int userId) throws ServiceException, ValidatorException;
    void changeSurname(String newSurname, int userId) throws ServiceException, ValidatorException;
    void changePatronymic(String newPatronymic, int userId) throws ServiceException, ValidatorException;
    void changeAddress(String newAddress, int userId) throws ServiceException, ValidatorException;
    void changePhone(String newPhone, int userId) throws ServiceException, ValidatorException;
    void deleteUser (int id) throws ServiceException;
    void addUser (String login, String password, String role, String surname, String name, String patronymic, String address, String phone, String note) throws ServiceException, ValidatorException, LoginIsNotFreeException;
    void changeNote(String newNote, int userId) throws ServiceException;
    void changeRole(int newRole, int userId) throws ServiceException;
    List<User> findLimitClients(int start, int amount) throws ServiceException;
    User findClientById(String userId) throws ServiceException, ValidatorException;
    int findUserPageAmount (int pageAmount) throws ServiceException;
    List<User> findLimitUser(int start, int amount) throws ServiceException;
    int findClientPageAmount (int pageAmount) throws ServiceException;
}
