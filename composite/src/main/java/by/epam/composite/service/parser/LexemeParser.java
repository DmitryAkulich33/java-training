package by.epam.composite.service.parser;

import by.epam.composite.domain.ComponentType;
import by.epam.composite.domain.Composite;
import by.epam.composite.domain.Symbol;
import by.epam.composite.service.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String WORD_REGEX = "([A-Za-z]+)";

    public Composite parse(String lexeme) throws CompositeParseException {
        if (successor == null){
            throw new CompositeParseException("Incomplete chain of parsers");
        }
        Composite parsedLexeme = new Composite(ComponentType.LEXEME);
        Matcher wordMatcher = Pattern.compile(WORD_REGEX, Pattern.DOTALL).matcher(lexeme);
        while (wordMatcher.find()){
            int start = wordMatcher.start();
            if (start == 0) {
                String word = wordMatcher.group();
                parsedLexeme.addChild(successor.parse(word));
                lexeme = lexeme.substring(wordMatcher.end());
            } else {
                parsedLexeme.addChild(new Symbol(lexeme.charAt(0)));
                lexeme = lexeme.substring(1);
            }
            wordMatcher.reset(lexeme);
        }
        for (Character character : lexeme.toCharArray()){
            parsedLexeme.addChild(new Symbol(character));
        }
        return parsedLexeme;
    }
}
