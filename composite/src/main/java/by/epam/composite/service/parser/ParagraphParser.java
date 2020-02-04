package by.epam.composite.service.parser;

import by.epam.composite.domain.ComponentType;
import by.epam.composite.domain.Composite;
import by.epam.composite.service.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_REGEX =
            "(((?<=\\s)[A-Z]|^[A-Z])"
            + "([A-Za-z0-9\\s,;:\\+\\-\\*/="
            + "\\|\\(\\)\\{\\}\\[\\]#_\\^\"@\\$%&'\\\\]"
            + "|(?<!\\s)\\.(?!\\s)+"
            + "([\\.\\?!](?=\\s)|[\\.\\?!]$)))";

    public Composite parse(String paragraph) throws CompositeParseException {
        if (successor == null){
            throw new CompositeParseException("Incomplete chain of parsers");
        }
        Composite parsedParagraph = new Composite(ComponentType.PARAGRAPH);
        Matcher sentenceMatcher = Pattern.compile(SENTENCE_REGEX, Pattern.DOTALL).matcher(paragraph);
        while (sentenceMatcher.find()){
            String sentence = sentenceMatcher.group();
            parsedParagraph.addChild(successor.parse(sentence));
        }
        return parsedParagraph;
    }
}
