package by.epam.exercise04.service;

import by.epam.exercise04.domain.Client;

import java.util.Comparator;

public class BankComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
