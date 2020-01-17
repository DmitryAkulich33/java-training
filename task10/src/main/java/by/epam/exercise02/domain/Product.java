package by.epam.exercise02.domain;

public class Product {
    private String productName;
    private int productCost;

    public Product() {
        productName = "";
        productCost = 0;
    }

    public Product(String productName, int productCost) {
        this.productName = productName;
        this.productCost = productCost;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }

    @Override
    public String toString() {
        return productName + " " + productCost + " BYN";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productCost != product.productCost) return false;
        return productName != null ? productName.equals(product.productName) : product.productName == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + productCost;
        return result;
    }
}
