package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.api.UserService;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public User login(String login, String password) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(String newName, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeName(newName, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeSurname(String newSurname, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeSurname(newSurname, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePatronymic(String newPatronymic, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePatronymic(newPatronymic, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeAddress(String newAddress, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeAddress(newAddress, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePhone(String newPhone, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePhone(newPhone, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeNote(String newNote, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeNote(newNote, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeRole(int newRole, int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeRole(newRole, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> showAllUsers() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser (int id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addUser (String login, String password, int role, String surname, String name, String patronymic, String address, String phone, String note) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.save(login, password, role, surname, name, patronymic, address, phone, note);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserById (int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findUsersBySurname(String surname) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUsersBySurname(surname);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findClientBySurname(String surname) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientBySurname(surname);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findClientById (int userId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findUserByRole(int role) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByRole(role);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private int findUserAmount () throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findUserPageAmount (int pageAmount) throws ServiceException{
        int amountAllUser = findUserAmount();
        return (int) Math.ceil((double) amountAllUser/pageAmount);
    }

    @Override
    public List<User> findLimitUser(int start, int amount) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findLimit(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findLimitClients(int start, int amount) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.getLimitClients(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private int findClientAmount () throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientsAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findClientPageAmount (int pageAmount) throws ServiceException{
        int amountAllClients = findClientAmount();
        return (int) Math.ceil((double) amountAllClients/pageAmount);
    }
}
