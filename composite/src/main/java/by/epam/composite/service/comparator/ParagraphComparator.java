package by.epam.composite.service.comparator;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Paragraph;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return Integer.compare(o1.getComponents().size(), o2.getComponents().size());
    }
}
