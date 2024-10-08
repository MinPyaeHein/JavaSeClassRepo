package com.thread.case3;

import javax.swing.*;

public class MinApp {
    public static void main(String[] args) {
        System.out.println("Thread name of MinApp: "+Thread.currentThread().getName());
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                System.out.println("Application Swing Utilities invoke Later :"+Thread.currentThread().getName());
                new MyCounterViewController(new MyCounterView());
            }
        });

    }
}
