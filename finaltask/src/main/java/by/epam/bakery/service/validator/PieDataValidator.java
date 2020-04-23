package by.epam.bakery.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PieDataValidator {
    private static final String REGEX_FOR_PIE_AMOUNT = "^[1-9]{1,2}$";

    private Pattern pattern;
    private Matcher matcher;

    public boolean isPieAmountValid(String amount) {
        if (amount.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_FOR_PIE_AMOUNT);
        matcher = pattern.matcher(amount);
        return matcher.matches();
    }
}
