package com.GUIProject.StudentRegister.GUIMenuBar.controller;

import com.GUIProject.StudentRegister.GUIMenuBar.views.ContentPanel;
import com.GUIProject.StudentRegister.GUIMenuBar.views.HomePanal;
import com.GUIProject.StudentRegister.GUIMenuBar.views.HomeView;
import com.GUIProject.StudentRegister.GUIMenuBar.views.ProductPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {
    private HomeView homeView;
    public HomeController(HomeView homeView){
        this.homeView = homeView;
        this.homeView.getMenuItem1().addActionListener(new MenuItemListener());
        this.homeView.getMenuItem2().addActionListener(new MenuItemListener());
        this.homeView.getMenuItem3().addActionListener(new MenuItemListener());

    }
    public class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click menu!!");
            homeView.getDesktopPane().removeAll();
            homeView.getDesktopPane().revalidate();
            homeView.getDesktopPane().repaint();
            if(e.getSource().equals(homeView.getMenuItem1())){
               System.out.println("Click home menu!!");

               homeView.getDesktopPane().add(new HomePanal());
           }else if(e.getSource().equals(homeView.getMenuItem2())){
               System.out.println("Click Content Menu!!");
               homeView.getDesktopPane().add(new ContentPanel());
           }else if(e.getSource().equals(homeView.getMenuItem3())){
               System.out.println("Click Product Menu!!");
               homeView.getDesktopPane().add(new ProductPanel());
           }
        }
    }
}
