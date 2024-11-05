package com.jdbc_v1_practice.modal;


import java.util.ArrayList;
import java.util.List;

public class Major {
    private int id;
    private String name;
    private String description;
    private List<Student> students;

    public Major(int id, String name, String description) {
        this.students = new ArrayList<Student>();
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void setStudent(Student student){
        this.students.add(student);
    }
}
