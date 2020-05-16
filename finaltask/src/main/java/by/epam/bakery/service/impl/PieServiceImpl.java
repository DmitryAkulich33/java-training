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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link PieService} interface. Provides access to {@link by.epam.bakery.service.api.PieService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link Pie}
 *
 * @see DaoHelper
 */
public class PieServiceImpl implements PieService {
    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Validator for this service
     */
    private PieDataValidator pieDataValidator = new PieDataValidator();

    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(PieServiceImpl.class.getName());

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public PieServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Get list of pies
     *
     * @return list of pies
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<Pie> showAllPies() throws ServiceException {
        log.debug("Service: Getting list of pies.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get list of sorted pies by increase price
     *
     * @return sorted list of pies
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<Pie> sortByPriceIncrease() throws ServiceException {
        log.debug("Service: Getting sort by price increase list of pies.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByIncreasePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get list of sorted pies by reduce price
     *
     * @return sorted list of pies
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<Pie> sortByPriceReduce() throws ServiceException {
        log.debug("Service: Getting sort by price reduce list of pies.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.sortByReducePrice();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get pie by id
     *
     * @param pieId pie's id
     * @return pie
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public Pie findPieById(String pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Getting pie by id.");
        if(!pieDataValidator.isIdValid(pieId)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findById(pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get pie by name
     *
     * @param name pie's id
     * @return pie
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public Pie findPieByName(String name) throws ServiceException, ValidatorException {
        log.debug("Service: Getting pie by name.");
        if(!pieDataValidator.isNameValid(name)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            return dao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Delete pie
     *
     * @param id pie's id
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void deletePie(int id) throws ServiceException {
        log.debug("Service: Deleting pie started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.removeById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Deleting pie finished.");
    }

    /**
     * Add new pie
     *
     * @param name pie's name
     * @param weight pie's weight
     * @param price pie's price
     * @param description pie's description
     * @param picture pie's picture
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void addPie(String name, String weight, String price, String description, String picture) throws ServiceException, ValidatorException {
        log.debug("Service: Adding pie started.");
        if (!pieDataValidator.isNameValid(name) || !pieDataValidator.isWeightValid(weight) ||
                !pieDataValidator.isPriceValid(price) || !pieDataValidator.isDescriptionValid(description) ||
                !pieDataValidator.isPictureValid(picture)) {
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.save(name, weight, price, description, picture);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Adding pie finished.");
    }

    /**
     * Change pie's name
     *
     * @param newName pie's new name
     * @param pieId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeName(String newName, int pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing name started.");
        if(!pieDataValidator.isNameValid(newName)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeName(newName, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing name finished.");
    }

    /**
     * Change path of picture
     *
     * @param newPicture pie's new path of picture
     * @param pieId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changePicture(String newPicture, int pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing picture started.");
        if(!pieDataValidator.isPictureValid(newPicture)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePicture(newPicture, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing picture finished.");
    }

    /**
     * Change pie's description
     *
     * @param newDescription pie's new description
     * @param pieId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeDescription(String newDescription, int pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing description started.");
        if(!pieDataValidator.isDescriptionValid(newDescription)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeDescription(newDescription, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing description finished.");
    }

    /**
     * Change pie's weight
     *
     * @param newWeight pie's new weight
     * @param pieId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changeWeight(String newWeight, int pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing weight started.");
        if(!pieDataValidator.isWeightValid(newWeight)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changeWeight(newWeight, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing weight finished.");
    }

    /**
     * Change pie's price
     *
     * @param newPrice pie's new price
     * @param pieId pie's id
     * @throws ServiceException if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void changePrice(String newPrice, int pieId) throws ServiceException, ValidatorException {
        log.debug("Service: Changing price started.");
        if(!pieDataValidator.isPriceValid(newPrice)){
            log.error("The entered data is not correct!");
            throw new ValidatorException("The entered data is not correct!");
        }
        try (DaoHelper helper = daoHelperFactory.create()) {
            PieDao dao = helper.createPieDao();
            dao.changePrice(newPrice, pieId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: Changing price finished.");
    }

    /**
     * Get sorted list of pies
     *
     * @param value way of sort
     * @param increase value sorting by increase price
     * @param reduce value sorting by reduce price
     * @throws ServiceException if there is an error on DAO layer
     */
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
