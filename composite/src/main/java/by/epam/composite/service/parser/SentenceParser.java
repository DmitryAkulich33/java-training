package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Sentence;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {
    private static Logger log = LogManager.getLogger(SentenceParser.class.getName());

    private static final String SPLIT_LEXEME = "\\s+";

    @Override
    public Component parse(String sentence) {
        log.info("Sentence division...");
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
}
