package com.ThreadTeaching.Sychronize;

class SharedData {
    private int a = 0;
    private int b = 0;

    public void update() {
        a = a + 1; // Step 1
        b = b + 1; // Step 2
    }

    public void print() {
        System.out.println("a: " + a + ", b: " + b);
    }
}

public class InconsistentStateExample {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Runnable task = () -> {
            for (int i = 0; i < 200; i++) {
                data.update();
                System.out.println(Thread.currentThread().getName() + " :: ");
                data.print();
                try {
                    Thread.sleep(300);
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

        data.print();
    }
}
