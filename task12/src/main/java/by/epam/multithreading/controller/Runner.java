package by.epam.multithreading.controller;

import by.epam.multithreading.domain.Matrix;
import by.epam.multithreading.service.MyThread;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        int[][] test = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 0, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 0, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 0, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 0, 5, 6, 7, 8, 9},
                {1, 5, 2, 3, 4, 0, 6, 7, 8, 9},
                {1, 6, 2, 3, 4, 5, 0, 7, 8, 9},
                {1, 7, 2, 3, 4, 5, 6, 0, 8, 9},
                {1, 8, 2, 3, 4, 5, 6, 7, 0, 9},
                {1, 8, 2, 3, 4, 5, 6, 7, 9, 0}};

        Matrix matrix = new Matrix(test);
        ReentrantLock lock = new ReentrantLock();

        MyThread myThread1 = new MyThread(matrix, lock, 1);
        MyThread myThread2 = new MyThread(matrix, lock, 2);
        MyThread myThread3 = new MyThread(matrix, lock, 3);
        MyThread myThread4 = new MyThread(matrix, lock, 4);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        Thread.sleep(5000);
        for(int i = 0; i < 10; i++){
            System.out.print(matrix.getMatrix()[i][i] + " ");
        }
    }
}
