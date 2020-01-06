package by.epam.exercise04.service;

import by.epam.exercise04.domain.Bank;
import by.epam.exercise04.domain.Bill;
import by.epam.exercise04.domain.Client;

public class BankFinder {
    public int findSumAllBills(Bank bank) {
        int sum = 0;
        for (Client client : bank.getClients()) {
            for (Bill bill : client.getBills()) {
                sum = sum + bill.getBalance();
            }
        }
        return sum;
    }

    public int findSumPositiveBills(Bank bank) {
        int sum = 0;
        for (Client client : bank.getClients()) {
            for (Bill bill : client.getBills()) {
                if (bill.getBalance() > 0) {
                    sum = sum + bill.getBalance();
                }
            }
        }
        return sum;
    }

    public int findSumNegativeBills(Bank bank) {
        int sum = 0;
        for (Client client : bank.getClients()) {
            for (Bill bill : client.getBills()) {
                if (bill.getBalance() < 0) {
                    sum = sum + bill.getBalance();
                }
            }
        }
        return sum;
    }
}
