package by.epam.multithreading.service;

import by.epam.multithreading.domain.Matrix;

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
        for(int i = 0; i < matrix.getMatrix().length; i++){
            locker.lock(); // устанавливаем блокировку
            if(matrix.getMatrix()[i][i] == 0) {
                matrix.getMatrix()[i][i] = unique;
                System.out.println("На элемент " + i + " " + i + " значение установил поток " + unique);

            }
            locker.unlock(); // снимаем блокировку
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
