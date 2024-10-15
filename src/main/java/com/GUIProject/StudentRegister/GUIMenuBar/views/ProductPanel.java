package com.GUIProject.StudentRegister.GUIMenuBar.views;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel{
    private JLabel labelProduct;
    public ProductPanel(){
        this.labelProduct = new JLabel("Product");
        this.setBackground(Color.CYAN);
        this.add(this.labelProduct);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(300, 300);
        this.setVisible(true);
    }
}
