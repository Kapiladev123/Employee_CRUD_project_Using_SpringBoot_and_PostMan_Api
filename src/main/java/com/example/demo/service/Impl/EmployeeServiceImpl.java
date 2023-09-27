package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service 
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;



	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	//started from here

	@Override
	public Employee saveEmployee(@RequestBody Employee employee) {

		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(int id) {
		//		Optional<Employee> employee=employeeRepository.findById(id);
		//		if(employee.isPresent()) {
		//			return employee.get();
		//		}
		//		else {
		//			throw new ResourceNotFoundException("Employee", "id", id);
		//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "id", id));

	}



	@Override
	public Employee updateEmployee(Employee employee, int id) {
		//need to check the id is present in data base or not
		Employee employee2=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		employee2.setName(employee.getName());
		employee2.setCity(employee.getCity());
		employee2.setAge(employee.getAge());
		employee2.setSalary(employee.getSalary());
		return  employeeRepository.saveAndFlush(employee2);
	}



	@Override
	public void deleteEmployee(int id) {
		//check id is present  or not in data base
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);

	}



}
