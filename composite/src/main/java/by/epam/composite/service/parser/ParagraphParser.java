package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Paragraph;
import by.epam.composite.domain.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends AbstractParser {
    private static final String SPLIT_SENTENCE = "(?<=[.!?])( )";

    @Override
    public Component parse(String paragraph) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
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
