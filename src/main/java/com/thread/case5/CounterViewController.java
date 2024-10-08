package com.thread.case5;

import com.thread.case4.TreadExercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterViewController {
    private CounterView counterView;
    private CounterService counterService;
    private int count=0;
    private Thread t =null;
    public CounterViewController(CounterView counterView){
        this.counterView = counterView;
        this.counterService = new CounterService(counterView.getLabel());
        this.counterView.getBtn2().addActionListener(new ButtonsActionListener());
        this.counterView.getBtn1().addActionListener(new ButtonsActionListener());
        this.counterView.getBtn3().addActionListener(new ButtonsActionListener());
    }
    public class ButtonsActionListener implements ActionListener {



        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("thread Name for ActionPerform: " + Thread.currentThread().getName());
            if (t == null || !t.isAlive()) {
                t=new Thread(){
                    @Override
                    public void run() {
                        while(true){
                            counterService.counter();
                            counterView.getLabel().setText("Count: "+counterService.getCount());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                };
                System.out.println("New Thread is Strating");
                t.start();
            }
            if (e.getSource()== counterView.getBtn1()) {
                System.out.println("Arrive to btn1");
                counterService.setStop(false);
                counterService.setIncrement(true);
            } else if (e.getSource() == counterView.getBtn2()) {
                System.out.println("Arrive to btn2");
                counterService.setStop(false);
                counterService.setIncrement(false);
            } else {
                counterService.setStop(true);
            }
        }
    }

}
