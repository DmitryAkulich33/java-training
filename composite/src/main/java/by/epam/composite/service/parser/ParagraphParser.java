package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Paragraph;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {
    private static Logger log = LogManager.getLogger(ParagraphParser.class.getName());

    private static final String SPLIT_SENTENCE = "(?<=[.!?])( )";


    @Override
    public Component parse(String paragraph) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            log.info("Paragraph division...");
            getSuccessor().parse(paragraph);
            String[] parts = paragraph.trim().split(SPLIT_SENTENCE);
            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new Paragraph(components);
    }
}
