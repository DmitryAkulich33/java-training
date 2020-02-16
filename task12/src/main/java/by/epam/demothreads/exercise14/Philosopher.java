package by.epam.demothreads.exercise14;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore sem; // семафор. ограничивающийчислофилософов
    // кол-воприемовпищи
    int num = 0;
    // условныйномерфилософа
    int id;

    // в качествепараметровконструкторапередаемидентификаторфилософа и семафор
    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num< 3)// покаколичествоприемовпищинедостигнет 3
            {
                // Запрашиваем у семафораразрешениенавыполнение
                sem.acquire();
                System.out.println("Философ " + id + " садится за стол");
                // философест
                sleep(500);
                num++;
                System.out.println("Философ " + id + " выходит из-за стола");
                sem.release();
                // философгуляет
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }
}
