package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    Lock lock = new ReentrantLock();
    static Object object = new Object();

    public static void main(String[] args) {
            new Thread(()->{
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"==>come in!");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"被唤醒！");
                }
            },"A").start();

            new Thread(()->{
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"==>come in!");
                    object.notifyAll();;
                    System.out.println(Thread.currentThread().getName()+"通知！");
                }
            },"B").start();

            Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
            new Thread(()->{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"==>come in!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"被唤醒！");
                lock.unlock();
            },"C").start();


            new Thread(()->{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"==>come in!");
                condition.signalAll();
                System.out.println(Thread.currentThread().getName()+"通知！");
                lock.unlock();
            },"D").start();
        }




}
