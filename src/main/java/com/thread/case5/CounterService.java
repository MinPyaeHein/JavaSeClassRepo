package com.thread.case5;

import javax.swing.*;

public class CounterService {
    private boolean increment;
    private boolean stop = false;
    private int count = 0;
    private JLabel label;
    public CounterService(JLabel label) {
        this.label = label;
        this.stop = true;
    }
    public CounterService(boolean increment) {
        this.increment = increment;
    }

    public void counter() {
        System.out.println(this.increment + " :: " + this.stop);
        while (!this.stop) {
            if (this.increment) {
                System.out.println("thread Name for increase: " + Thread.currentThread().getName());
                this.count++;
            } else {
                System.out.println("thread Name for decrease: " +Thread.currentThread().getName());
                this.count--;
            }
            this.label.setText("Count: " + count);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public boolean isIncrement() {
        return increment;
    }

    public void setIncrement(boolean increment) {
        this.increment = increment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
