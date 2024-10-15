package com.Enum;



import java.io.*;

public enum Day {
    MONDAY(1){
        @Override
        public void printDay() {
            System.out.println("Monday: " + this.day);
        }
    };
    int day=0;
    Day(int day) {
        this.day = day;
    }
    abstract void printDay();


}
