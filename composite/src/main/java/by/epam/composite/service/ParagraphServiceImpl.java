package by.epam.composite.service;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.ComponentType;
import by.epam.composite.domain.Paragraph;
import by.epam.composite.domain.Text;
import by.epam.composite.service.comparator.ParagraphComparator;
import by.epam.composite.service.copier.ComponentCopy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphServiceImpl {
    public Component sort(Component original) {
        ComponentCopy componentCopy = new ComponentCopy();
        Component copy = componentCopy.copyComponent(original);
        ParagraphComparator paragraphComparator = new ParagraphComparator();
        List<Component> components = copy.getComponents();
        components.sort(paragraphComparator);
        for(Component c : components) {
            System.out.println(c.operation());
        }
        for(int i = 0; i < copy.getComponents().size(); i++){
            copy.remove(copy.getChild(i));
            i--;
        }
        for(int i = 0; i < components.size(); i++){
            copy.add(components.get(i));
            System.out.println(i);
        }
        return copy;

    }
}
