package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Lexeme;
import by.epam.composite.domain.Paragraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private final Pattern letter = Pattern.compile("\\w");
    private final Pattern notLetter = Pattern.compile("\\W");


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

    private List<String> parseToWord(String lexeme){
        List<String> list = new ArrayList<>();
        Matcher matcher;
        String component = "";
        char[] chars = lexeme.toCharArray();
        for (int i = 0; i < chars.length; i++ ) {
            String s = Character.toString(chars[i]);
            matcher = notLetter.matcher(Character.toString(chars[i]));
            if (matcher.matches()) {
                list.add(Character.toString(chars[i]));
            }
            matcher = letter.matcher(Character.toString(chars[i]));
            if(matcher.matches()) {
                while (matcher.matches()) {
                    component = component + chars[i];
                    i++;
                    if(i >= chars.length){
                        break;
                    }
                    matcher = letter.matcher(Character.toString(chars[i]));
                }
                list.add(component);
                i--;
            }
        }
        return list;
    }
}
