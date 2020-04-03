package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Order;
import by.epam.bakery.service.api.OrderService;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;

    public OrderServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate,  String status) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.save(userId, total, productionDate, deliveryDate, status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Order findLastOrderByUserId(int userId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findLastUserOrderById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> findAllOrders() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findAllOrders();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> findOrderByUserId(int userId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteOrderById(int orderId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.removeById(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
