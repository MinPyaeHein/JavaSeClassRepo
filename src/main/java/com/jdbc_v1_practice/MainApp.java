package com.jdbc_v1_practice;

import com.jdbc_v1_practice.modal.Book;
import com.jdbc_v1_practice.modal.Student;
import com.jdbc_v1_practice.service.imp.BookService;
import com.jdbc_v1_practice.service.imp.StudentService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
      StudentService  studentService=new StudentService();
      BookService bookService=new BookService();
      bookService.update(new Book(6,"JDBC8","Huy8","JDBC is a Java Database Connectivity library8"));
      studentService.update(new Student(7,"Ni Ni8","ni@gmail.com8","09523525 8","Thailand8"));

    }
}
