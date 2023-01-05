package com.bcg.employee.dto;

import java.util.List;

import com.bcg.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeContractDTO {
	private Employee employee;
	private List<ContractTransaction> contractTransaction;
}
