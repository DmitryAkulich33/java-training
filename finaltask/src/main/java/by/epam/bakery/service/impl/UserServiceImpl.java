package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.api.UserService;
import by.epam.bakery.service.exception.LoginIsNotFreeException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.UserDataValidator;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private DaoHelperFactory daoHelperFactory;
    private UserDataValidator userDataValidator = new UserDataValidator();

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public User login(String login, String password) throws ServiceException, ValidatorException {
        if (!userDataValidator.isLoginValid(login) || !userDataValidator.isPasswordValid(password)) {
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> checkLogin(String login) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(String newName, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isNameValid(newName)) {
            throw new ValidatorException("The name is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeName(newName, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeSurname(String newSurname, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isSurnameValid(newSurname)) {
            throw new ValidatorException("The surname is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeSurname(newSurname, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePatronymic(String newPatronymic, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isPatronymicValid(newPatronymic)) {
            throw new ValidatorException("The patronymic is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePatronymic(newPatronymic, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeAddress(String newAddress, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isAddressValid(newAddress)) {
            throw new ValidatorException("The address is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeAddress(newAddress, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePhone(String newPhone, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isPhoneValid(newPhone)) {
            throw new ValidatorException("The phone is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePhone(newPhone, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeNote(String newNote, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isNoteValid(newNote)) {
            throw new ValidatorException("The note is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeNote(newNote, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeRole(String newRole, int userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isRoleValid(newRole)) {
            throw new ValidatorException("The role is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeRole(newRole, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addUser(String login, String password, String role, String surname, String name, String patronymic, String address, String phone, String note) throws ServiceException, ValidatorException, LoginIsNotFreeException {
        if (!userDataValidator.isLoginValid(login) || !userDataValidator.isPasswordValid(password) ||
                !userDataValidator.isSurnameValid(surname) || !userDataValidator.isNameValid(name) ||
                !userDataValidator.isPatronymicValid(patronymic) || !userDataValidator.isAddressValid(address) ||
                !userDataValidator.isPhoneValid(phone) || !userDataValidator.isNoteValid(note) ||
                !userDataValidator.isRoleValid(role)) {
            throw new ValidatorException("The entered data is not correct!");
        }
        if (!checkLogin(login).isEmpty()) {
            throw new LoginIsNotFreeException("Login is not free");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.save(login, password, role, surname, name, patronymic, address, phone, note);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findClientById(String userId) throws ServiceException, ValidatorException {
        if (!userDataValidator.isIdValid(userId)) {
            throw new ValidatorException("The id is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private int findUserAmount() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findUserPageAmount(int pageAmount) throws ServiceException {
        int amountAllUser = findUserAmount();
        return (int) Math.ceil((double) amountAllUser / pageAmount);
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

    @Override
    public int findClientAmount() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientsAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findClientPageAmount(int pageAmount) throws ServiceException {
        int amountAllClients = findClientAmount();
        return (int) Math.ceil((double) amountAllClients / pageAmount);
    }
}
