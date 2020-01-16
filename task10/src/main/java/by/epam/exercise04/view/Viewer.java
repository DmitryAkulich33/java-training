package by.epam.exercise04.view;

import by.epam.exercise04.domain.Treasure;

import java.util.List;
import java.util.Scanner;

public class Viewer {
    private Scanner scanner = new Scanner(System.in);

    public void printTreasure(List<Treasure> treasures) {
        System.out.println("Treasures:\n========================================");
        int i = 1;
        for (Treasure treasure : treasures) {
            System.out.println(i + " " + treasure);
            i++;
        }
        System.out.println("========================================");
    }

    public int returnNumber() {
        System.out.println("Enter the sum");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered line is not a number. Please try again");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void printTreasure(Treasure treasure) {
        System.out.println(treasure);
    }

    public String printCommandMenu() {
        System.out.println("Write \"Take\" if you want to take some treasures for necessary sum");
        System.out.println("Write \"Save\" if you want to save treasure from Dragon's cave in file");
        System.out.println("Write \"Show\" if you want to print treasure from Dragon's cave ");
        System.out.println("Write \"CHOOSE\" if you want to choose the most expensive treasure");
        System.out.println("Write \"0\" if you want to exit");
        return scanner.nextLine();

    }

    public void printRequest(String line) {
        System.out.println(line);
    }

    public void printNewAttempt() {
        System.out.println("\nPlease try again\n");
    }
}
