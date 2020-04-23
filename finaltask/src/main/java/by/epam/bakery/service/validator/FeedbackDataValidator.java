package by.epam.bakery.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeedbackDataValidator {
    private static final String REGEX_FEEDBACK = "^.{0,2000}$";

    private Pattern pattern;
    private Matcher matcher;

    public boolean isFeedbackValid(String feedback) {
        if (feedback.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_FEEDBACK);
        matcher = pattern.matcher(feedback);
        return matcher.matches();
    }
}
