package com.practiesCollection;

public class Employee {
    private String name;
    private String address;
    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
