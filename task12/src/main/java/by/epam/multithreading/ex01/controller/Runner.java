package by.epam.multithreading.ex01.controller;

import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.domain.MyThread;
import by.epam.multithreading.ex01.service.impl.MatrixServiceImpl;
import by.epam.multithreading.ex01.service.exception.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException, ServiceException {
        Controller controller = new Controller();
        String path = "src\\main\\resources\\reentrantlock\\matrix.txt";
        controller.execute(path);

    }
}
