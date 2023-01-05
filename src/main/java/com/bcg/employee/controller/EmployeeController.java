package com.bcg.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcg.employee.dto.EmployeeContractDTO;
import com.bcg.employee.entity.Employee;
import com.bcg.employee.exception.EmployeeNotFoundException;
import com.bcg.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getEmpById/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		
		Optional<Employee> empOp = employeeService.getEmployeeById(id);
		Employee employee =null;
		if(empOp.isPresent()) {
			employee = empOp.get();
		}else {
			throw new EmployeeNotFoundException();
		}
		return employee;
	}
	
	@GetMapping("/getEmployeeWithContractDetails/{id}")
	public EmployeeContractDTO getEmployeeWithContractDetails(@PathVariable Long id) {
		return employeeService.getEmployeeWithContractDetails(id);
	}
	
	
}
