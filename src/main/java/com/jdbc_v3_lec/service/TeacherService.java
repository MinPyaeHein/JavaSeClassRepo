package com.jdbc_v3_lec.service;

import com.jdbc_v3_lec.dao.TeacherDao;
import com.jdbc_v3_lec.model.Teacher;

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
