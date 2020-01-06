package by.epam.exercise04.controller;

import by.epam.exercise04.dao.LinesReader;
import by.epam.exercise04.dao.LinesWriter;
import by.epam.exercise04.dao.exception.StreamNotReadingException;
import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.Bank;
import by.epam.exercise04.domain.Constants;
import by.epam.exercise04.service.BankCreator;
import by.epam.exercise04.service.BankFinder;
import by.epam.exercise04.service.BankSorter;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.view.Viewer;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        LinesWriter linesWriter = new LinesWriter();
        BankCreator bankCreator = new BankCreator();
        BankSorter bankSorter = new BankSorter();
        Viewer viewer = new Viewer();
        BankFinder bankFinder = new BankFinder();
        Bank bank = null;
        try {
            List<String> lines = linesReader.returnListCitiesFromFile(Constants.PATH_CLIENTS_DATA);
            bank = bankCreator.returnBank(lines, Constants.BANK_NAME);
            linesWriter.writeBankInformationInFile(bank, Constants.PATH_BANK_INFO);

        } catch (StreamNotReadingException | StreamNotWritingException | EmptyListException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        viewer.showSumAllBills(bankFinder.findSumAllBills(bank));
        viewer.showSumPositiveBills(bankFinder.findSumPositiveBills(bank));
        viewer.showSumNegativeBills(bankFinder.findSumNegativeBills(bank));
        viewer.showSortClientListByName(bankSorter.sortByClientNames(bank.getClients()));
    }
}
