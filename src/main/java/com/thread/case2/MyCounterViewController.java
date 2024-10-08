package com.thread.case2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCounterViewController {
    private boolean flag=true;
    private  int counter = 0;
    private MyCounterView counterView;
    private ThreadCounter threadCounter;
    public MyCounterViewController(MyCounterView counterView){
        this.counterView = counterView;
        this.counterView.getStartButton().addActionListener(new StartBtnListener());
        this.counterView.getStopButton().addActionListener(new StopBtnListener());
        this.counterView.addWindowListener(new MyWindowListner());
        this.threadCounter = new ThreadCounter();
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
           flag=true;
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
                counterView.getMyLabel().setText(counter+"::"+Thread.currentThread().getName());
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
