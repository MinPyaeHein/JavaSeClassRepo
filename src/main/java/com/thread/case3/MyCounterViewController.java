package com.thread.case3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCounterViewController {
    private boolean flag=true;
    private  int counter = 0;
    private MyCounterView counterView;
//    private ThreadCounter threadCounter;
    public MyCounterViewController(MyCounterView counterView){
        this.counterView = counterView;
        this.counterView.getStartButton().addActionListener(new BtnListener());
        this.counterView.getStopButton().addActionListener(new BtnListener());
        this.counterView.addWindowListener(new MyWindowListner());
//        this.threadCounter = new ThreadCounter();
    }
    private void increaseCounter(){
        flag=true;
        while(flag) {
            counter++;
            counterView.getMyLabel().setText(counter + "::" + Thread.currentThread().getName());
            System.out.println("counter ::" + counter);
            System.out.println("Thread Counter name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }}
    private class MyWindowListner extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Check thread name for windows Closing: "+Thread.currentThread().getName());
            System.exit(0);
        }
    }

    private class BtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(counterView.getStopButton())){
                System.out.println("Check thread name for Btn Click: "+Thread.currentThread().getName());
                flag=false;
            }else if(e.getSource().equals(counterView.getStartButton())){
                System.out.println("Check thread name for Btn Click: "+Thread.currentThread().getName());
                increaseCounter();
            }
        }

    }

//    public class ThreadCounter extends Thread{
//        public void run(){
//            increaseCounter();
//        }
//        private void increaseCounter(){
//            flag=true;
//            while(flag){
//                counter++;
//                counterView.getMyLabel().setText(counter+"::"+Thread.currentThread().getName());
//                System.out.println("counter ::"+counter);
//                System.out.println("Thread Counter name: "+Thread.currentThread().getName());
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//
//    }
}
