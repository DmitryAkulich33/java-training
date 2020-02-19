package by.epam.multithreading.domain;

public class Matrix {
    private int[][] matrix;
    int x;
    int y;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
