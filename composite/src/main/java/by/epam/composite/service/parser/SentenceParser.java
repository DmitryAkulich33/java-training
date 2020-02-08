package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Paragraph;
import by.epam.composite.domain.Sentence;
import by.epam.composite.domain.TextComposite;
import by.epam.composite.service.creator.TokenLeafCreator;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String SPLIT_LEXEME = "\\s+";

    @Override
    public Component parse(String sentence) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(sentence);
            String[] parts = sentence.trim().split(SPLIT_LEXEME);
            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new Sentence(components);
    }
//    public Component parse(String string) {
//        List<Component> components = new ArrayList<>();
//        String[] parts = string.trim().split(SPLIT_WORDS);
//        TokenLeafCreator leafCreator = new TokenLeafCreator();
//
//        for (String part : parts) {
//            Component leaf = leafCreator.createTokenLeaf(part);
//            components.add(leaf);
//        }
//
//        String lastTokenSentence = parts[parts.length-1];
//        Component mark = leafCreator.createMark(lastTokenSentence);
//        components.add(mark);
//
//        return new TextComposite(components);
//    }
}
