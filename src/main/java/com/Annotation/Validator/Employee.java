package com.Annotation.Validator;

public class Employee {
    @NotNull(message = "Name cannot be null!!")
    private String name;
    @NotNull(message = "Description cannot be null!!")
    private String description;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}