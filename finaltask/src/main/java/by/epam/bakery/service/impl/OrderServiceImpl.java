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
import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.service.api.OrderService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.OrderDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;
    private OrderDataValidator orderDataValidator = new OrderDataValidator();
    private static Logger log = LogManager.getLogger(OrderServiceImpl.class.getName());

    public OrderServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

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
                log.debug("saved 1");
                Order order = orderDao.findLastUserOrderById(userId);
                int orderId = order.getId();
                log.debug("found id is" + orderId);
                for(BasketProduct basketProduct: basketProducts){
                    log.debug("cycl" );
                    orderProductDao.save(orderId, basketProduct.getPie().getId(), basketProduct.getAmount(), basketProduct.getCost());
                }
                log.debug("cycl finished" );
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

    private int findOrderAmount () throws ServiceException{
        log.debug("Service: Getting order amount.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findAmount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findOrderPageAmount (int pageAmount) throws ServiceException{
        log.debug("Service: Getting order page amount.");
        int amountAllOrders = findOrderAmount();
        return (int) Math.ceil((double) amountAllOrders/pageAmount);
    }

    private int findAmountOrderByUserId (int userId) throws ServiceException{
        log.debug("Service: Getting amount order by user id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderDao dao = helper.createOrderDao();
            return dao.findAmountOrdersByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findOrderByUserIdPageAmount (int pageAmount, int userId) throws ServiceException{
        log.debug("Service: Getting amount order by user id on page.");
        int amountAllOrders = findAmountOrderByUserId(userId);
        return (int) Math.ceil((double) amountAllOrders/pageAmount);
    }

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
