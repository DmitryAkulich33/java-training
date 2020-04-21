package by.epam.bakery.service.validator.factory;

import by.epam.bakery.service.validator.api.PieDataValidator;
import by.epam.bakery.service.validator.impl.PieDataValidatorImpl;

public final class ValidatorFactory {
    private static final ValidatorFactory instance = new ValidatorFactory();

    private final PieDataValidator pieDataValidator = new PieDataValidatorImpl();

    public static ValidatorFactory getInstance() {
        return instance;
    }

    public PieDataValidator getPieDataValidator() {
        return pieDataValidator;
    }
}
