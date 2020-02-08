package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;

public class ChainTextParser {
    private static TextParser textParser = new TextParser();

    static {
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();

        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(sentenceParser);
        sentenceParser.setSuccessor(lexemeParser);
        lexemeParser.setSuccessor(wordParser);
        wordParser.setSuccessor(symbolParser);
    }

    public static Component parse(String text) {
        return textParser.parse(text);
    }
}
