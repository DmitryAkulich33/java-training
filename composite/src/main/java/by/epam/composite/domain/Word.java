package by.epam.composite.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Word implements Component {
    private static Logger log = LogManager.getLogger(Word.class.getName());

    private List<Component> components;

    @Override
    public int calcSize() {
        log.info("Word's size is calculated.");
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

    @Override
    public Component getChild(int index) {
        log.info("Get symbol.");
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        log.info("Add symbol in list.");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        log.info("Remove symbol from list.");
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.operation());
        }
        log.info("Compile word");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return components != null ? components.equals(word.components) : word.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
