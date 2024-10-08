package com.thread.case1;

public class MinApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MinApp: "+Thread.currentThread().getName());
        MyCounter counter = new MyCounter();

    }
}
