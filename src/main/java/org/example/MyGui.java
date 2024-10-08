package org.example;

import java.awt.*;
import java.awt.event.WindowListener;

public class MyGui extends Frame {
public MyGui() {
    super.setVisible(true);
    super.setSize(300, 300);
    super.setTitle("MyGui");
    super.addWindowListener(new MyWindowListener() {});

}
}
