package by.epam.composite.domain;

import java.util.List;

public class TokenLeaf implements Component{
    private final String value;
    private final TypeLeaf type;

    private TokenLeaf(String value, TypeLeaf type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String getValue() {
        return value;
    }

    public TypeLeaf getType() {
        return type;
    }

    public static TokenLeaf newWord(String value) {
        return new TokenLeaf(value, TypeLeaf.WORD);
    }

    public static TokenLeaf newMark(String value) {
        return new TokenLeaf(value, TypeLeaf.MARK);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getComponents() {
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(type != TypeLeaf.MARK) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(value);
        return stringBuilder.toString();
    }
}
