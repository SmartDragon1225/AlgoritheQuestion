package 线程池.定时周期线程;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool_newScheduledThreadPool {
    public static void main(String[] args) {

            //1.创建可定时线程池
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
            for (int i = 0; i < 10; i++) {
                final int temp = i;
                newScheduledThreadPool.schedule(new Runnable() {
                    public void run() {
                        System.out.println("i:" + temp);
                    }
                }, 3, TimeUnit.SECONDS);//表示延迟3秒执行。
            }
    }
}
