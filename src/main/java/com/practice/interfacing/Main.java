package com.practice.interfacing;

public class Main {
    public static void main(String[] args) {
        NormalClass normalClass = new NormalClass();
        InterFace1 interface1 = new NormalClass(); // Compile-time error: cannot assign NormalClass to Interface1
        InterFace0 interface0 = new NormalClass(); // Compile-time error: cannot assign NormalClass to Interface0

        interface1.eat();
        interface1.swim();
        interface1.displayName();
        interface1.fly();
        interface1.eat();
        interface1.sleep();

//        interface0.eat();
        interface0.swim();
        interface0.displayName();
        interface0.fly();
//        interface0.sleep();

    }
}
