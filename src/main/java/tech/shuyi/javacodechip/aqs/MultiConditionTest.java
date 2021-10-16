package tech.shuyi.javacodechip.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3 个奇数的线程，这样就可以制造 condition 中的队列有 3 个元素，排队去获取条件元素。
 * 只有 1 个偶数线程，去调用 signal 唤醒。
 */
public class MultiConditionTest {
    private volatile int i = 1;
    private Lock lock;
    private Condition oddCondition;
    private Condition evenCondition;

    public MultiConditionTest(){
        lock = new ReentrantLock();
        oddCondition = lock.newCondition();
        evenCondition = lock.newCondition();
    }

    public void oddPrint1() throws InterruptedException {
        while (true) {
            lock.lock();    //获取锁
            try {
                if (i == 100) {
                    break;
                }
                if (i % 2 != 1) {
                    oddCondition.await();
                }
                System.out.print(i + " ");
                i++;
                evenCondition.signal();
            } finally {
                lock.unlock();      //记得释放锁
            }
        }
    }

    public void oddPrint2() throws InterruptedException {
        while (true) {
            lock.lock();    //获取锁
            try {
                if (i == 100) {
                    break;
                }
                if (i % 2 != 1) {
                    oddCondition.await();
                }
                System.out.print(i + " ");
                i++;
                evenCondition.signal();
            } finally {
                lock.unlock();      //记得释放锁
            }
        }
    }

    public void oddPrint3() throws InterruptedException {
        while (true) {
            lock.lock();    //获取锁
            try {
                if (i == 100) {
                    break;
                }
                if (i % 2 != 1) {
                    oddCondition.await();
                }
                System.out.print(i + " ");
                i++;
                evenCondition.signal();
            } finally {
                lock.unlock();      //记得释放锁
            }
        }
    }

    public void evenPrint() throws InterruptedException {
        while (true) {
            lock.lock();    //获取锁
            try {
                if (i == 100) {
                    break;
                }
                if (i % 2 != 0) {
                    evenCondition.await();
                }
                System.out.print(i + " ");
                i++;
                oddCondition.signal();
            } finally {
                lock.unlock();      //记得释放锁
            }
        }
    }
}