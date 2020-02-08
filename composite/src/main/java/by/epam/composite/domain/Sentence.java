package by.epam.composite.domain;

import java.util.List;

public class Sentence extends TextComposite {
    private List<Component> components;
    private final ComponentType componentType = ComponentType.SENTENCE;
    private String delimiter;

    public Sentence(List<Component> components) {
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
    public Object getChild(int index) {
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
        return stringBuilder.toString() + delimiter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString() + delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (components != null ? !components.equals(sentence.components) : sentence.components != null) return false;
        if (componentType != sentence.componentType) return false;
        return delimiter != null ? delimiter.equals(sentence.delimiter) : sentence.delimiter == null;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + componentType.hashCode();
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        return result;
    }
}
