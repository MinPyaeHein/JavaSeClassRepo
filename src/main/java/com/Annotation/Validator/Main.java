package com.Annotation.Validator;

public class Main {
    public static void main(String[] args)  {
        Employee employee = new Employee("Min Min");  // Invalid employee with null name
        Teacher teacher = new Teacher();

        try {
            Validator.validate(employee);
            Validator.validate(teacher);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
       // This will throw a RuntimeException

    }
}
