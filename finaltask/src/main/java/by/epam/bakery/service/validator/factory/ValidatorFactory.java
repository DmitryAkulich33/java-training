package by.epam.bakery.service.validator.factory;

import by.epam.bakery.service.validator.api.PieDataValidator;
import by.epam.bakery.service.validator.api.UserDataValidator;
import by.epam.bakery.service.validator.impl.PieDataValidatorImpl;
import by.epam.bakery.service.validator.impl.UserDataValidatorImpl;

public final class ValidatorFactory {
    private static final ValidatorFactory instance = new ValidatorFactory();

    private final PieDataValidator pieDataValidator = new PieDataValidatorImpl();
    private final UserDataValidator userDataValidator = new UserDataValidatorImpl();

    private ValidatorFactory(){

    }

    public static ValidatorFactory getInstance() {
        return instance;
    }

    public PieDataValidator getPieDataValidator() {
        return pieDataValidator;
    }

    public UserDataValidator getUserDataValidator() {
        return userDataValidator;
    }
}
