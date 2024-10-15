package com.AbstractTheory;

public abstract class Human {
    private String name;
    public Human() {
        this.name = "default";
        System.out.println("Human constructor called");
    }
    public Human(String name) {
        this.name = name;
        System.out.println("Human One Arg constructor called");
    }
    public String getName() {
        return name;
    }
    public abstract void work();
}
