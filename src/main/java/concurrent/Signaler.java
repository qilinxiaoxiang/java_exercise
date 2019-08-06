package concurrent;

import java.util.concurrent.locks.Condition;

public class Signaler implements Runnable {
    private final CloseableReentrantLock lock;
    private final Condition targetCondition;

    public Signaler(CloseableReentrantLock lock, Condition targetCondition) {
        this.lock = lock;
        this.targetCondition = targetCondition;
    }

    @Override
    public void run() {
        try(CloseableReentrantLock closeableLock = lock.open()) {
            targetCondition.signalAll();
        }
    }
}
