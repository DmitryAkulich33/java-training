package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Sentence;
import by.epam.composite.domain.Word;

import java.util.ArrayList;
import java.util.List;

public class WordParser extends AbstractParser {
    private static final String SPLIT_SYMBOL = "";

    @Override
    public Component parse(String word) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(word);
            String[] parts = word.trim().split(SPLIT_SYMBOL);
            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new Word(components);
    }
}
