package 线程池.缓存线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可以看到本来创建了10个线程池，这里只用了7个，因为newCachedThreadPool创建一个可缓存线程池，
 * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程*/
public class ThreadPool_newCachedThreadPool {
    public static void main(String[] args) {
        //1.创建可缓存的线程池，可重复利用
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建10个线程
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
