package com.AbstractTheory;

 class Teacher extends Human{
    public Teacher(String name) {
        super(name);
        System.out.println("Call Teacher one Arg Constructor!!!");
    }
    public Teacher(){
        System.out.println("Call Teacher default Constructor!!!");
    }
    @Override
    public void work() {
        System.out.println("Teacher " + getName() + " is teaching");
    }
}
