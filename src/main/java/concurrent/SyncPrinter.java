package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrinter implements Runnable{
    public static final int PRINT_COUNT = 10;
    private final CloseableReentrantLock lock;
    private final Condition thisCondition;
    private final Condition nextCondition;
    private final char printChar;

    public SyncPrinter(CloseableReentrantLock lock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        try(CloseableReentrantLock closeableLock = lock.open()) {
            for (int i = 0; i < PRINT_COUNT; i++) {
                try {
                    thisCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(printChar);
                nextCondition.signalAll();
            }
        }
    }
}
