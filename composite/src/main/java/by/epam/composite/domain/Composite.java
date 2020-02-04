package by.epam.composite.domain;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private List<Component> childComponents = new ArrayList<Component>();
    private ComponentType type;

    public Composite() {
    }

    public Composite(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        if (childComponents != null ? !childComponents.equals(composite.childComponents) : composite.childComponents != null)
            return false;
        return type == composite.type;
    }

    @Override
    public int hashCode() {
        int result = childComponents != null ? childComponents.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childComponents.size(); i++){
            Component child = childComponents.get(i);
            switch (child.getType()){
                case PARAGRAPH:
                    sb.append("    ").append(child);
                    if (i != childComponents.size() - 1) {
                        sb.append("\n");
                    }
                    break;
                case SENTENCE:
                case LEXEME:
                    sb.append(child);
                    if (i != childComponents.size() - 1){
                        sb.append(" ");
                    }
                    break;
                case TEXT:
                case LISTING:
                case WORD:
                case SYMBOL:
                    sb.append(child);
                    break;
            }
        }
        return sb.toString();
    }

    public void addChild(Component component){
        childComponents.add(component);
    }

    public void removeChild(Component component){
        childComponents.remove(component);
    }
}
