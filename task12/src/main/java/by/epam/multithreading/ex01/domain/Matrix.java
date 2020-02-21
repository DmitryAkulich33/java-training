package by.epam.multithreading.ex01.domain;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private int[][] matrix;
    List<Element> diagonal;
    ReentrantLock locker;

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
}
