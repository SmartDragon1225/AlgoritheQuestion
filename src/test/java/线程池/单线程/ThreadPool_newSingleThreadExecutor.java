package 线程池.单线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *  结果依次输出，相当于顺序执行各个任务。当shutdown时停止线程
 */
public class ThreadPool_newSingleThreadExecutor {
    public static void main(String[] args) {
        //1.创建单线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int t = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName"+Thread.currentThread().getName()+",i"+t);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
