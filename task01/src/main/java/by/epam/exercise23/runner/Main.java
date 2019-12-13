package by.epam.exercise23.runner;

public class Main {
    public static void main(String[] args) {
        calculateRingArea(3, 2);
        calculateRingArea(2, 3);
    }

    public static void calculateRingArea(double outerRadius, double innerRadius) {
        if (outerRadius > innerRadius && outerRadius > 0 && innerRadius > 0) {
            double ringArea = (Math.PI * outerRadius * outerRadius) - (Math.PI * innerRadius * innerRadius);
            printCorrectData(ringArea);
        } else {
            printUnCorrectData();
        }
    }

    public static void printCorrectData(double ringArea) {
        System.out.println("The ring area is: " + ringArea);
    }

    public static void printUnCorrectData() {
        System.out.println("The data is incorrect");
    }
}
