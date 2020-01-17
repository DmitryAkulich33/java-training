package by.epam.exercise02.service.comparator;


import by.epam.exercise02.domain.Product;

import java.util.Comparator;

public class DecreaseCostComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getProductCost(), o1.getProductCost());
    }
}

