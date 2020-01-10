package by.epam.exercise02.service.comparator;

import by.epam.exercise02.domain.Payment;

import java.util.Comparator;

public class DecreaseCostComparator implements Comparator<Payment.Product> {

    @Override
    public int compare(Payment.Product o1, Payment.Product o2) {
        if (o1.getProductCost() == o2.getProductCost()) {
            return 0;
        } else if (o1.getProductCost() < o2.getProductCost()) {
            return 1;
        } else {
            return -1;
        }
    }
}

