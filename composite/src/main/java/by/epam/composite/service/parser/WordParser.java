package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Word;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {
    private static Logger log = LogManager.getLogger(WordParser.class.getName());

    private static final String SPLIT_SYMBOL = "";

    @Override
    public Component parse(String word) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            log.info("Word division...");
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
