package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author earthchen
 * @date 2021/11/7
 **/
public class ThreadMain {


    static class Demo {
        volatile boolean flag = true;

        List<String> list = new ArrayList<>();

        Lock lock = new ReentrantLock();

        Condition notFull = lock.newCondition();

        Condition notEmpty = lock.newCondition();


        public void add(String data) {
            try {
                lock.lock();
                while (list.size() > 5) {
                    notFull.await();
                }
                list.add(data);
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
                notFull.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public String take() {
            try {
                lock.lock();
                while (list.size() <= 0) {
                    notEmpty.await();
                }
                String val = list.remove(list.size() - 1);
                notFull.signalAll();
                return val;
            } catch (InterruptedException e) {
                e.printStackTrace();
                notEmpty.signalAll();
                return null;
            } finally {
                lock.unlock();
            }
        }


        public void test2() {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("生产:" + i);
                    add(i + "");
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    System.out.println("消费: " + take());
                }
            }).start();
        }

        public void test() {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    while (flag) {
                        System.out.println("1");
                        flag = false;
                    }
                }

            }).start();
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    while (!flag) {
                        System.out.println("2");
                        flag = true;
                    }
                }
            }).start();
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test2();

    }
}
