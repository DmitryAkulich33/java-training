package by.epam.exercise01.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Viewer {
    private Scanner scanner = new Scanner(System.in);

    public String returnFileName() {
        System.out.println("Enter the file's name");
        return scanner.nextLine();
    }

    public String returnNewFileName() {
        System.out.println("Enter new file's name");
        return scanner.nextLine();
    }

    public String returnFileType() {
        System.out.println("Enter the file's type (txt - for example)");
        return scanner.nextLine();
    }

    public String returnNewFileType() {
        System.out.println("Enter new file's type (txt - for example)");
        return scanner.nextLine();
    }

    public String printCreatingDirectory() {
        System.out.println("Enter the path to create directory.");
        return scanner.nextLine();
    }

    public List<String> printTextForFile() {
        System.out.println("Write the necessary lines, and at the end write - exit");
        List<String> list = new ArrayList<>();
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("exit")) {
                break;
            }
            list.add(name);
        }
        return list;
    }

    public void printContent(List<String> content) {
        for (String line : content) {
            System.out.println(line);
        }
    }

    public String printCommandMenu() {
        System.out.println("Write \"Create\" if you want to create a new file");
        System.out.println("Write \"Rename\" if you want to rename file");
        System.out.println("Write \"Add\" if you want to add some information in file");
        System.out.println("Write \"Moreadd\" if you want to add more information in file");
        System.out.println("Write \"Print\" if you want to show information from file");
        System.out.println("Write \"Delete\" if you want to delete file");
        System.out.println("Write \"0\" if you want to exit");
        return scanner.nextLine();
    }

    public void printNewAttempt() {
        System.out.println("\nPlease try again\n");
    }

    public void printRequest(String line) {
        System.out.println(line);
    }
}
