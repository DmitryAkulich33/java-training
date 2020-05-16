package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.api.OrderProductService;
import by.epam.bakery.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of {@link OrderProductService} interface. Provides access to {@link by.epam.bakery.service.api.OrderProductService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link OrderProduct}
 *
 * @see DaoHelper
 */
public class OrderProductServiceImpl implements OrderProductService {
    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(OrderProductServiceImpl.class.getName());

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public OrderProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Save product to order
     *
     * @param orderId order's id
     * @param pieId pie's id
     * @param amount pie's amount
     * @param cost cost of pies
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void save(int orderId, int pieId, int amount, double cost) throws ServiceException {
        log.debug("Service: saving order product started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            dao.save(orderId, pieId, amount, cost);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving order product finished.");
    }

    /**
     * Delete product from order
     *
     * @param orderProductId product's id in order
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void deleteOrderProduct(int orderProductId) throws ServiceException {
        log.debug("Service: deleting order product started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao orderProductDao = helper.createOrderProductDao();
            OrderDao orderDao = helper.createOrderDao();
            try {
                helper.startTransaction();
                OrderProduct orderProduct = orderProductDao.findOrderProductById(orderProductId);
                double piePrice = orderProduct.getPie().getPrice();
                double total = orderProduct.getOrder().getTotal() - piePrice;
                int orderId = orderProduct.getOrder().getId();
                orderDao.changeTotal(total, orderId);
                if(total == 0.0){
                    orderDao.removeById(orderId);
                }
                orderProductDao.removeById(orderProductId);
                helper.endTransaction();
            } catch (DaoException ex) {
                helper.backTransaction();
                throw new ServiceException(ex);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting order product finished.");
    }

    /**
     * Get list of products on 1 page
     *
     * @param start index of first products on page
     * @param amount number of products on page
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<OrderProduct> findLimitOrderProduct(int start, int amount) throws ServiceException {
        log.debug("Service: search limit order product on page.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProduct(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get list of products on 1 page by user
     *
     * @param start index of first products on page by user
     * @param amount number of products on page by user
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<OrderProduct> findLimitOrderProductByUserId(int userId, int start, int amount) throws ServiceException {
        log.debug("Service: search limit order product by user id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProductByUserId(userId, start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
