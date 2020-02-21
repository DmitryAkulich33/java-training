package by.epam.multithreading.ex01.service.impl;

import by.epam.multithreading.ex01.domain.Matrix;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadServiceImpl extends Thread {
    Matrix matrix;
    ReentrantLock locker;
    int unique;

    public ThreadServiceImpl(Matrix matrix, ReentrantLock locker, int unique) {
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
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                matrix.getMatrix()[i][i] = unique;
            }
            matrix.getDiagonal().get(i).unLock();
        }
    }

    public boolean checkDiagonal(Matrix matrix) {
        for(int i = 0; i < 10; i++){
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
