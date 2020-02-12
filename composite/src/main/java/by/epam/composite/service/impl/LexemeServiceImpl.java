package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;
import by.epam.composite.service.LexemeService;
import by.epam.composite.service.comparator.SizeComparator;
import by.epam.composite.service.copier.ComponentCopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LexemeServiceImpl implements LexemeService {
    public String sort(Component original, char letter) {
        List<String> sorted = Arrays.stream(original.operation().trim().split("\\s+"))
                .sorted(Comparator.comparingInt((String lexeme) -> getCount(letter, lexeme)).thenComparing(String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        return String.join(" ", sorted);
    }

    public static int getCount(char letter, String lexeme){
        char[] array = lexeme.toCharArray();
        int count = 0;
        for(char element : array){
            if(element == letter){
                count++;
            }
        }
        return count;
    }

}
