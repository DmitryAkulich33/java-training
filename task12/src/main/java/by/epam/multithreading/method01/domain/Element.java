package by.epam.multithreading.method01.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class Element {
    private static Logger log = LogManager.getLogger(Element.class.getName());
    ReentrantLock locker;
    int value;
    int x;
    int y;

    public Element() {
    }

    public Element(ReentrantLock locker, int value, int x, int y) {
        this.locker = locker;
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void lockElement() {
        log.info("Element is lock.");
        locker.lock();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void unLock() {
        log.info("Element is unlock.");
        locker.unlock();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (value != element.value) return false;
        if (x != element.x) return false;
        if (y != element.y) return false;
        return locker != null ? locker.equals(element.locker) : element.locker == null;
    }

    @Override
    public int hashCode() {
        int result = locker != null ? locker.hashCode() : 0;
        result = 31 * result + value;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Element{" +
                "locker=" + locker +
                ", value=" + value +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
