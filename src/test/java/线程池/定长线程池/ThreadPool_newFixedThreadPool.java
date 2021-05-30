package 线程池.定长线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可以看到newFixedThreadPool创建一个定长线程池，
 * 可控制线程最大并发数，超出的线程会在队列中等待。*/
public class ThreadPool_newFixedThreadPool {
    public static void main(String[] args) {

        //1.创建可固定长度的线程池(5个线程)
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ////创建了10个线程
        for (int i = 0; i < 10; i++) {
            int t = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName"+Thread.currentThread().getName()+",i"+t);
                }
            });
        }
    }
}
