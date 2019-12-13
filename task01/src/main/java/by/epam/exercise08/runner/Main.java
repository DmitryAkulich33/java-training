package by.epam.exercise08.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        function(1, 2, 3);
        function(0, 2, 3);
    }

    public static void function(double a, double b, double c){
        if (a != 0) {
            double result = ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
            printSolvableTask(result);
        } else {
            printUnSolvableTask();
        }
    }

    public static void printSolvableTask(double result){
        System.out.println("Answer: " + result);
    }

    public static void printUnSolvableTask(){
        System.out.println("Cannot be divided by zero.");
    }


}
