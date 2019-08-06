package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class CloseableReentrantLock extends ReentrantLock implements AutoCloseable {
    public CloseableReentrantLock open() {
        this.lock();
        return this;
    }

    @Override
    public void close() {
        try {
            this.unlock();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
