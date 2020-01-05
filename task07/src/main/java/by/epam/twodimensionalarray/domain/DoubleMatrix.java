package by.epam.twodimensionalarray.domain;

import by.epam.twodimensionalarray.domain.exception.MatrixException;

public class DoubleMatrix {
    private double[][] array;

    public DoubleMatrix(int n, int m) throws MatrixException {
        if ((n < 1) || (m < 1)) {
            throw new MatrixException();
        }
        array = new double[n][m];
    }

    public int getVerticalSize() {
        return array.length;
    }

    public int getHorizontalSize() {
        return array[0].length;
    }

    public double getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return array[i][j];
        }
        throw new MatrixException();
    }

    public void setElement(int i, int j, double value) throws MatrixException {
        if (checkRange(i, j)) {
            array[i][j] = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\nDoubleMatrix : " + array.length + "x" + array[0].length + "\n");
        for (double[] row : array) {
            for (double value : row) {
                stringBuilder.append(value + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < array.length && j >= 0 && j < array[0].length;
    }
}
