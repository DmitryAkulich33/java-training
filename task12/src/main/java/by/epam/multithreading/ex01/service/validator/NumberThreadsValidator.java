package by.epam.multithreading.ex01.service.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberThreadsValidator {
    private final String REGEX = "^[4-6]$";

    public boolean isLineValid(String line){
        if (line == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
