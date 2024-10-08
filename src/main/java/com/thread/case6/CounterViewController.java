package com.thread.case6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterViewController {
    private CounterView counterView;
//    private CounterThread counterThread;

    private TheadManager threadManager;
    private int count=0;
    public CounterViewController(CounterView counterView){
        this.counterView = counterView;
//        this.counterView.getBtn2().addActionListener(new ButtonsActionListener());
//        this.counterView.getBtn1().addActionListener(new ButtonsActionListener());
//        this.counterView.getBtn3().addActionListener(new ButtonsActionListener());
    }
//    public class ButtonsActionListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("thread Name for ActionPerform: " + Thread.currentThread().getName());
//            if (counterThread == null || !counterThread.isAlive()) {
//                System.out.println("New Thread is Strating");
//                counterThread = new CounterThread();
//                counterThread.start();
//            }
//            if (e.getSource()== counterView.getBtn1()) {
//                System.out.println("Arrive to btn1");
//                counterThread.setIncrement(true);
//            } else if (e.getSource() == counterView.getBtn2()) {
//                System.out.println("Arrive to btn2");
//                counterThread.setIncrement(false);
//            } else {
//                counterThread.setStop(true);
//            }
//        }
//    }
//    class CounterThread extends Thread {
//        private boolean increment;
//        private boolean stop = false;
//        public CounterThread() {
//            this.stop = true;
//        }
//        public CounterThread(boolean increment) {
//            this.increment = increment;
//        }
//        @Override
//        public void run() {
//            System.out.println(this.increment+" :: "+this.stop);
//            while (!this.stop) {
//                if(this.increment){
//                    System.out.println("thread Name for increase: " + counterThread.getName());
//                    count++;
//                }else{
//                    System.out.println("thread Name for decrease: " + counterThread.getName());
//                    count--;
//                }
//
//                counterView.getLabel().setText("Count: " + count);
//
//                try {
//                    Thread.sleep(1000); // Sleep for 1 second
//                } catch (InterruptedException e) {
//                    System.out.println("Thread interrupted");
//                }
//            }
//
//        }
//
//        public boolean isIncrement() {
//            return increment;
//        }
//
//        public void setIncrement(boolean increment) {
//            this.stop=false;
//            this.increment = increment;
//        }
//
//        public boolean isStop() {
//            return stop;
//        }
//
//        public void setStop(boolean stop) {
//            this.stop = stop;
//        }
//    }
}
