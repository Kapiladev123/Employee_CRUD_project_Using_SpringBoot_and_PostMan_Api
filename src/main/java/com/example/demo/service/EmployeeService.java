package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Employee;

public interface EmployeeService {

	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	Employee updateEmployee(Employee employee, int id);
	
	void deleteEmployee(int id);
}
