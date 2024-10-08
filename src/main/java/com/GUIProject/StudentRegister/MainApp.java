package com.GUIProject.StudentRegister;

public class MainApp {

    public static void main(String[] args) {
        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView);

    }
}
