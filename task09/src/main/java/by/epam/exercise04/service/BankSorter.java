package by.epam.exercise04.service;

import by.epam.exercise04.domain.Client;

import java.util.List;

public class BankSorter {
    public List<Client> sortByClientNames(List<Client> clients) {
        BankComparator bankComparator = new BankComparator();
        clients.sort(bankComparator);
        return clients;
    }
}
