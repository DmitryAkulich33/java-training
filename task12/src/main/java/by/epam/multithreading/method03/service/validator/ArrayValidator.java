package by.epam.multithreading.method03.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {
    private final String REGEX = "^(\\d+\\s+){9,11}\\d*$";

    public boolean isLineValid(String line) {
        if (line == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
