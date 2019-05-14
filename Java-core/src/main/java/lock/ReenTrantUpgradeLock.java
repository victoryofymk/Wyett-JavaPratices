package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用自旋锁来模拟一个不可重入锁,使用state计数修改为可重入锁
 *
 * @author yanmingkun
 * @date 2018-12-20 19:37
 */
public class ReenTrantUpgradeLock {
    private AtomicReference<Thread> ower = new AtomicReference<>();

    private int state = 0;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == ower.get()) {
            state++;
            return;
        }
        for (; ; ) {
            if (!ower.compareAndSet(null, currentThread)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        if (state != 0) {
            state--;
        } else {
            ower.compareAndSet(currentThread, null);
        }

    }
}
