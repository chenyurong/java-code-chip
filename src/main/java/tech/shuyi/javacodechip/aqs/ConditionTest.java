package tech.shuyi.javacodechip.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private int i = 1;
    private Lock lock;
    private Condition oddCondition;
    private Condition evenCondition;

    public ConditionTest(){
        lock = new ReentrantLock();
        oddCondition = lock.newCondition();
        evenCondition = lock.newCondition();
    }

    public void oddPrint() throws InterruptedException {
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