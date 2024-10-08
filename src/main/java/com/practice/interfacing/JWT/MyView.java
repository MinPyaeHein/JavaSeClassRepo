package com.practice.interfacing.JWT;

import java.awt.*;

public class MyView extends Frame {
    public MyView() {
        super.setVisible(true);
        super.setSize(300, 300);
        super.setTitle("My View");
        super.addWindowListener(new MyWindowListener());
    }
}
