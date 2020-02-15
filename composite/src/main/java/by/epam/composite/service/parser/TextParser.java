package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser {
    private static Logger log = LogManager.getLogger(TextParser.class.getName());
    private static final String SPLIT_TEXT_PARAGRAPH = "\t|( ){4}";

    @Override
    public Component parse(String text) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            log.info("Text division...");
            getSuccessor().parse(text);
            String[] parts = text.trim().split(SPLIT_TEXT_PARAGRAPH);
            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new Text(components);
    }
}
