package com.GUIProject.StudentRegister.GUIMenuBar.views;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private JLabel labelContent;
    public ContentPanel(){
        this.labelContent = new JLabel("Content");
        this.add(this.labelContent);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(400, 400);
        this.setVisible(true);
    }
}
