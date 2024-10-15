package com.AbstractTheory;

 class Student extends Human{
    @Override
    public void work() {
        System.out.println("Student " + getName() + " is Studying");
    }
}
