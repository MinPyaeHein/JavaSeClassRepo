package com.thread.case1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.Thread.sleep;

public class MyCounter extends Frame {
    private boolean flag=true;
    Button startButton;
    Button stopButton;
    Label myLabel;
    int counter = 0;
    public MyCounter() {
        super.setVisible(true);
        super.setSize(400, 200);
        super.setTitle("My Thread Counter");
        startButton = new Button("Start");
        stopButton = new Button("Stop");
        myLabel = new Label(counter+"");

        super.setLayout(null);
        myLabel.setBounds(100, 50, 150, 30);
        startButton.setBounds(70, 100, 150, 30);
        stopButton.setBounds(250, 100, 150, 30);

        super.add(startButton);
        super.add(stopButton);
        super.add(myLabel);


        this.stopButton.addActionListener(new StopBtnListener());
        this.startButton.addActionListener(new StartBtnListener());
        this.addWindowListener(new MyWindowListner());

    }
    private class MyWindowListner extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Check thread name for windows Closing: "+Thread.currentThread().getName());
            System.exit(0);
        }
    }
    private class StartBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Check thread name for Btn Click: "+Thread.currentThread().getName());
            ThreadCounter threadCounter = new ThreadCounter();
            threadCounter.start();
        }
    }
    private class StopBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Check thread name for Btn Click: "+Thread.currentThread().getName());
            flag=false;
        }
    }
    public class ThreadCounter extends Thread{
        public void run(){
            increaseCounter();
        }
        private void increaseCounter(){
            flag=true;
            while(flag){
                counter++;
                myLabel.setText(counter+"");
                System.out.println("counter ::"+counter);
                System.out.println("Thread Counter name: "+Thread.currentThread().getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
