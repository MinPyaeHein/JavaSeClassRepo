package com.jdbc_v3_lec.service;

import com.jdbc_v3_lec.dao.EmployeeDao;
import com.jdbc_v3_lec.model.Employee;

import java.util.List;




public class EmployeeService{
	private EmployeeDao employeeDao;
	public EmployeeService() {
		this.employeeDao = new EmployeeDao();
	}
	 public String  addEmployee(Employee employee) {
	        String message="";
	        if(employeeDao.saveEmployee(employee)) {
	            message = "Employee added successfully";
	        } else {
	            message = "Employee not added";
	        }
	        return message;
	    }

	    public List<Employee> getEmployees() {
			employeeDao.updateTest(new Employee(1, "test", "test", "test"));
		return employeeDao.getAll();
	    }
		public String deleteEmployee(String id){
		    Boolean flag= employeeDao.deleteEmployee(Integer.parseInt(id));
		    if(flag==true){
				return "Employee deleted successfully";
			}else{
				return "Employee not deleted";
			}
		}

		public Employee getEmployeeById(String id){
		Employee employee= employeeDao.getEmployeeById(Integer.parseInt(id));
		return employee;
		}
	    
	 
	

}
