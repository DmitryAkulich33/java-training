package by.epam.multithreading.method03.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MyThread extends Thread {
    private static Logger log = LogManager.getLogger(MyThread.class.getName());

    private Matrix matrix;
    private int unique;

    public MyThread(Matrix matrix, int unique) {
        this.matrix = matrix;
        this.unique = unique;
    }

    public void run() {
        while (!checkDiagonal(matrix)) {
            int randomIndex = getRandomIndex(matrix);
            int existingValue = matrix.getValue(randomIndex, randomIndex);
            if (existingValue == 0) {
                matrix.getMatrix()[randomIndex][randomIndex].compareAndSet(0, unique);
                log.info("Thread " + unique + " changed value of element " + randomIndex + " " + randomIndex);
            }
        }
    }

    private boolean checkDiagonal(Matrix matrix) {
        int length = matrix.getMatrix().length;
        for (int i = 0; i < length; i++) {
            if (matrix.getValue(i, i) == 0) {
                return false;
            }
        }
        return true;
    }

    private int getRandomIndex(Matrix matrix) {
        return new Random().nextInt(matrix.getMatrix().length);
    }
}
