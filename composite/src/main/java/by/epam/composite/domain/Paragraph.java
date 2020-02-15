package by.epam.composite.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Paragraph implements Component {
    private static Logger log = LogManager.getLogger(Paragraph.class.getName());

    private List<Component> components;
    private String delimiter;

    @Override
    public int calcSize() {
        log.info("Paragraph's size is calculated.");
        return components.size();
    }

    public Paragraph() {
    }

    public Paragraph(List<Component> components) {
        this.components = components;
        delimiter = "\n";
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) {
        log.info("Get sentence.");
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        log.info("Add sentence in list.");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        log.info("Remove sentence from list.");
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (Component component : components) {
            stringBuilder.append(component.operation());
        }
        log.info("Compile paragraph");
        return stringBuilder.toString() + delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (components != null ? !components.equals(paragraph.components) : paragraph.components != null) return false;
        return delimiter != null ? delimiter.equals(paragraph.delimiter) : paragraph.delimiter == null;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        return result;
    }
}
