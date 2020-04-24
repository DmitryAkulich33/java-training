package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.api.PieService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.PieDataValidator;

import java.util.ArrayList;
import java.util.List;

public class PieServiceImpl implements PieService {
    private DaoHelperFactory daoHelperFactory;
    private PieDataValidator pieDataValidator = new PieDataValidator();

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
    public List<Pie> sortByPriceIncrease() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByIncreasePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Pie> sortByPriceReduce() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByReducePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pie findPieById(String pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isIdValid(pieId)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findById(pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pie findPieByName(String name) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isNameValid(name)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deletePie(int id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addPie(String name, String weight, String price, String description, String picture) throws ServiceException, ValidatorException {
        if (!pieDataValidator.isNameValid(name) || !pieDataValidator.isWeightValid(weight) ||
                !pieDataValidator.isPriceValid(price) || !pieDataValidator.isDescriptionValid(description) ||
                !pieDataValidator.isPictureValid(picture)) {
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.save(name, weight, price, description, picture);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(String newName, int pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isNameValid(newName)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeName(newName, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePicture(String newPicture, int pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isPictureValid(newPicture)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePicture(newPicture, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeDescription(String newDescription, int pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isDescriptionValid(newDescription)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeDescription(newDescription, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeWeight(String newWeight, int pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isWeightValid(newWeight)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeWeight(newWeight, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePrice(String newPrice, int pieId) throws ServiceException, ValidatorException {
        if(!pieDataValidator.isPriceValid(newPrice)){
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePrice(newPrice, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Pie> getSortPieList(String value, String increase, String reduce) throws ServiceException {
        List<Pie> pies = new ArrayList<>();
        if (value != null) {
            if (value.equals(increase)) {
                pies = sortByPriceIncrease();
            } else if (value.equals(reduce)) {
                pies = sortByPriceReduce();
            }
        } else {
            pies = showAllPies();
        }
        return pies;
    }
}
