package com.jdbc_v1_practice;

import com.jdbc_v1_practice.modal.Book;
import com.jdbc_v1_practice.modal.Major;
import com.jdbc_v1_practice.modal.Student;
import com.jdbc_v1_practice.service.imp.BookService;
import com.jdbc_v1_practice.service.imp.StudentService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
      StudentService  studentService=new StudentService();
      BookService bookService=new BookService();
      System.out.println(studentService.getById(7));

        Major major=new Major(1,"CSE","Computer Science and Engineering");
        Student student1=new Student("lin Lin","lin@gmail.com8","09523525 8","Thailand",major);
        studentService.save(student1);

    }
}
