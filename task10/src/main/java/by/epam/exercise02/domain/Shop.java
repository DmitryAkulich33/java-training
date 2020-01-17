package by.epam.exercise02.domain;

import java.util.List;

public class Shop {
    private String name;
    private List<Product> products;

    public Shop() {
    }

    public Shop(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        return products != null ? products.equals(shop.products) : shop.products == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Shop is " + name + " :" + "\n");
        for (Product product : products) {
            line.append(product.getProductName()).append(" ").append(product.getProductCost()).append(" BYN\n");

        }
        return line.toString();
    }
}
