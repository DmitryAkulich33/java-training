package by.epam.composite.domain;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components;

    public TextComposite(List<Component> components) {
        this.components = components;
    }

    public TextComposite(){
        components = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }
}
