package by.epam.bakery.service;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;

import java.util.Optional;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public User login(String login, String password) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao dao = helper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
