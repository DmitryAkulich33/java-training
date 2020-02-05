package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;

public class ChainTextParser {
    private static TextParser textParser = new TextParser();

    static {
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(sentenceParser);
    }

    public static Component parse(String text) {
        return textParser.parse(text);
    }
}
