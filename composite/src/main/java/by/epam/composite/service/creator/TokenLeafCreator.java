package by.epam.composite.service.creator;

import by.epam.composite.domain.TokenLeaf;

public class TokenLeafCreator {
    private static final String SENTENCE_MARK = "[.!?]";

    public TokenLeaf createTokenLeaf(String string) {
        String wordWithoutMark = spotWord(string);
        return TokenLeaf.newWord(wordWithoutMark);
    }

    public TokenLeaf createMark(String sentence) {
        TokenLeaf component;
        if (sentence.endsWith("...")) {
            component = TokenLeaf.newMark("...");
        } else if (sentence.endsWith(".")) {
            component = TokenLeaf.newMark(".");
        } else if (sentence.endsWith("!")) {
            component = TokenLeaf.newMark("!");
        } else {
            component = TokenLeaf.newMark("?");
        }
        return component;
    }

    private String spotWord(String string) {
        return string.split(SENTENCE_MARK)[0];
    }
}
