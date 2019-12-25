package by.epam.classes.service;

import by.epam.classes.domain.CommonConstants;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListValidator {
    public boolean isLineValid(String line) {
        if (line == null) {
            return false;
        }
        String regex = CommonConstants.REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
