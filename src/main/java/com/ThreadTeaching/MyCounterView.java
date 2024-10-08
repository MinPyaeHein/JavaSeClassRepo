package com.ThreadTeaching;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCounterView extends Frame {
    private boolean flag = false;
    private Button buttonStart;
    private Button buttonStop;
    private Label label;
    private int count;
    private ThreadCounter threadCounter; // Reference to keep track of the running thread

    public MyCounterView() {
        super.setVisible(true);
        super.setSize(400, 200);
        super.setTitle("My Counter");
        buttonStart = new Button("Start");
        buttonStop = new Button("Stop");
        label = new Label(count + "");
        super.setLayout(null);
        label.setBounds(100, 50, 150, 30);
        buttonStart.setBounds(70, 100, 150, 30);
        buttonStop.setBounds(260, 100, 150, 30);
        super.add(buttonStart);
        super.add(buttonStop);
        super.add(label);
        buttonStart.addActionListener(new ButtonActionListener());
        buttonStop.addActionListener(new StopButtonActionListener());
    }

    public class StopButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Thread name of ActionPerform: " + Thread.currentThread().getName());
            stopCounter();
        }
    }

    public void stopCounter() {
        flag = false;
    }

    public void increaseCounter() {
        flag = true;
        while (flag) {
            count++;
            label.setText(count + "");
            System.out.println("counter ::" + count);
            System.out.println("Thread Counter name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread class for the counter logic
    public class ThreadCounter extends Thread {
        @Override
        public void run() {
            increaseCounter();
        }
    }

    public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Thread name of ActionPerform: " + Thread.currentThread().getName());
            if (threadCounter == null || !threadCounter.isAlive()) {
                threadCounter = new ThreadCounter();
                threadCounter.start();
            } else {
                System.out.println("Thread is already running!");
            }
        }
    }

}
