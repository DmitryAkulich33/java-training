package by.epam.composite.domain;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component {
    private List<Component> components = new ArrayList<>();
    private final ComponentType componentType = ComponentType.TEXT;

    public Text() {
    }

    public Text(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (components != null ? !components.equals(text.components) : text.components != null) return false;
        return componentType == text.componentType;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + componentType.hashCode();
        return result;
    }
}
