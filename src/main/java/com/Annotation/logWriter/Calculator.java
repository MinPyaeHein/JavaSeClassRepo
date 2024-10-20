package com.Annotation.logWriter;

public class Calculator {
    @LogExecutionTime
    public int add(int a, int b) {
        return a + b;
    }

    @LogExecutionTime
    public int multiply(int a, int b) {
        return a * b;
    }


    public int sub(int a, int b) {
        return a * b;
    }
}
