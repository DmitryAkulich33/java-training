package by.epam.composite.service.parser;

import by.epam.composite.domain.Composite;
import by.epam.composite.service.exception.CompositeParseException;

public abstract class AbstractParser {
    protected AbstractParser successor;

    public void setSuccessor (AbstractParser successor){
        this.successor = successor;
    }

    public abstract Composite parse (String input) throws CompositeParseException;
}
