package com.GUIProject.StudentRegister;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static List<Student> students  =new ArrayList<Student>();
    static{
        students.add(new Student("Min","min@gmail.com","0925235"));
        students.add(new Student("Max","max@gmail.com","64645345"));
        students.add(new Student("John","john@gmail.com","123456789"));
        students.add(new Student("Alice","alice@gmail.com","789456123"));
        students.add(new Student("Bob","bob@gmail.com","987654321"));
    }

    public static List<Student> getStudents() {
        return students;
    }
    public static void addStudent(Student student){
        students.add(student);
    }


}
