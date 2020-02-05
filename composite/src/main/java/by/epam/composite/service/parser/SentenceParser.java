package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.TextComposite;
import by.epam.composite.service.creator.TokenLeafCreator;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String SPLIT_WORDS = "\\s+";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        String[] parts = string.trim().split(SPLIT_WORDS);
        TokenLeafCreator leafCreator = new TokenLeafCreator();

        for (String part : parts) {
            Component leaf = leafCreator.createTokenLeaf(part);
            components.add(leaf);
        }

        String lastTokenSentence = parts[parts.length-1];
        Component mark = leafCreator.createMark(lastTokenSentence);
        components.add(mark);

        return new TextComposite(components);
    }
}
