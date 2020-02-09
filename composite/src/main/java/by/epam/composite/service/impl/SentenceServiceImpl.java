package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.ComponentType;
import by.epam.composite.service.comparator.SizeComparator;
import by.epam.composite.service.copier.ComponentCopy;

public class SentenceServiceImpl {
    public Component sort(Component original) {
        ComponentCopy componentCopy = new ComponentCopy();
        Component copy = componentCopy.copyComponent(original);
        SizeComparator sizeComparator = new SizeComparator();
        for(int i = 0; i < copy.getSize(); i ++) {
            for (int j = 0; j < copy.getChild(i).getSize(); j++) {
                copy.getChild(i).getChild(j).getComponents().sort(sizeComparator);
            }
        }
        return copy;
    }

}
