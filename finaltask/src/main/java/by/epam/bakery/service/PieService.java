package by.epam.bakery.service;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public class PieService {
    private DaoHelperFactory daoHelperFactory;

    public PieService(DaoHelperFactory daoHelperFactory) {
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
}
