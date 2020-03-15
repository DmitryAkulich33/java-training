package by.epam.xml.view;

import by.epam.xml.domain.Order;

import java.util.Scanner;
import java.util.Set;

public class Viewer {
    private Scanner scanner = new Scanner(System.in);

    public void printOrders(Set<Order> orders) {
        if (orders != null) {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public String printCommandMenu() {
        System.out.println("Write \"stax\" if you want to parse a file using the stax method");
        System.out.println("Write \"sax\" if you want to parse a file using the sax method");
        System.out.println("Write \"dom\" if you want to parse a file using the dom method");
        System.out.println("Write \"0\" if you want to exit");
        return scanner.nextLine();
    }
    public void printNewAttempt() {
        System.out.println("\nPlease try again\n");
    }
}
