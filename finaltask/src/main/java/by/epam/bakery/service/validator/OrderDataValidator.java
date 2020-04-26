package by.epam.bakery.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderDataValidator {
    private static final String REGEX_STATUS = "^(not ready|ready|delivered|not delivered)$";

    private Pattern pattern;
    private Matcher matcher;

    public boolean isStatusValid(String status) {
        if (status.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_STATUS);
        matcher = pattern.matcher(status);
        return matcher.matches();
    }
}
