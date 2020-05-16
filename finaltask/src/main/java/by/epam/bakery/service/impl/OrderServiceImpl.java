package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.BasketDao;
import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.domain.Order;
import by.epam.bakery.service.api.OrderService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.OrderDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of {@link OrderService} interface. Provides access to {@link by.epam.bakery.service.api.OrderService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link Order}
 *
 * @see DaoHelper
 */
public class OrderServiceImpl implements OrderService {
    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Validator for this service
     */
    private OrderDataValidator orderDataValidator = new OrderDataValidator();

    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(OrderServiceImpl.class.getName());

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public OrderServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Save order
     *
     * @param userId user's id
     * @param total order's total
     * @param productionDate date of production pie
     * @param deliveryDate date of delivery pie
     * @param status order's status
     * @param basketProducts list of pies from basket
     * @param userLogin user's login
     * @param newTotal new total of basket after removing list of pies to order
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void saveOrder (int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate, String status,
                           List<BasketProduct> basketProducts, String userLogin, double newTotal) throws ServiceException {
        log.debug("Service: saving order started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao orderDao = helper.createOrderDao();
            OrderProductDao orderProductDao = helper.createOrderProductDao();
            BasketProductDao basketProductDao = helper.createBasketProductDao();
            BasketDao basketDao = helper.createBasketDao();
            try {
                helper.startTransaction();
                orderDao.save(userId, total, productionDate, deliveryDate, status);
                Order order = orderDao.findLastUserOrderById(userId);
                int orderId = order.getId();
                for(BasketProduct basketProduct: basketProducts){
                    orderProductDao.save(orderId, basketProduct.getPie().getId(), basketProduct.getAmount(), basketProduct.getCost());
                }
                Basket basket = basketDao.getBasketByUserLogin(userLogin);
                int basketId = basket.getId();
                basketProductDao.removeByBasketId(basketId);
                basketDao.changeTotal(newTotal, basketId);
                helper.endTransaction();
            } catch (DaoException ex) {
                helper.backTransaction();
                throw new ServiceException(ex);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving order finished.");
    }

    /**
     * Delete order
     *
     * @param orderId order's id
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void deleteOrderById(int orderId) throws ServiceException {
        log.debug("Service: deleting order by id started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.removeById(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting order by id finished.");
    }

    /**
     * Change production date
     *
     * @param newDate date of pie's production
     * @param orderId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeProductionDate(String newDate, int orderId) throws ServiceException, ValidatorException {
        log.debug("Service: changing production started.");
        if(!orderDataValidator.isDateValid(newDate)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        LocalDateTime newLocalDateTime = LocalDateTime.parse(newDate);
        if(!orderDataValidator.isDateAfter(newLocalDateTime)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.changeProductionDate(newLocalDateTime, orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: changing production finished.");
    }

    /**
     * Change delivery date
     *
     * @param newDate date of pie's delivery
     * @param orderId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeDeliveryDate(String newDate, int orderId) throws ServiceException, ValidatorException {
        log.debug("Service: changing production started.");
        if(!orderDataValidator.isDateValid(newDate)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        LocalDateTime newLocalDateTime = LocalDateTime.parse(newDate);
        if(!orderDataValidator.isDateAfter(newLocalDateTime)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.changeDeliveryDate(newLocalDateTime, orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: changing production finished.");
    }

    /**
     * Change order's status
     *
     * @param newStatus order's status
     * @param orderId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeStatus(String newStatus, int orderId) throws ServiceException, ValidatorException {
        log.debug("Service: changing status started.");
        if(!orderDataValidator.isStatusValid(newStatus)) {
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            dao.changeStatus(newStatus, orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: changing status finished.");
    }

    /**
     * Find number of orders
     *
     * @return number of orders
     * @throws ServiceException if there is an error on DAO layer
     */
    private int findOrderAmount () throws ServiceException{
        log.debug("Service: Getting order amount.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Find number of pages with orders
     *
     * @param pageAmount number of order on page
     * @return numbers of pages with orders
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public int findOrderPageAmount (int pageAmount) throws ServiceException{
        log.debug("Service: Getting order page amount.");
        int amountAllOrders = findOrderAmount();
        return (int) Math.ceil((double) amountAllOrders/pageAmount);
    }

    /**
     * Find number of orders by user
     *
     * @param userId user's id
     * @return numbers of orders by user
     * @throws ServiceException if there is an error on DAO layer
     */
    private int findAmountOrderByUserId (int userId) throws ServiceException{
        log.debug("Service: Getting amount order by user id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findAmountOrdersByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Find number of pages with orders by user
     *
     * @param pageAmount number of order on page
     * @param userId user's id
     * @return numbers of pages with orders by user
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public int findOrderByUserIdPageAmount (int pageAmount, int userId) throws ServiceException{
        log.debug("Service: Getting amount order by user id on page.");
        int amountAllOrders = findAmountOrderByUserId(userId);
        return (int) Math.ceil((double) amountAllOrders/pageAmount);
    }

    /**
     * Find number of orders
     *
     * @return numbers of orders
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public int findOrdersAmount() throws ServiceException {
        log.debug("Service: Getting amount orders.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findOrdersAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Find order's cost
     *
     * @return order's cost
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public int findOrdersCost() throws ServiceException {
        log.debug("Service: Getting orders costs.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findOrdersCost();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
