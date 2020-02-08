package by.epam.composite.domain;

import java.util.List;

public class Lexeme implements Component {
    private List<Component> components;
    private final ComponentType componentType = ComponentType.LEXEME;
    private String delimiter;

    public Lexeme(List<Component> components) {
        this.components = components;
        delimiter = " ";
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
            stringBuilder.append(component.operation());
        }
        return stringBuilder.toString() + delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lexeme lexeme = (Lexeme) o;

        if (components != null ? !components.equals(lexeme.components) : lexeme.components != null) return false;
        if (componentType != lexeme.componentType) return false;
        return delimiter != null ? delimiter.equals(lexeme.delimiter) : lexeme.delimiter == null;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + componentType.hashCode();
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        return result;
    }
}
