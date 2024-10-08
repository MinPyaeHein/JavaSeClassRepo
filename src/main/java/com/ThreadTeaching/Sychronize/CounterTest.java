package com.ThreadTeaching.Sychronize;

class Counter {
    private int count = 0;

    public  void increment() {
        count++;
    }

    public  int getCount() {
        return count;
    }
}

public class CounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task0 = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " :: " + counter.getCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " :: " + counter.getCount());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " :: " + counter.getCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t0 = new Thread(task0);
        Thread t2 = new Thread(task1);
        Thread t3 = new Thread(task2);

        t0.start();
        t2.start();
        t3.start();

        try {
            t0.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
