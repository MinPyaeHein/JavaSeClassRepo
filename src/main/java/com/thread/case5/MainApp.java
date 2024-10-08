package com.thread.case5;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MainApp: "+Thread.currentThread().getName());
        CounterView counterView = new CounterView();
        CounterViewController counterViewController = new CounterViewController(counterView);
    }
}
