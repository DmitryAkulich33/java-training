package by.epam.composite.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class TextComposite implements Component {
    public List<Component> components = new ArrayList<>();

    public abstract Object getChild(int index);

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract List<Component> getComponents();


}
