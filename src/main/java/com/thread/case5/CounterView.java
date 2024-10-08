package com.thread.case5;

import javax.swing.*;

public class CounterView extends JFrame{
    private JLabel label;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private static int count = 0;
    public CounterView()  {
        super("Thread Exercise");
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Count: 0");
        label.setBounds(120, 50, 100, 30);
        add(label);

        btn1 = new JButton("Increase");
        btn1.setBounds(30, 100, 100, 25);
        add(btn1);

        // Decrease button
        btn2 = new JButton("Decrease");
        btn2.setBounds(150, 100, 100, 25);
        add(btn2);

        // Stop button
        btn3 = new JButton("Stop");
        btn3.setBounds(80, 140, 100, 25);
        add(btn3);
        setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public void setBtn3(JButton btn3) {
        this.btn3 = btn3;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        CounterView.count = count;
    }
}
