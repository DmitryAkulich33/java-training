package by.epam.exercise02.domain;

import java.util.List;

public class ShoppingList {
    private String ownerName;
    private List<String> shoppingList;

    public ShoppingList() {
    }

    public ShoppingList(String ownerName, List<String> shoppingList) {
        this.ownerName = ownerName;
        this.shoppingList = shoppingList;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<String> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<String> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Shop is " + ownerName + " :" + "\n");
        for (String string : shoppingList) {
            line.append(string).append("\n");
        }
        return line.toString();
    }
}
