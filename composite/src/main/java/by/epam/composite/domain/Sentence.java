package by.epam.composite.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Sentence implements Component {
    private static Logger log = LogManager.getLogger(Sentence.class.getName());

    private List<Component> components;

    @Override
    public int calcSize() {
        log.info("Sentence's size is calculated.");
        return components.size();
    }

    public Sentence() {
    }

    public Sentence(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) {
        log.info("Get lexeme.");
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        log.info("Add lexeme in list.");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        log.info("Remove lexeme from list.");
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.operation());
        }
        log.info("Compile sentence");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        return components != null ? components.equals(sentence.components) : sentence.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
