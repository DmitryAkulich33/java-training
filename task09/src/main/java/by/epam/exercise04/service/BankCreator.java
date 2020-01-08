package by.epam.exercise04.service;

import by.epam.exercise04.domain.Bank;
import by.epam.exercise04.domain.Bill;
import by.epam.exercise04.domain.Client;
import by.epam.exercise04.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankCreator {
    public Bank returnBank(List<String> linesFromFile, String name) {
        List<String> names = findListClientsNames(linesFromFile);
        List<Client> clients = new ArrayList<>();
        int sizeNames = names.size();
        int sizeLines = linesFromFile.size();
        for (int i = 0; i < sizeNames; i++) {
            List<Bill> bills = new ArrayList<>();
            for (int j = 0; j < sizeLines; j++) {
                String[] array = linesFromFile.get(j).split("\\s");
                if (array[0].equals(names.get(i))) {
                    String number = array[1];
                    int balance = Integer.parseInt(array[2]);
                    bills.add(new Bill(number, balance, array[3]));
                }
            }
            clients.add(new Client(names.get(i), bills));
        }
        return new Bank(name, clients);
    }


    public List<String> findListClientsNames(List<String> linesFromFile) throws EmptyListException {
        if (linesFromFile.isEmpty()) {
            throw new EmptyListException("List from file is empty");
        }
        List<String> names = new ArrayList<>();
        Set<String> sortedNames = new HashSet<>();
        for (String line : linesFromFile) {
            String[] array = line.split("\\s");
            sortedNames.add(array[0]);
        }
        names.addAll(sortedNames);
        return names;
    }
}
