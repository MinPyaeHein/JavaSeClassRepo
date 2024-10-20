package com.jdbc_v3.service;

import com.jdbc_v3.dao.EmployeeDao;
import com.jdbc_v3.model.Employee;

import java.util.List;




public class EmployeeService{
	private EmployeeDao employeeDao;
	public EmployeeService() {
		this.employeeDao = new EmployeeDao();
	}
	 public String  addEmployee(Employee employee) {
	        String message="";
	        if(employeeDao.save(employee)) {
	            message = "Employee added successfully";
	        } else {
	            message = "Employee not added";
	        }
	        return message;
	    }

	    public List<Employee> getEmployees() {
	        return employeeDao.findAll();
	    }
		public String deleteEmployee(String id){
		    Boolean flag= employeeDao.deleteById(Integer.parseInt(id));
		    if(flag==true){
				return "Employee deleted successfully";
			}else{
				return "Employee not deleted";
			}
		}

		public Employee getEmployeeById(String id){
		Employee employee= employeeDao.findById(Integer.parseInt(id));
		return employee;
		}
	    
	 
	

}
