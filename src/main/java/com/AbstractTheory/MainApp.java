package com.AbstractTheory;


import com.Enum.Day;

public class MainApp {
    public static void main(String[] args) {
        Teacher theacher = new Teacher("Min");
        theacher.work();

        Teacher teacher1 = new Teacher();
        teacher1.work();
        Day day = Day.MONDAY;

    }
}
