package by.epam.exercise04.domain;

import java.util.List;

public class Bank {
    private String name;
    private List<Client> clients;

    public Bank(String name, List<Client> clients) {
        this.name = name;
        this.clients = clients;
    }

    public Bank() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        String line = "Bank \"" + name + "\", clients:\n";
        for (Client client : clients) {
            line = line + client;
        }
        return line;
    }
}
