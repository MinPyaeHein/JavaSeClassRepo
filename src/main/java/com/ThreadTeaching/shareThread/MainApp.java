package com.ThreadTeaching.shareThread;


import com.ThreadTeaching.shareThread.MyCounterView;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MainApp: "+Thread.currentThread().getName());
        MyCounterView view = new MyCounterView();

    }
}
