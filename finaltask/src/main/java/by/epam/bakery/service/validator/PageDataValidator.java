package by.epam.bakery.service.validator;

public class PageDataValidator {

    public boolean isStatusValid(String page, int count) {
        if (status.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_STATUS);
        matcher = pattern.matcher(status);
        return matcher.matches();
    }
}
