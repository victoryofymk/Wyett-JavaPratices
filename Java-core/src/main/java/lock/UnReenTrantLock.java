package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用自旋锁来模拟一个不可重入锁
 *
 * @author yanmingkun
 * @date 2018-12-20 19:37
 */
public class UnReenTrantLock {
    private AtomicReference<Thread> ower = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        for (; ; ) {
            if (!ower.compareAndSet(null, thread)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        ower.compareAndSet(thread, null);
    }
}
