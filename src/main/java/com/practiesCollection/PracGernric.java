package com.practiesCollection;

public class PracGernric {
    //Cause1
    public void displayString(String str) {
        System.out.println("String: " + str);
    }
    public void displayInteger(Integer num) {
        System.out.println("Integer: " + num);
    }
    public void displayDouble(Double dec) {
        System.out.println("Double: " + dec);
    }
    //Case2
    public void displayGeneral(Object obj) {
        System.out.println("Object: " + obj.getClass().getName()+" " + obj);
    }
    //Case3
    public <T> void displayGeneric(T obj) {
        System.out.println("Generic: " + obj.getClass().getName()+" " + obj);
    }
}
