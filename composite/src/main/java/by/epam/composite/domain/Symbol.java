package by.epam.composite.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements Component {
    private static Logger log = LogManager.getLogger(Symbol.class.getName());

    private String symbol;

    @Override
    public int calcSize() {
        log.info("Symbol's size is calculated.");
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

    @Override
    public String operation() {
        log.info("Compile symbol");
        return symbol;
    }

    @Override
    public Component getChild(int index) {
        log.error("Symbol is not divided into components");
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Component component) {
        log.error("Symbol is not divided into components");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        log.error("Symbol is not divided into components");
        throw new UnsupportedOperationException();
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
