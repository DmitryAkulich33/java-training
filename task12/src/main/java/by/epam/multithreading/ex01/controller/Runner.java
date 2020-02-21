package by.epam.multithreading.ex01.controller;

import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.service.impl.ThreadServiceImpl;
import by.epam.multithreading.ex01.service.creator.MatrixCreator;
import by.epam.multithreading.ex01.service.exception.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException, ServiceException {

        MatrixCreator matrixCreator = new MatrixCreator();
        ReentrantLock locker = new ReentrantLock();
        String path = "src\\main\\resources\\reentrantlock\\matrix.txt";
        Matrix matrix = matrixCreator.createMatrix(locker, path);
        ThreadServiceImpl threadServiceImpl1 = new ThreadServiceImpl(matrix, locker, 1);
        ThreadServiceImpl threadServiceImpl2 = new ThreadServiceImpl(matrix, locker, 2);
        ThreadServiceImpl threadServiceImpl3 = new ThreadServiceImpl(matrix, locker, 3);
        ThreadServiceImpl threadServiceImpl4 = new ThreadServiceImpl(matrix, locker, 4);
        ThreadServiceImpl threadServiceImpl5 = new ThreadServiceImpl(matrix, locker, 5);
        ThreadServiceImpl threadServiceImpl6 = new ThreadServiceImpl(matrix, locker, 6);

        threadServiceImpl1.start();
        threadServiceImpl2.start();
        threadServiceImpl3.start();
        threadServiceImpl4.start();
        threadServiceImpl5.start();
        threadServiceImpl6.start();

        threadServiceImpl1.join();
        threadServiceImpl2.join();
        threadServiceImpl3.join();
        threadServiceImpl4.join();
        threadServiceImpl5.join();
        threadServiceImpl6.join();


        for(int i = 0; i < 12; i++){
            System.out.print(matrix.getMatrix()[i][i] + " ");
        }
        System.out.println();
    }
}
