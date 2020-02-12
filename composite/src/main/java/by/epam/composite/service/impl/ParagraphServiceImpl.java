package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;
import by.epam.composite.service.ParagraphService;
import by.epam.composite.service.comparator.SizeComparator;
import by.epam.composite.service.copier.ComponentCopy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphServiceImpl implements ParagraphService {
    public Component sort(Component original) {
        ComponentCopy componentCopy = new ComponentCopy();
        Component copy = componentCopy.copyComponent(original);
        SizeComparator sizeComparator = new SizeComparator();
        List<Component> newListParagraphs = new ArrayList<>();
        for(int i = 0; i < copy.calcSize(); i++){
            newListParagraphs.add(copy.getChild(i));
        }
        newListParagraphs.sort(sizeComparator);
        return new Text(newListParagraphs);
    }
}
