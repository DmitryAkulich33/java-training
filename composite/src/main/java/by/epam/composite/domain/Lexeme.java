package by.epam.composite.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Lexeme implements Component {
    private static Logger log = LogManager.getLogger(Lexeme.class.getName());

    private List<Component> components;
    private String delimiter;

    @Override
    public int calcSize() {
        int size = 0;
        for (Component component : components) {
            if (component.getClass() == Word.class) {
                size = size + component.calcSize();
            }
        }
        log.info("Lexeme's size is calculated.");
        return size;
    }

    public Lexeme() {
    }

    public Lexeme(List<Component> components) {
        this.components = components;
        delimiter = " ";
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) {
        log.info("Get word.");
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        log.info("Add word in list.");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        log.info("Remove word from list.");
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.operation());
        }
        log.info("Compile lexeme");
        return stringBuilder.toString() + delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lexeme lexeme = (Lexeme) o;

        if (components != null ? !components.equals(lexeme.components) : lexeme.components != null) return false;
        return delimiter != null ? delimiter.equals(lexeme.delimiter) : lexeme.delimiter == null;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        return result;
    }
}
