package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employees;

public interface EmployeeService {

	List<Employees> findAllEmployees();

	Employees findEmployeeById(int id);

	Employees addEmployee(Employees employee);

	Employees updateEmployee(Employees employee);

	void deleteEmployeeById(int id);

}