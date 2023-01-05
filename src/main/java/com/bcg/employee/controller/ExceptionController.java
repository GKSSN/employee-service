package com.bcg.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcg.employee.exception.ContractTransactionNotFoundException;
import com.bcg.employee.exception.EmployeeNotFoundException;
import com.bcg.employee.exception.ErrorMessage;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object>  employeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage("Employee Not Found");
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler (ContractTransactionNotFoundException.class)
	public ResponseEntity<Object> contractTransactionNotFoundException(ContractTransactionNotFoundException contractTransactionNotFoundException){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage("Contract Transaction for this employee is not Found");
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
