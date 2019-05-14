package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author yanmingkun
 * @date 2019-02-28 15:51
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(512), new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolExecutor.execute(new Runnable() {
            public void run() {
                System.out.println("启动");
            }
        });
    }
}
