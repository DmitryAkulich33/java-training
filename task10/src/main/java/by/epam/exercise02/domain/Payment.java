package by.epam.exercise02.domain;

import java.util.List;

public class Payment {
    private String name;
    private int cost;
    private List<Product> productsList;

    public class Product{
        private String productName;
        private int productCost;

        private Product() {
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
            return productName + " " + productCost;
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
        String line = "The payment's number: " + name + "\n";
        for(Product product : productsList){
            line = line + product + "\n";
        }
        return line;
    }
}
