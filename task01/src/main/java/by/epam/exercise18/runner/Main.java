package by.epam.exercise18.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve(3.0);
        solve(0.0);
    }

    public static void solve (double cubeEdge){
        if(cubeEdge > 0) {
            double faceArea = findFaceArea(cubeEdge);
            double cubeArea = findCubeArea(cubeEdge);
            double cubeVolume = findCubeVolume(cubeEdge);
            printCorrectData(faceArea, cubeArea, cubeVolume);
        } else {
            printUnCorrectData();
        }
    }

    public static double findFaceArea(double cubeEdge) {
        return cubeEdge * cubeEdge;
    }

    public static double findCubeArea(double cubeEdge) {
        return cubeEdge * cubeEdge * 6;
    }

    public static double findCubeVolume(double cubeEdge) {
        return cubeEdge * cubeEdge * cubeEdge;
    }

    public static void printCorrectData(double faceArea, double cubeArea, double cubeVolume) {
        System.out.println("The face area of the cube is " + faceArea);
        System.out.println("The area of the cube is " + cubeArea);
        System.out.println("The volume of the cube is " + cubeVolume);
    }

    public static void printUnCorrectData() {
        System.out.println("The data is incorrect");
    }





}
