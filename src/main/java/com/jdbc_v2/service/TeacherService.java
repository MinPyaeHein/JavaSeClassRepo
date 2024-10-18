package com.jdbc_v2.service;

import com.jdbc_v2.dao.TeacherDao;
import com.jdbc_v2.model.Teacher;

import java.util.List;





public class TeacherService {
	private TeacherDao teacherDao;
	public TeacherService() {
		this.teacherDao = new TeacherDao();
	}
	 public String  addTeacher(Teacher teacher) {
	        String message="";
	        if(teacherDao.save(teacher)) {
	            message = "Teacher added successfully";
	        } else {
	            message = "Teacher not added";
	        }
	        return message;
	    }
	    public List<Teacher> getTeacher() {
	        return teacherDao.getAll();
	    }
	    
	 
	


}
