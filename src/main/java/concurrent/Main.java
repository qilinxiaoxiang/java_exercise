package concurrent;

import java.util.concurrent.locks.Condition;

public class Main {
    public static void main(String[] args) {
        CloseableReentrantLock lock = new CloseableReentrantLock();
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();
        Condition printC = lock.newCondition();
        Thread printerA = new Thread(new ConditionSyncPrinter(lock, printA, printB, 'A'));
        Thread printerB = new Thread(new ConditionSyncPrinter(lock, printB, printC, 'B'));
        Thread printerC = new Thread(new ConditionSyncPrinter(lock, printC, printA, 'C'));
        Thread signaler = new Thread(new Signaler(lock, printA));
        printerA.start();
        printerB.start();
        printerC.start();
        // let a signaler to signal printer A is more reliable
        signaler.start();
        // signal printerA in main thread is not reliable, if sleep less than 100 millis, the signal method may fail
        // and the printerA will await forever
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try(CloseableReentrantLock closeableLock = lock.open()) {
            printA.signalAll();
        }
    }
}
