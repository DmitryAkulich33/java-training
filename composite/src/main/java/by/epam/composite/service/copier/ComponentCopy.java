package by.epam.composite.service.copier;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;

import java.util.ArrayList;
import java.util.List;

public class ComponentCopy {
    public Component copyComponent(Component original) {
        List<Component> copy = new ArrayList<>(original.getComponents());
        return new Text(copy);
    }
}
