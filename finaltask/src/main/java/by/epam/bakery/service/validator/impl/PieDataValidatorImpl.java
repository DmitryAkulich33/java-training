package by.epam.bakery.service.validator.impl;

import by.epam.bakery.service.validator.api.PieDataValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PieDataValidatorImpl implements PieDataValidator {
    private static final String REGEX_FOR_PIE_AMOUNT = "^[1-9]{1,2}$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean isPieAmountValid(String amount) {
        if (amount.equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(REGEX_FOR_PIE_AMOUNT);
        Matcher matcher = pattern.matcher(amount);
        return matcher.matches();
    }



}
