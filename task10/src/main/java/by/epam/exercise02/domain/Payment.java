package by.epam.exercise02.domain;

import java.util.List;

public class Payment {
    private String name;
    private int cost;
    private Basket basket;

    public class Basket {
        private List<Product> products;

        public Basket() {
        }

        public Basket(List<Product> products) {
            this.products = products;
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

            Basket basket = (Basket) o;

            return products != null ? products.equals(basket.products) : basket.products == null;
        }

        @Override
        public int hashCode() {
            return products != null ? products.hashCode() : 0;
        }

        @Override
        public String toString() {
            StringBuilder line = new StringBuilder();
            int i = 1;
            for (Product product : products) {
                line.append(i).append(". ").append(product).append("\n");
                i++;
            }
            return line.toString();
        }
    }

    public Payment() {
    }

    public Payment(String name, int cost, Basket basket) {
        this.name = name;
        this.cost = cost;
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (cost != payment.cost) return false;
        if (name != null ? !name.equals(payment.name) : payment.name != null) return false;
        return basket != null ? basket.equals(payment.basket) : payment.basket == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + (basket != null ? basket.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String line = "The payment's name is " + name + "\n====================\n" + basket +
                "====================\nTotal cost = " + cost + " BYN\n====================";
        return line;
    }
}
