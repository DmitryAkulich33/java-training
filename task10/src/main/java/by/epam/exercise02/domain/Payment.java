package by.epam.exercise02.domain;

import java.util.List;

public class Payment {
    private String name;
    private int cost;
    private List<Product> productsList;

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

    public Payment() {

    }

    public Payment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        String line = "The payment's name is " + name + "\n====================\n";
        int i = 1;
        for (Product product : productsList) {
            line = line + i + ". " + product + "\n";
            i++;
        }
        line = line + "====================\nTotal cost = " + cost + " BYN\n====================";
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (cost != payment.cost) return false;
        if (name != null ? !name.equals(payment.name) : payment.name != null) return false;
        return productsList != null ? productsList.equals(payment.productsList) : payment.productsList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + (productsList != null ? productsList.hashCode() : 0);
        return result;
    }
}
