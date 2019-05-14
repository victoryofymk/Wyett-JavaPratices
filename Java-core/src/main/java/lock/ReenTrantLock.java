package lock;

/**
 * synchronized 可重入锁
 *
 * @author yanmingkun
 * @date 2018-12-20 19:33
 */
public class ReenTrantLock implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReenTrantLock reenTrantLock = new ReenTrantLock();
        for (; ; ) {
            new Thread(reenTrantLock).start();
        }
    }
}
