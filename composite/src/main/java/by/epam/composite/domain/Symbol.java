package by.epam.composite.domain;

public class Symbol implements Component {
    private char value;

    public Symbol() {
    }

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return value == symbol.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(getValue());
    }
}
