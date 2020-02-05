package by.epam.composite.domain;

import java.util.List;

public interface Component {
    void add(Component component);

    List<Component> getComponents();

    String getValue();
}
