package by.epam.composite.domain;

import java.util.List;

public interface Component {
    String operation();

    Component getChild(int index);

    void add(Component component);

    void remove(Component component);

    ComponentType getComponentType();

//    List<Component> getComponents();

    int calcSize();
}
