package com.GUIProject.StudentRegister.GUIMenuBar;

import com.GUIProject.StudentRegister.GUIMenuBar.controller.HomeController;
import com.GUIProject.StudentRegister.GUIMenuBar.views.HomeView;

public class MainApp {

    public static void main(String[] args) {

      HomeController controller=new HomeController(new HomeView());

    }
}
