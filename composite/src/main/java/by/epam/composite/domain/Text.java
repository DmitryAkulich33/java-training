package by.epam.composite.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component {
    private static Logger log = LogManager.getLogger(Text.class.getName());

    private List<Component> components = new ArrayList<>();

    public Text() {
    }

    @Override
    public int calcSize() {
        log.info("Text's size is calculated.");
        return components.size();
    }

    public Text(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) {
        log.info("Get paragraph.");
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        log.info("Add paragraph in list.");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        log.info("Remove paragraph from list.");
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.operation());
        }
        log.info("Compile text");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        return components != null ? components.equals(text.components) : text.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
