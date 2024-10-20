package com.Annotation;
 class A{
    public void display(){

    }
}
class B extends A{
    @Override()
    public void display(){
        System.out.println("B's display method");
    }
}
public class TestOverride {
     public static void main(String[] args) {
        B obj = new B();
        obj.display();
    }
}
