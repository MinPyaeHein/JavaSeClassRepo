package com.Enum;

public enum Pizza {
    CHEESE(200),
    VEGGIE(300),
    PEPPERONI(400),
    CLAM(500),
    VEGGIE_CLAM(600);
    private int price;
    Pizza(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public static Pizza getPizza(String name) {
        return Pizza.valueOf(name);
    }
}
