package by.epam.seasons.runner;

import by.epam.seasons.domain.Seasons;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of month:");
        int month = scanner.nextInt();
        scanner.close();
        findSeason(month);
    }

    public static void findSeason(int month){
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println(Seasons.WINTER.getValue());
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(Seasons.SPRING.getValue());
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(Seasons.SUMMER.getValue());
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(Seasons.AUTUMN.getValue());
                break;
            default:
                throw new RuntimeException("The number of month is wrong.");
        }
    }
}
