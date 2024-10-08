package com.thread.case4;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TreadExercise extends JFrame implements ActionListener {
    private JLabel label;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private static int count = 0;
    CounterThread counterThread;
    static boolean increaseRunning = false;
    static boolean decreaseRunning = false;

    public TreadExercise() {
        super("Thread Exercise");
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Count: 0");
        label.setBounds(120, 50, 100, 30);
        add(label);

        btn1 = new JButton("Increase");
        btn1.setBounds(30, 100, 100, 25);
        btn1.addActionListener(this);
        add(btn1);

        // Decrease button
        btn2 = new JButton("Decrease");
        btn2.setBounds(150, 100, 100, 25);
        btn2.addActionListener(this);
        add(btn2);

        // Stop button
        btn3 = new JButton("Stop");
        btn3.setBounds(80, 140, 100, 25);
        btn3.addActionListener(this);
        add(btn3);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("thread Name for ActionPerform: " +Thread.currentThread().getName());
        if ( counterThread== null || !counterThread.isAlive()) {
            System.out.println("New Thread is Strating");
            counterThread = new CounterThread();
            counterThread.start();
        }
        if (e.getSource() == btn1) {
                System.out.println("Arrive to btn1");
                counterThread.setIncrement(true);
        } else if (e.getSource() == btn2) {
                System.out.println("Arrive to btn2");
                counterThread.setIncrement(false);
        } else {
           counterThread.setStop(true);
        }
    }


    class CounterThread extends Thread {
        private boolean increment;
        private boolean stop = false;
        public CounterThread() {
            this.stop = true;
        }
        public CounterThread(boolean increment) {
            this.increment = increment;
        }
        @Override
        public void run() {
            System.out.println(this.increment+" :: "+this.stop);
            while (!this.stop) {
                if(this.increment){
                    System.out.println("thread Name for increase: " + counterThread.getName());
                    count++;
                }else{
                    System.out.println("thread Name for decrease: " + counterThread.getName());
                    count--;
                }

                label.setText("Count: " + count);

                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }

        }

        public boolean isIncrement() {
            return increment;
        }

        public void setIncrement(boolean increment) {
            this.stop=false;
            this.increment = increment;
        }

        public boolean isStop() {
            return stop;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }
    public static void main(String[] args) {
        new TreadExercise();
    }
}