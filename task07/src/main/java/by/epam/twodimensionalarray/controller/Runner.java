package by.epam.twodimensionalarray.controller;

import by.epam.twodimensionalarray.domain.DoubleMatrix;
import by.epam.twodimensionalarray.domain.IntMatrix;
import by.epam.twodimensionalarray.domain.exception.MatrixException;
import by.epam.twodimensionalarray.service.MatrixCreator;
import by.epam.twodimensionalarray.service.MatrixService;
import by.epam.twodimensionalarray.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        MatrixCreator matrixCreator = new MatrixCreator();
        MatrixService matrixService = new MatrixService();
        while (true) {
            viewer.printMenu();
            switch (viewer.returnNumber()) {
                case 0:
                    return;
                case 1:
                    try {
                        viewer.printMatrixSizes();
                        IntMatrix intMatrix1 = new IntMatrix(viewer.returnNumber(), viewer.returnNumber());
                        viewer.printMatrixSizes();
                        IntMatrix intMatrix2 = new IntMatrix(viewer.returnNumber(), viewer.returnNumber());
                        viewer.printValues();
                        matrixCreator.fillRandomized(intMatrix1, viewer.returnNumber(), viewer.returnNumber());
                        viewer.printValues();
                        matrixCreator.fillRandomized(intMatrix2, viewer.returnNumber(), viewer.returnNumber());
                        viewer.printIntMatrix(intMatrix1);
                        viewer.printIntMatrix(intMatrix2);
                        viewer.printAnswer();
                        viewer.printIntMatrix(matrixService.multiply(intMatrix1, intMatrix2));
                        viewer.printReturnToMenu();
                        break;
                    } catch (MatrixException ex) {
                        System.out.println("Error of creating matrix. Please try again to choose necessary task");
                        break;
                    }
                case 2:
                    try {
                        viewer.printMatrixSizes();
                        IntMatrix intMatrix = new IntMatrix(viewer.returnNumber(), viewer.returnNumber());
                        viewer.printValues();
                        matrixCreator.fillRandomized(intMatrix, viewer.returnNumber(), viewer.returnNumber());
                        viewer.printIntMatrix(intMatrix);
                        viewer.printNumber();
                        int number = viewer.returnNumber();
                        viewer.printAnswer();
                        viewer.printNumberCount(number, matrixService.findNumberCount(intMatrix, number));
                        viewer.printReturnToMenu();
                        break;
                    } catch (MatrixException ex) {
                        System.out.println("Error of creating matrix. Please try again to choose necessary task");
                        break;
                    }
                case 3:
                    try {
                        viewer.printSquareMatrixSizes();
                        int size = viewer.returnNumber();
                        IntMatrix intMatrix = new IntMatrix(size, size);
                        matrixCreator.fillMatrixByCondition(intMatrix);
                        viewer.printAnswer();
                        viewer.printIntMatrix(intMatrix);
                        viewer.printReturnToMenu();
                        break;
                    } catch (MatrixException ex) {
                        System.out.println("Error of creating matrix. Please try again to choose necessary task");
                        break;
                    }
                case 4:
                    try {
                        viewer.printSquareMatrixSizes();
                        int size = viewer.returnNumber();
                        DoubleMatrix doubleMatrix = new DoubleMatrix(size, size);
                        matrixCreator.fillMatrixByRule(doubleMatrix);
                        viewer.printDoubleMatrix(doubleMatrix);
                        viewer.printAnswer();
                        viewer.printPositiveNumbersCount(matrixService.findAmountOfPositiveNumbers(doubleMatrix));
                        viewer.printReturnToMenu();
                        break;
                    } catch (MatrixException ex) {
                        System.out.println("Error of creating matrix. Please try again to choose necessary task");
                        break;
                    }
                case 5:
                    try {
                        viewer.printMatrixSizes();
                        IntMatrix intMatrix = new IntMatrix(viewer.returnNumber(), viewer.returnNumber());
                        viewer.printValues();
                        matrixCreator.fillRandomized(intMatrix, viewer.returnNumber(), viewer.returnNumber());
                        viewer.printIntMatrix(intMatrix);
                        viewer.printAnswer();
                        viewer.printIntMatrix(matrixService.increaseSort(intMatrix));
                        viewer.printIntMatrix(matrixService.decreaseSort(intMatrix));
                        viewer.printReturnToMenu();
                        break;
                    } catch (MatrixException ex) {
                        System.out.println("Error of creating matrix. Please try again to choose necessary task");
                        break;
                    }
                default:
                    System.out.println("The entered number is wrong. Please try again.");
                    break;
            }
        }
    }
}
