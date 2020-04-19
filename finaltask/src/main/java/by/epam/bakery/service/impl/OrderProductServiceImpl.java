package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.api.OrderProductService;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public class OrderProductServiceImpl implements OrderProductService {
    private DaoHelperFactory daoHelperFactory;

    public OrderProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int orderId, int pieId, int amount, double cost) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            dao.save(orderId, pieId, amount, cost);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findByUserId(int userId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteOrderProductById(int orderProductId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            dao.removeById(orderProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findOrderProducts() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findOrderProducts();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findByOrderId(int orderId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findByOrderId(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public OrderProduct findOrderProductById (int orderProductId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findOrderProductById(orderProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findLimitOrderProduct(int start, int amount) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProduct(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findLimitOrderProductByUserId(int userId, int start, int amount) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProductByUserId(userId, start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
