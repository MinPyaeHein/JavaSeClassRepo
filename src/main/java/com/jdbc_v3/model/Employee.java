package com.jdbc_v3.model;

import com.jdbc_v3.Annotation.Table;

@Table(name = "employee")
public class Employee extends Person {
    private String extraField;
    public Employee(String name, String phone, String address) {
        super(name, phone, address);
    }
    public Employee(int id, String name, String phone, String address) {
        super(id, name, phone, address);

    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                '}';
    }

    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }
}