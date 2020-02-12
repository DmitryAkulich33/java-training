package by.epam.composite.domain;

import java.util.List;

public class Word implements Component {
    private List<Component> components;
    private final ComponentType componentType = ComponentType.WORD;

    @Override
    public int calcSize() {
        return components.size();
    }

    public Word() {
    }

    public Word(List<Component> components) {
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
            stringBuilder.append(component.operation());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (components != null ? !components.equals(word.components) : word.components != null) return false;
        return componentType == word.componentType;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + componentType.hashCode();
        return result;
    }
}
