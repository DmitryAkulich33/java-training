package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.service.LexemeService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeServiceImpl implements LexemeService {
    private static Logger log = LogManager.getLogger(LexemeServiceImpl.class.getName());

    public String sort(Component original, char letter) {
        List<String> sorted = Arrays.stream(original.operation().trim().split("\\s+"))
                .sorted(Comparator.comparingInt((String lexeme) -> getCount(letter, lexeme)).reversed().thenComparing(String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        log.info("Lexemes in sentence are sorted.");
        sorted.add(0, "   ");
        return String.join(" ", sorted);
    }

    public static int getCount(char letter, String lexeme) {
        char[] array = lexeme.toCharArray();
        int count = 0;
        for (char element : array) {
            if (element == letter) {
                count++;
            }
        }
        return count;
    }

}
