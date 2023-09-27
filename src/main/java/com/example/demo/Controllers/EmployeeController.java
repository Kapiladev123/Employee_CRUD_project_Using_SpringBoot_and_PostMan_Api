package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build create employee REST API
	@PostMapping("/insert")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println("Data Inserted SuccessFully");
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	//build get all employee REST API
	@GetMapping("/get")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

	//build get employeeById REST API
	//http://localhost:8080/api/ById/1  <-  pass the id number
	@GetMapping("ById/{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable("id") int EmployeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(EmployeeId),HttpStatus.OK);
	}
	//build update Employee By id
	//http://localhost:8080/api/ById/1  <-  pass the id number
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	//build update Employee By id
	//http://localhost:8080/api/ById/1  <-  pass the id number
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted SuccessFully.!", HttpStatus.OK);
	}
}
