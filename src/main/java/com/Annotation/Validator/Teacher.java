package com.Annotation.Validator;

public class Teacher {
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Invalid phone number")
    private String phoneNumber;
    @NotNull(message = "Department cannot be null")
    private String department;
    @NotNull(message = "Position cannot be null")
    private String position;
    @NotNull(message = "Address cannot be null")
    private String address;
    @NotNull(message = "Phone cannot be null")
    private String phone;

}
