package net.java.springboot.service;

import java.util.List;

import net.java.springboot.model.Employee;


public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee e);
}
