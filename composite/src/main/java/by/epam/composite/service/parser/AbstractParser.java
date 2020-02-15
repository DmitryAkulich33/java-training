package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;

public abstract class AbstractParser {
    private AbstractParser successor;

    public AbstractParser getSuccessor() {
        return successor;
    }

    public void setSuccessor(AbstractParser successor) {
        this.successor = successor;
    }

    public boolean checkNextSuccessor() {
        return getSuccessor() != null;
    }

    public abstract Component parse(String input);
}

