package by.epam.classes.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListValidator {
    public boolean isLineValid(String line) {
        if (line == null) {
            return false;
        }
        String regex = "^s*(MERSEDES|BMW|FORD|VOLKSWAGEN)\\s+\\S+\\s+[1-2][9|0]\\d{2}\\s+\\D+\\s+\\d+\\s+\\S{2}\\-\\d\\-\\d{4}\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
