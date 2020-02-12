package by.epam.composite.domain;

import java.util.List;

public class Symbol implements Component {
    private String symbol;
    private final ComponentType componentType = ComponentType.SYMBOL;
    private int size;

    @Override
    public int calcSize() {
        return 1;
    }

    public Symbol() {
    }

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String operation() {
        return symbol;
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol != null ? symbol.equals(symbol1.symbol) : symbol1.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }
}
