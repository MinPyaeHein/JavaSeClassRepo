package com.jdbc_v1_practice.service.imp;

import com.jdbc_v1_practice.dao.impl.StudentDao;
import com.jdbc_v1_practice.modal.Student;
import com.jdbc_v1_practice.service.Service;

import java.util.List;

public class StudentService implements Service<Student> {
    private StudentDao studentDao;
    public StudentService(){
       this.studentDao= new StudentDao();
    }
    public void save(Student student){
        this.studentDao.insert(student);
    }
    public void update(Student student){
        this.studentDao.update(student,"student_id");
    }
    public List<Student> getAll(){
       return this.studentDao.selectAll();
    }
    public Student getById(int id){
        return this.studentDao.selectById(id);
    }
    public void delete(Student student){
        this.studentDao.delete(student);
    }
}
