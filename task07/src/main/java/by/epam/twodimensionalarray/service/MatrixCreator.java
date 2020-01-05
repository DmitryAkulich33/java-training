package by.epam.twodimensionalarray.service;

import by.epam.twodimensionalarray.domain.DoubleMatrix;
import by.epam.twodimensionalarray.domain.IntMatrix;


public class MatrixCreator {
    public void fillRandomized(IntMatrix intMatrix, int minValue, int maxValue) {
        int verticalSize = intMatrix.getVerticalSize();
        int horizontalSize = intMatrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                int value = (int) (Math.random() * (maxValue - minValue) + minValue);
                intMatrix.setElement(i, j, value);
            }

        }
    }

    public void fillMatrixByCondition(IntMatrix intMatrix) {
        int verticalSize = intMatrix.getVerticalSize();
        int horizontalSize = intMatrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize - i; j++) {
                int value = i + 1;
                intMatrix.setElement(i, j, value);
            }
        }
    }

    public void fillMatrixByRule(DoubleMatrix doubleMatrix) {
        int verticalSize = doubleMatrix.getVerticalSize();
        int horizontalSize = doubleMatrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                double value = Math.sin(((i * i) - (j * j)) / verticalSize);
                doubleMatrix.setElement(i, j, value);
            }
        }
    }
}
