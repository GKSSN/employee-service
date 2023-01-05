package com.bcg.employee.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcg.employee.controller.RestTemplateResponseErrorHandler;
import com.bcg.employee.dto.ContractTransaction;
import com.bcg.employee.dto.EmployeeContractDTO;
import com.bcg.employee.entity.Employee;
import com.bcg.employee.exception.ContractTransactionNotFoundException;
import com.bcg.employee.exception.EmployeeNotFoundException;
import com.bcg.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RestTemplate restTemplate;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public EmployeeContractDTO getEmployeeWithContractDetails(Long id) {
		EmployeeContractDTO employeeContractDTO = new EmployeeContractDTO();
		Optional<Employee> employeeOp = employeeRepository.findById(id);
		Employee employee = null;
		ContractTransaction[] contractTransactions = null;
		if (employeeOp.isPresent()) {
			employee = employeeOp.get();
			restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
			contractTransactions = restTemplate.getForObject(
					"http://localhost:9091/bcg/getAllContractsByEmp/" + employee.getId(), ContractTransaction[].class);

		} else {
			throw new EmployeeNotFoundException();
		}

		employeeContractDTO.setEmployee(employee);
		employeeContractDTO.setContractTransaction(Arrays.asList(contractTransactions));
		return employeeContractDTO;

	}
}
