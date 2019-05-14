package algorithm;

/**
 * 线程操作
 *
 * @author yanmingkun
 * @date 2019-03-13 14:56
 */
public class OddEvenPringAlgorithm {
    private int i = 0;
    private final Object lock = new Object();

    /**
     * 用程序实现两个线程交替打印 0~100 的奇偶数。
     * 使用lock notify实现
     * 原理：一个线程拿到锁之后，打印，唤起其他线程，并休眠
     *
     * @throws InterruptedException
     */
    public void turning() throws InterruptedException {

        Thread even = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    System.out.println("even:" + i++);
                    lock.notifyAll();

                    try {
                        if (i <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        Thread odd = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    System.out.println("odd:" + i++);
                    lock.notifyAll();
                    try {
                        if (i <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        even.start();
        Thread.sleep(1);
        odd.start();
    }

    public static void main(String[] args) throws InterruptedException {
        OddEvenPringAlgorithm o = new OddEvenPringAlgorithm();
        o.turning();

    }
}
