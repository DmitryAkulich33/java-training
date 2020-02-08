package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Lexeme;
import by.epam.composite.domain.Paragraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private Pattern notLetterStart = Pattern.compile("^\\W");
    private Pattern notLetterEnd = Pattern.compile("\\W$");


    @Override
    public Component parse(String lexeme) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(lexeme);
            List<String> parts = parseToWord(lexeme.trim());
            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new Lexeme(components);
    }

    private List<String> parseToWord(String lexeme) {
        List<String> list = new ArrayList<>();
        int length = lexeme.length();

        Matcher matcher1 = notLetterStart.matcher(Character.toString(lexeme.charAt(0)));
        Matcher matcher2 = notLetterEnd.matcher(Character.toString(lexeme.charAt(length - 1)));

        if (matcher1.matches() && !matcher2.matches()) {
            list = Arrays.asList(Character.toString(lexeme.charAt(0)), lexeme.substring(1));
        } else if (!matcher1.matches() && !matcher2.matches()) {
            list.add(lexeme);
        } else if (!matcher1.matches() && matcher2.matches()) {
            list = Arrays.asList(lexeme.substring(0, length - 1), Character.toString(lexeme.charAt(length - 1)));
        } else {
            list = Arrays.asList(Character.toString(lexeme.charAt(0)), lexeme.substring(1, lexeme.length() - 1), Character.toString(lexeme.charAt(length - 1)));
        }
        return list;
    }
}
