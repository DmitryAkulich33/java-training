package by.epam.multithreading.method01.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    private static Logger log = LogManager.getLogger(MyThread.class.getName());

    Matrix matrix;
    ReentrantLock locker;
    int unique;

    public MyThread(Matrix matrix, ReentrantLock locker, int unique) {
        this.matrix = matrix;
        this.locker = locker;
        this.unique = unique;
    }

    public void run() {
        while (!checkDiagonal(matrix)) {
            int i = getRandomIndex(matrix);
            matrix.getDiagonal().get(i).lockElement();
            if (matrix.getDiagonal().get(i).getValue() == 0) {
                matrix.getDiagonal().get(i).setValue(unique);
                log.info("Thread " + unique + " changed value of element " + i + " " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted.");
                }
                matrix.getMatrix()[i][i] = unique;
            }
            matrix.getDiagonal().get(i).unLock();
        }
    }

    public boolean checkDiagonal(Matrix matrix) {
        int length = matrix.getMatrix().length;
        for (int i = 0; i < length; i++) {
            if (matrix.getMatrix()[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public int getRandomIndex(Matrix matrix) {
        return new Random().nextInt(matrix.getMatrix().length);
    }
}
