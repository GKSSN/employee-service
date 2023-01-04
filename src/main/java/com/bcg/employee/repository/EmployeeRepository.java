package com.bcg.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcg.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
