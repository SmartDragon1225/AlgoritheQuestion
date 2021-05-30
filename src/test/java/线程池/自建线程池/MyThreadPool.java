package 线程池.自建线程池;

import java.util.concurrent.*;

/**
 * 线程池：三大方式、七大参数、四种拒绝策略
 * */
public class MyThreadPool {
    public static void main(String[] args) {
        //获取cpu核数，容易设置最大线程数
        int thread_Max = Runtime.getRuntime().availableProcessors();
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                2,       //核心线程数
                thread_Max,        //最大线程数,cpu线程数

                3,      //线程存活个数
                TimeUnit.SECONDS,       //延时时间
                new LinkedBlockingDeque<>(3),  //线程阻塞队列
                Executors.defaultThreadFactory(),    //线程工厂
                //四大拒绝策略
                //new ThreadPoolExecutor.AbortPolicy() //该拒绝策略为：银行满了，还有人进来，不处理这个人的，并抛出异常
                                                       //超出最大承载，就会抛出异常：队列容量大小+maxPoolSize
                //new ThreadPoolExecutor.CallerRunsPolicy()  //该拒绝策略为：哪来的去哪里 main线程进行处理
                new ThreadPoolExecutor.DiscardOldestPolicy() //该拒绝策略为：队列满了，尝试去和最早的进程竞争，不会抛出异常
                //new ThreadPoolExecutor.DiscardPolicy()   //该拒绝策略为：队列满了,丢掉异常，不会抛出异常。
                );

        //测试线程池(1)
        for (int i = 1; i <= 20; i++) {
            int t = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName"+Thread.currentThread().getName()+",i"+t);
                }
            });
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        //测试线程池(2,lambda表达式)
        for (int i = 0; i < 10; i++) {
            int t = i;
            executorService.execute(()->{
                System.out.println("threadName"+Thread.currentThread().getName()+",i"+t);
            });
        }
    }
}
