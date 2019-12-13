package by.epam.exercise33.runner;

public class Main {
    public static void main(String[] args) {
        char symbol = 'B';
        printCurrentCharacter(symbol);
        printPreviousCharacter(symbol);
        printNextCharacter(symbol);
    }

    public static int findCurrentSymbolIndex(char symbol) {
        return (int) symbol;
    }

    public static int findPreviousSymbolIndex(char symbol) {
        return (int) symbol - 1;
    }

    public static char findPreviousSymbol(char symbol) {
        return (char) findPreviousSymbolIndex(symbol);
    }

    public static int findNextSymbolIndex(char symbol) {
        return (int) symbol + 1;
    }

    public static char findNextSymbol(char symbol) {
        return (char) findNextSymbolIndex(symbol);
    }

    public static void printCurrentCharacter(char symbol) {
        System.out.println("Character is " + symbol + ", index number is " + findCurrentSymbolIndex(symbol));
    }

    public static void printPreviousCharacter(char symbol) {
        System.out.println("Previous character is " + findPreviousSymbol(symbol) +
                ", index number is " + findPreviousSymbolIndex(symbol));
    }

    public static void printNextCharacter(char symbol) {
        System.out.println("Previous character is " + findNextSymbol(symbol) +
                ", index number is " + findNextSymbolIndex(symbol));
    }
}
