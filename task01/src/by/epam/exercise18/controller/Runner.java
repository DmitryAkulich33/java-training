package by.epam.exercise18.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double cubeEdge;
        double faceArea;
        double cubeArea;
        double cubeVolume;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the cube edge:");
        cubeEdge = scanner.nextDouble();
        scanner.close();
        faceArea = cubeEdge * cubeEdge;
        cubeArea = faceArea * 6;
        cubeVolume = faceArea * cubeEdge;
        if (cubeEdge > 0) {
            System.out.println("The face area of the cube is " + faceArea);
            System.out.println("The area of the cube is " + cubeArea);
            System.out.println("The volume of the cube is " + cubeVolume);
        } else {
            System.out.println("The entered data is incorrect.");
        }
    }
}
