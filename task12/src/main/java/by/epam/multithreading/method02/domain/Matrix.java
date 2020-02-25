package by.epam.multithreading.method02.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Matrix {
    private int[][] matrix;
    private List<Element> diagonal;
    private Semaphore sem;

    public Matrix() {
    }

    public Matrix(int[][] matrix, List<Element> diagonal, Semaphore sem) {
        this.matrix = matrix;
        this.diagonal = diagonal;
        this.sem = sem;
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
        return sem != null ? sem.equals(matrix1.sem) : matrix1.sem == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matrix);
        result = 31 * result + (diagonal != null ? diagonal.hashCode() : 0);
        result = 31 * result + (sem != null ? sem.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                ", diagonal=" + diagonal +
                ", sem=" + sem +
                '}';
    }
}
