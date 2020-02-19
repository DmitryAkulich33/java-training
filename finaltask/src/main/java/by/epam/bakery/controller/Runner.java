package by.epam.bakery.controller;

import by.epam.bakery.dao.ClientDAO;
import by.epam.bakery.dao.PieDAO;
import by.epam.bakery.domain.Client;
import by.epam.bakery.domain.Pie;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        PieDAO pieDAO = new PieDAO();
        List<Client> clients = clientDAO.findAll();
        for(Client client : clients) {
            System.out.println(client);
        }
        System.out.println();
        List<Pie> pies = pieDAO.findAll();
        for(Pie pie : pies) {
            System.out.println(pie);
        }
    }
}
