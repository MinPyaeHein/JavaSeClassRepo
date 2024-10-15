package com.GUIProject.StudentRegister.GUIMenuBar.views;

import javax.swing.*;
import java.awt.*;

public class HomePanal extends JPanel {
    private JLabel labelHome;
    public HomePanal(){
        this.labelHome = new JLabel("Home");
        this.add(this.labelHome);
        this.setBackground(Color.BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(200, 200);
        this.setVisible(true);
    }
}
