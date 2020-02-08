package by.epam.composite.service.copier;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComponentCopy {
    public Component copyComponent(Component original){
        List<Component> copy = new ArrayList<>(original.getComponents());
        return new Text(copy);
    }
}
