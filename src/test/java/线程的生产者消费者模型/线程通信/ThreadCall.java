package 线程的生产者消费者模型.线程通信;

public class ThreadCall {
    public static void main(String[] args) {
        Call call = new Call();
        //生产者
        new Thread(()->{
             for (int i = 0; i < 10; i++) {
                 try {
                     call.product();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         },"生产者").start();
        //消费者
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    call.cunsumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();

    }
}

class Call{

    private static int num = 0;

    public synchronized void product() throws InterruptedException {
        while (num != 0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"生产" + num+"个"+"剩余"+num+"个");
        this.notifyAll();
    }

    public synchronized void cunsumer() throws Exception{
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"消费"+ (num+1)+"个"+"剩余"+num+"个");
        this.notifyAll();
    }
}
