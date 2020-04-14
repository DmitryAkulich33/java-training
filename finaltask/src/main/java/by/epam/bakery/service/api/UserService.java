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
    void addUser (String login, String password, int role, String surname, String name, String patronymic, String address, String phone, String note) throws ServiceException;
    User findUserById (int userId) throws ServiceException;
    List<User> findUsersBySurname(String surname) throws ServiceException;
    void changeNote(String newNote, int userId) throws ServiceException;
    void changeRole(int newRole, int userId) throws ServiceException;
    List<User> findLimitClients(int start, int amount) throws ServiceException;
    List<User> findClientBySurname(String surname) throws ServiceException;
    User findClientById (int userId) throws ServiceException;
    List<User> findUserByRole(int role) throws ServiceException;
    int findUserPageAmount (int pageAmount) throws ServiceException;
    List<User> findLimitUser(int start, int amount) throws ServiceException;
    int findClientPageAmount (int pageAmount) throws ServiceException;
}
