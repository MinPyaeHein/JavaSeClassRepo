package com.GUIProject.StudentRegister.GUIMenuBar.views;

import javax.swing.*;

public class HomeView extends JFrame {
 private JMenuBar menuBar;
 private JMenuItem menuItem1, menuItem2, menuItem3;
 private JMenu menuHome;
 private JDesktopPane desktopPane;

    public HomeView() {
        this.desktopPane = new JDesktopPane();
        this.menuBar= new JMenuBar();
        this.menuHome = new JMenu("Home");
        this.menuItem1 = new JMenuItem("Home");
        this.menuItem2 = new JMenuItem("Content");
        this.menuItem3 = new JMenuItem("Product");
        this.menuHome.add(menuItem1);
        this.menuBar.add(this.menuHome);
        this.menuBar.add(menuItem2);
        this.menuBar.add(menuItem3);

        this.setTitle("Register");
        this.setSize(400, 300);
        this.setJMenuBar(this.menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.desktopPane);
        this.setVisible(true);
    }




    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuItem getMenuItem1() {
        return menuItem1;
    }

    public void setMenuItem1(JMenuItem menuItem1) {
        this.menuItem1 = menuItem1;
    }

    public JMenuItem getMenuItem2() {
        return menuItem2;
    }

    public void setMenuItem2(JMenuItem menuItem2) {
        this.menuItem2 = menuItem2;
    }

    public JMenuItem getMenuItem3() {
        return menuItem3;
    }

    public void setMenuItem3(JMenuItem menuItem3) {
        this.menuItem3 = menuItem3;
    }



    public JMenu getMenuHome() {
        return menuHome;
    }

    public void setMenuHome(JMenu menuHome) {
        this.menuHome = menuHome;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }
}
