package com.Enum;

enum Color{
    RED, GREEN, LIGHT_BLUE, YELLOW, PINK;
}
public class MainApp {
    public static void main(String[] args) {
    Color color = Color.RED;
    System.out.println("Color: " + color);

    int price=Pizza.CHEESE.getPrice();
    System.out.println("CHEESE: " + price);

    switch (color) {
        case RED:
            System.out.println("Color is RED");
            break;
        case GREEN:
            System.out.println("Color is GREEN");
            break;
        case LIGHT_BLUE:
            System.out.println("Color is BLUE");
            break;
        case YELLOW:
            System.out.println("Color is YELLOW");
            break;
        case PINK:
            System.out.println("Color is PINK");
            break;
        default:
            System.out.println("Unknown color");
            break;
    }
    for (Color color1 : Color.values()) {
        System.out.println("Color: " + color1);
    }
    Day monday=Day.MONDAY;
    monday.printDay();
    System.out.print("Monday Values::"+monday.day);
    }
}
