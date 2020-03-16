package by.epam.bakery.service.api;

import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;

public interface UserService {
    User login(String login, String password) throws ServiceException;
}
