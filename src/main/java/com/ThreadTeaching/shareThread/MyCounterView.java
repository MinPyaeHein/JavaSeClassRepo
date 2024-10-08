package com.ThreadTeaching.shareThread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyCounterView extends Frame {
    private boolean flag = false;
    private Button buttonStart;
    private Button buttonStop;
    private TextArea textArea;
    private int count;
    private ThreadWriter threadWriter1;
    private ThreadWriter threadWriter2;


    public MyCounterView() {
        super("Message Write"); // Set title in constructor
        setSize(600, 600);
        setLayout(null); // Not recommended, consider using layout managers

      // Initialize label
        buttonStart = new Button("Start");
        buttonStop = new Button("Stop");
        textArea = new TextArea("");


        textArea.setBounds(100, 100, 300, 300);
        buttonStart.setBounds(70, 400, 150, 30);
        buttonStop.setBounds(260, 400, 150, 30);


        add(buttonStart);
        add(buttonStop);
        add(textArea);

        buttonStart.addActionListener(new ButtonActionListener());
        buttonStop.addActionListener(new StopButtonActionListener());

        setVisible(true);
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

    public void messageWriter(String message,int sleepTime) {
        flag = true;
        while (flag) {
            textArea.append(Thread.currentThread().getName()+" :: "+message+"\n");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread class for the counter logic
    public class ThreadWriter extends Thread {
        private String message;
        private int sleepTime;
        public ThreadWriter(String message,int sleepTime) {
            this.message = message;
            this.sleepTime = sleepTime;
        }
        @Override
        public void run() {
           messageWriter(this.message,this.sleepTime);
        }
    }


    public class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (threadWriter1 == null || !threadWriter1.isAlive()) {
                threadWriter1 = new ThreadWriter("I amd Writer 1",500);
                threadWriter1.start();
            }
            if (threadWriter2 == null || !threadWriter2.isAlive()) {
                threadWriter2 = new ThreadWriter("I am Writer 2",10000);
                threadWriter2.start();
            }
        }
    }

}
