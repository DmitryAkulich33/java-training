package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.service.api.OrderService;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;

    public OrderServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate, String status) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.save(userId, total, productionDate, deliveryDate, status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
