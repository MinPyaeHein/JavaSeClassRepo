package com.practice.interfacing;

public class NormalClass implements InterFace1{
    @Override
    public void displayName() {
        System.out.println("Hello form normal class");
    }

    @Override
    public void fly() {
       System.out.println("Normal class can fly");
    }

    @Override
    public void swim() {
      System.out.println("Normal class can swim");
    }

    @Override
    public void eat() {
        System.out.println("Normal class can eat");

    }
    @Override
    public void sleep() {
        System.out.println("Normal class can sleep");

    }
}
