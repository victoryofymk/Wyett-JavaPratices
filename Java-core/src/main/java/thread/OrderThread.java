package thread;

/**
 * @author yanmingkun
 * @date 2019-01-11 13:37
 */
public class OrderThread extends Thread {
    private Thread thread;
    private String order = "1";

    public OrderThread() {
    }

    public OrderThread(Thread thread, String order) {
        this.thread = thread;
        this.order = order;

    }

    public static void main(String[] args) {
        OrderThread orderThread1 = new OrderThread();
        OrderThread orderThread2 = new OrderThread(orderThread1, "2");
        OrderThread orderThread3 = new OrderThread(orderThread2, "3");
        orderThread1.start();
        orderThread2.start();
        orderThread3.start();
    }

    @Override
    public void run() {
        try {
            if (thread != null) {
                thread.join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行" + order);
    }

}
