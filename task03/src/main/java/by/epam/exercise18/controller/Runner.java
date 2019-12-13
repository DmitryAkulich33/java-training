package by.epam.exercise18.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int length;
        double e;
        double number;
        double sum = 0;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of number series:");
        length = scanner.nextInt();
        System.out.println("Enter e:");
        e = scanner.nextDouble();
        scanner.close();
        for(int i = 1; i < length; i++){
            number = Math.pow(-1, i - 1) / i;
            if (Math.abs(number) >= e){
                sum = sum + number;
                flag = true;
            }
        }
        if(flag){
            System.out.println("sum = " + sum);
        } else {
            System.out.println("There is no solution.");
        }
    }
}
