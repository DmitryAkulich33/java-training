package by.epam.multithreading.method03.domain;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Matrix {
    private AtomicInteger[][] matrix;

    public Matrix() {
    }

    public Matrix(AtomicInteger[][] matrix) {
        this.matrix = matrix;
    }

    public int getValue(int row, int column) {
        return matrix[row][column].get();
    }

    public AtomicInteger[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(AtomicInteger[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
