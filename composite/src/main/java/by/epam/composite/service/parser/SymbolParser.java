package by.epam.composite.service.parser;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Symbol;

public class SymbolParser extends AbstractParser {
    @Override
    public Component parse(String symbol) {
        return new Symbol(symbol);
    }
}
