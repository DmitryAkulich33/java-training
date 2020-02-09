package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.service.ParagraphService;
import by.epam.composite.service.comparator.SizeComparator;
import by.epam.composite.service.copier.ComponentCopy;

public class ParagraphServiceImpl implements ParagraphService {
    public Component sort(Component original) {
        ComponentCopy componentCopy = new ComponentCopy();
        Component copy = componentCopy.copyComponent(original);
        SizeComparator sizeComparator = new SizeComparator();
        copy.getComponents().sort(sizeComparator);
        return copy;
    }
}
