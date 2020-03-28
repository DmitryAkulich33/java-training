package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.api.BasketService;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    private DaoHelperFactory daoHelperFactory;

    public BasketServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public double getTotal(Basket basket) throws ServiceException{
//        if(basket == null){
//            throw new ServiceException("Basket is null.");
//        }
//        double sum = 0;
//        if(!basket.getPies().isEmpty()) {
//            for (Pie pie : basket.getPies()) {
//                sum = sum + pie.getPrice();
//            }
//        }
        return 0;
    }
}
