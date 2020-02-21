package by.epam.multithreading.ex01.domain;

import java.util.concurrent.locks.ReentrantLock;

public class Element {
    ReentrantLock locker;
    int value;
    int x;
    int y;

    public Element(ReentrantLock locker, int value, int x, int y) {
        this.locker = locker;
        this.value = value;
        this.x = x;
        this.y = y;
    }
    public void lockElement(){
        locker.lock();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void unLock(){
        locker.unlock();
    }
}
