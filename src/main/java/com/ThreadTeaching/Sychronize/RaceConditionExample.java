package com.ThreadTeaching.Sychronize;

class Counter1 {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();

        Runnable task = () -> {
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

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
