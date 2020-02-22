package by.epam.multithreading.method01.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private int[][] matrix;
    List<Element> diagonal;
    ReentrantLock locker;

    public Matrix() {
    }

    public Matrix(int[][] matrix, List<Element> diagonal, ReentrantLock locker) {
        this.matrix = matrix;
        this.diagonal = diagonal;
        this.locker = locker;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<Element> getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(List<Element> diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (!Arrays.deepEquals(matrix, matrix1.matrix)) return false;
        if (diagonal != null ? !diagonal.equals(matrix1.diagonal) : matrix1.diagonal != null) return false;
        return locker != null ? locker.equals(matrix1.locker) : matrix1.locker == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matrix);
        result = 31 * result + (diagonal != null ? diagonal.hashCode() : 0);
        result = 31 * result + (locker != null ? locker.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                ", diagonal=" + diagonal +
                ", locker=" + locker +
                '}';
    }
}
