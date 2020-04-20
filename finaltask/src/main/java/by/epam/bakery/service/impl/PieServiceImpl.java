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

    @Override
    public List<Pie> showAllPies() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Pie> sortByPriceIncrease() throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByIncreasePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Pie> sortByPriceReduce() throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByReducePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pie findPieById (int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findById(pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pie findPieByName (String name) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deletePie (int id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addPie (String name, int weight, double price, String description, String picture) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.save(name, weight, price, description, picture);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(String newName, int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeName(newName, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePicture(String newPicture, int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePicture(newPicture, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeDescription(String newDescription, int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeDescription(newDescription, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeWeight(int newWeight, int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeWeight(newWeight, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePrice(double newPrice, int pieId) throws ServiceException{
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePrice(newPrice, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
