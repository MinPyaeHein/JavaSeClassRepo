package com.practice.interfacing;

public interface InterFace1 extends InterFace0 {
    public static int num=10;//can accept from class name
    public static final String str = "abc";
    public int num1=12;//Can only accept from the object
//    public void display(){
//        System.out.println("Hello");
//    }
    public static void display(){
       System.out.println("Hello");
   }
    public void displayName();
    public void eat();
    public void sleep();




}
