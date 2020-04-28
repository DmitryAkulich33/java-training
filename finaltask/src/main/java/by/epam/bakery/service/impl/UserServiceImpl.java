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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private DaoHelperFactory daoHelperFactory;
    private UserDataValidator userDataValidator = new UserDataValidator();
    private static Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public User login(String login, String password) throws ServiceException, ValidatorException {
        log.debug("Service: Login user.");
        if (!userDataValidator.isLoginValid(login) || !userDataValidator.isPasswordValid(password)) {
            log.error("The entered data is not correct!");
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
        log.debug("Service: checking login.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(String newName, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing name started.");
        if (!userDataValidator.isNameValid(newName)) {
            log.error("The name is wrong");
            throw new ValidatorException("The name is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeName(newName, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing name finished.");
    }

    @Override
    public void changeSurname(String newSurname, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing surname started.");
        if (!userDataValidator.isSurnameValid(newSurname)) {
            log.error("The surname is wrong");
            throw new ValidatorException("The surname is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeSurname(newSurname, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing surname finished.");
    }

    @Override
    public void changePatronymic(String newPatronymic, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing patronymic started.");
        if (!userDataValidator.isPatronymicValid(newPatronymic)) {
            log.error("The patronymic is wrong");
            throw new ValidatorException("The patronymic is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePatronymic(newPatronymic, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing patronymic finished.");
    }

    @Override
    public void changeAddress(String newAddress, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing address started.");
        if (!userDataValidator.isAddressValid(newAddress)) {
            log.error("The address is wrong");
            throw new ValidatorException("The address is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeAddress(newAddress, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing address finished.");
    }

    @Override
    public void changePhone(String newPhone, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing phone started.");
        if (!userDataValidator.isPhoneValid(newPhone)) {
            log.error("The phone is wrong");
            throw new ValidatorException("The phone is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changePhone(newPhone, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing phone finished.");
    }

    @Override
    public void changeNote(String newNote, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing note started.");
        if (!userDataValidator.isNoteValid(newNote)) {
            log.error("The note is wrong");
            throw new ValidatorException("The note is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeNote(newNote, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing note finished.");
    }

    @Override
    public void changeRole(String newRole, int userId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing role started.");
        if (!userDataValidator.isRoleValid(newRole)) {
            log.error("The role is wrong");
            throw new ValidatorException("The role is wrong");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.changeRole(newRole, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing role finished.");
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        log.debug("Service: Deleting role started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Deleting role finished.");
    }

    @Override
    public void addUser(String login, String password, String role, String surname, String name, String patronymic, String address, String phone, String note) throws ServiceException, ValidatorException, LoginIsNotFreeException {
        log.debug("Service: Adding user started.");
        if (!userDataValidator.isLoginValid(login) || !userDataValidator.isPasswordValid(password) ||
                !userDataValidator.isSurnameValid(surname) || !userDataValidator.isNameValid(name) ||
                !userDataValidator.isPatronymicValid(patronymic) || !userDataValidator.isAddressValid(address) ||
                !userDataValidator.isPhoneValid(phone) || !userDataValidator.isNoteValid(note) ||
                !userDataValidator.isRoleValid(role)) {
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        if (!checkLogin(login).isEmpty()) {
            log.error("Login is not free");
            throw new LoginIsNotFreeException("Login is not free");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            dao.save(login, password, role, surname, name, patronymic, address, phone, note);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Adding user finished.");
    }

    @Override
    public User findClientById(String userId) throws ServiceException, ValidatorException {
        log.debug("Service: Getting user.");
        if (!userDataValidator.isIdValid(userId)) {
            log.error("The id is wrong");
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
        log.debug("Service: Getting user amount.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findUserPageAmount(int pageAmount) throws ServiceException {
        log.debug("Service: Getting user page amount.");
        int amountAllUser = findUserAmount();
        return (int) Math.ceil((double) amountAllUser / pageAmount);
    }

    @Override
    public List<User> findLimitUser(int start, int amount) throws ServiceException {
        log.debug("Service: Getting user limit.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findLimit(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findLimitClients(int start, int amount) throws ServiceException {
        log.debug("Service: Getting clients limit.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.getLimitClients(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findClientAmount() throws ServiceException {
        log.debug("Service: Getting clients amount.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findClientsAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findClientPageAmount(int pageAmount) throws ServiceException {
        log.debug("Service: Getting client page amount.");
        int amountAllClients = findClientAmount();
        return (int) Math.ceil((double) amountAllClients / pageAmount);
    }
}
