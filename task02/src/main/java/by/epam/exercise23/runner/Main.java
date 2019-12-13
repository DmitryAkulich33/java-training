package by.epam.exercise23.runner;

public class Main {
    public static void main(String[] args) {
        int day = 28;
        int month = 2;
        findDate(day, month);
    }

    public static void findDate(int day, int month) {
        if (month < 0 || month > 12) {
            printInCorrectData();
        } else if (month == 2) {
            if (day >= 1 && day <= 28) {
                printCorrectData(day, month);
            } else {
                printInCorrectData();
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 1 && day <= 30) {
                printCorrectData(day, month);
            } else {
                printInCorrectData();
            }
        } else {
            if (day >= 1 && day <= 31) {
                printCorrectData(day, month);
            } else {
                printInCorrectData();
            }
        }
    }

    public static void printCorrectData(int day, int month) {
        System.out.println("Month number: " + month);
        System.out.println("Day: " + day);
    }

    public static void printInCorrectData() {
        System.out.println("The date is incorrect");
    }
}
