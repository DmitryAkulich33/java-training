package by.epam.twodimensionalarray.service;

import by.epam.twodimensionalarray.domain.DoubleMatrix;
import by.epam.twodimensionalarray.domain.IntMatrix;
import by.epam.twodimensionalarray.domain.exception.MatrixException;

public class MatrixService {
    public IntMatrix multiply(IntMatrix a, IntMatrix b) throws MatrixException {
        int verticalSize = a.getVerticalSize();
        int horizontalSize = b.getHorizontalSize();
        int temp = a.getHorizontalSize();
        if (temp != b.getVerticalSize()) {
            throw new MatrixException();
        }
        IntMatrix result = new IntMatrix(verticalSize, horizontalSize);
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                int value = 0;
                for (int k = 0; k < temp; k++) {
                    value += a.getElement(i, k) * b.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    }

    public int findNumberCount(IntMatrix intMatrix, int number) {
        int count = 0;
        int verticalSize = intMatrix.getVerticalSize();
        int horizontalSize = intMatrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (intMatrix.getElement(i, j) == number) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findAmountOfPositiveNumbers(DoubleMatrix doubleMatrix) {
        int verticalSize = doubleMatrix.getVerticalSize();
        int horizontalSize = doubleMatrix.getHorizontalSize();
        int count = 0;
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (doubleMatrix.getElement(i, j) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public IntMatrix increaseSort(IntMatrix intMatrix) {
        int verticalSize = intMatrix.getVerticalSize();
        int horizontalSize = intMatrix.getHorizontalSize();
        for (int j = 0; j < verticalSize; j++) {
            for (int i = horizontalSize - 1; i >= 1; i--) {
                for (int k = 0; k < i; k++) {
                    if (intMatrix.getElement(k, j) > intMatrix.getElement(k + 1, j)) {
                        swap(intMatrix, k, j);
                    }
                }
            }
        }
        return intMatrix;
    }

    public IntMatrix decreaseSort(IntMatrix intMatrix) {
        int verticalSize = intMatrix.getVerticalSize();
        int horizontalSize = intMatrix.getHorizontalSize();
        for (int j = 0; j < verticalSize; j++) {
            for (int i = horizontalSize - 1; i >= 1; i--) {
                for (int k = 0; k < i; k++) {
                    if (intMatrix.getElement(k, j) < intMatrix.getElement(k + 1, j)) {
                        swap(intMatrix, k, j);
                    }
                }
            }
        }
        return intMatrix;
    }


    public static void swap(IntMatrix intMatrix, int k, int j) {
        int temp = intMatrix.getElement(k, j);
        int value = intMatrix.getElement(k + 1, j);
        intMatrix.setElement(k, j, value);
        intMatrix.setElement(k + 1, j, temp);
    }
}
