package com.thread.case2;

public class MinApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MinApp: "+Thread.currentThread().getName());
        MyCounterViewController controller = new MyCounterViewController(new MyCounterView());

    }
}
