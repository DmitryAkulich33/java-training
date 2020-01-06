package by.epam.exercise04.view;

import by.epam.exercise04.domain.Client;

import java.util.List;

public class Viewer {

    public void showSumAllBills(int sum) {
        System.out.println("The sum of all bills is " + sum);
    }

    public void showSumPositiveBills(int sum) {
        System.out.println("The sum of positive bills is " + sum);
    }

    public void showSumNegativeBills(int sum) {
        System.out.println("The sum of negative bills is " + sum);
    }

    public void showSortClientListByName(List<Client> clients) {
        System.out.println("Sorted list of clients by name:");
        for (Client client : clients) {
            System.out.println(client.getName());
        }
    }
}
