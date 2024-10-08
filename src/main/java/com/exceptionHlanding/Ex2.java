package com.exceptionHlanding;

import java.util.InputMismatchException;

public class Ex2 {
    String[] values;
    public Ex2(){
        values=new String[5];
        values[0]="Apple";
        values[1]="Orange";
        values[2]="Banana";
        values[3]="Steel";
        values[4]="Grape";
    }
    public void getName(){
        System.out.println("Enter Yout Name");
        String name=System.console().readLine();
        System.out.println("Hello "+name);
        System.out.println("Length of Name: "+name.length());
        throw new InputMismatchException();

    }
    public void getNameFromArray(int value)throws  NullPointerException{
      System.out.println("Your Fruit is::"+values[value]);

    }
}
