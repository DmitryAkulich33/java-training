package by.epam.composite.service.copier;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;

import java.util.ArrayList;
import java.util.List;

public class ComponentCopy {
    public Component copyComponent(Component original) {
        List<Component> copy = new ArrayList<>();
        int length = original.calcSize();
        for(int i = 0; i < length; i++){
            copy.add(original.getChild(i));
        }
        return new Text(copy);

    }
}
