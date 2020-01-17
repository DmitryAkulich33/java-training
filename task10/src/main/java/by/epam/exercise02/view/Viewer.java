package by.epam.exercise02.view;

import by.epam.exercise02.domain.Product;
import by.epam.exercise02.domain.Shop;

import java.util.Scanner;

public class Viewer {
    private Scanner scanner = new Scanner(System.in);

    public void printProductForSale(Shop shop) {
        System.out.println("Shop is " + shop.getName() + ", products for sale:");
        for (Product product : shop.getProducts()) {
            System.out.printf("%-10s %7s" + " BYN\n", product.getProductName(), product.getProductCost());
        }
        System.out.println("Please, write through the space on the next line the name of the products from the list you want to buy:");

    }

    public String returnLine() {
        return scanner.nextLine();
    }

    public void printCommandMenu() {
        System.out.println("Write \"Standard\" if you want create standard bill");
        System.out.println("Write \"Increase\" if you want increasing by cost bill");
        System.out.println("Write \"Decrease\" if you want decreasing by cost bill");
        System.out.println("Write \"0\" if you want to exit");
    }

    public void printRequest(String request) {
        System.out.println(request);
    }

    public void printNewAttempt() {
        System.out.println("\nPlease try again\n");
    }
}
