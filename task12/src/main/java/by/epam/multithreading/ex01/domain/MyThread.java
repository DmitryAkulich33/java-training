package by.epam.multithreading.ex01.domain;

import by.epam.multithreading.ex01.domain.Matrix;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    Matrix matrix;
    ReentrantLock locker;
    int unique;

    public MyThread(Matrix matrix, ReentrantLock locker, int unique) {
        this.matrix = matrix;
        this.locker = locker;
        this.unique = unique;
    }


    public void run() {
        while(!checkDiagonal(matrix)) {
            int i = getRandomIndex(matrix);
            matrix.getDiagonal().get(i).lockElement();
            if(matrix.getDiagonal().get(i).getValue() == 0) {
                matrix.getDiagonal().get(i).setValue(unique);
                System.out.println("Поток " + unique + " на " + i + " " + i + " значение" + unique);
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                matrix.getMatrix()[i][i] = unique;
            }
            matrix.getDiagonal().get(i).unLock();
        }
    }

    public boolean checkDiagonal(Matrix matrix) {
        int length = matrix.getMatrix().length;
        for(int i = 0; i < length; i++){
            if (matrix.getMatrix()[i][i] == 0){
                return false;
            }
        }
        return true;
    }

    public int getRandomIndex(Matrix matrix){
        return new Random().nextInt(matrix.getMatrix().length);
    }
}
