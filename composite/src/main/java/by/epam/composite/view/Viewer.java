package by.epam.composite.view;

import by.epam.composite.domain.Component;

import java.util.Scanner;

public class Viewer {
    private Scanner scanner = new Scanner(System.in);

    public String printCommandMenu() {
        System.out.println("Write \"Show\" if you want to compile text and see it from file: src\\main\\resources\\text.txt");
        System.out.println("Write \"Paragraph\" if you want to sort paragraphs by number of sentences, see it and write to file: src\\main\\resources\\paragraph.txt");
        System.out.println("Write \"Word\" if you want to sort words in a sentence by length, see it and write to file: src\\main\\resources\\word.txt");
        System.out.println("Write \"Lexeme\" if you want to sort lexeme in text in descending order of occurrences of a given character, see it and write to file: src\\main\\resources\\lexeme.txt");
        System.out.println("Write \"0\" if you want to exit");
        return scanner.nextLine();
    }

    public void printNewAttempt() {
        System.out.println("\nPlease try again\n");
    }

    public void print(Component component){
        System.out.println(component.operation());
    }

    public void print(String line){
        System.out.println(line);
    }

    public void printResponse(String line) {
        System.out.println(line);
    }
}
