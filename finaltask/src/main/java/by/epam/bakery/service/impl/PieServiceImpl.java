package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.api.PieService;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public class PieServiceImpl implements PieService {
    private DaoHelperFactory daoHelperFactory;

    public PieServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Pie> showAllPies() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Pie> sortByPriceIncrease() throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByIncreasePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Pie> sortByPriceReduce() throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByReducePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Pie findPieById (int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findById(pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
