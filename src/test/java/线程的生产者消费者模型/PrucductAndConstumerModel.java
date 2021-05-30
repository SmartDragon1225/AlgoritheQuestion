package 线程的生产者消费者模型;

public class PrucductAndConstumerModel {
    public static void main(String[] args) {
        System.out.println();
        Data1 data1 = new Data1();
        //创建一个生产者
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data1.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //创建一个生产者
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data1.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        data1.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        data1.decrement();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

//这是一个缓冲类，生产和消费之间的仓库
class Data1{
    //    这是仓库的资源，生产者生产资源，消费者消费资源
    private int num = 0;

    //    +1，利用关键字加锁
    public synchronized void increment() throws InterruptedException {
//        首先查看仓库中的资源(num)，如果资源不为0，就利用 wait 方法等待消费，释放锁

//        使用 if 存在虚假唤醒
        while (num!=0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
//      通知其他线程 +1 执行完毕
        this.notifyAll();
    }

    //    -1
    public synchronized void decrement() throws InterruptedException {
        //        首先查看仓库中的资源(num)，如果资源为0，就利用 wait 方法等待生产，释放锁
        while(num==0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
//        通知其他线程 -1 执行完毕
        this.notifyAll();
    }
}
