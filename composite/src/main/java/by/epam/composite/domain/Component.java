package by.epam.composite.domain;


public interface Component {
    String operation();

    Component getChild(int index);

    void add(Component component);

    void remove(Component component);

    int calcSize();
}
