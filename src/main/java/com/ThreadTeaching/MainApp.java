package com.ThreadTeaching;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MainApp: "+Thread.currentThread().getName());
        MyCounterView view = new MyCounterView();

    }
}
