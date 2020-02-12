package by.epam.composite.service.comparator;

import by.epam.composite.domain.Component;

import java.util.Comparator;

public class SizeComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return Integer.compare(o1.calcSize(), o2.calcSize());
    }
}
