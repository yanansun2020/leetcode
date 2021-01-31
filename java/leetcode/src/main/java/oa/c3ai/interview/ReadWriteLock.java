package oa.c3ai.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class ReadWriteLock {
    AtomicInteger mutex = new AtomicInteger(1);
    public synchronized void lockWrite() throws InterruptedException {
        while (mutex.get() == 0) {
            wait();
        }
        mutex.decrementAndGet();
    }
    public synchronized void unlockWrite(){
        mutex.incrementAndGet();
    }

    public synchronized void lockRead() throws InterruptedException {
        while (mutex.get() == 0) {
            wait();
        }
        mutex.decrementAndGet();
    }

    public synchronized void unlockRead(){
        mutex.incrementAndGet();
    }
}
