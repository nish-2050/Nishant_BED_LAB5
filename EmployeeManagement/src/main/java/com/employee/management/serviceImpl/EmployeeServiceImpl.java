package com.employee.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Employees;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employees> findAllEmployees() {

		return (List<Employees>) employeeRepository.findAll();
	}
	@Override
	public Employees findEmployeeById(int id) {
		Optional<Employees> result = employeeRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Employees();
	}
	
	
	@Override
	public Employees addEmployee(Employees employee) {
		return employeeRepository.save(employee);
	}
	
	
	@Override
	public Employees updateEmployee(Employees employee) {
		
		Optional<Employees> result = employeeRepository.findById(employee.getId());
		Employees existing= result.get();
		existing.setFirstName(employee.getFirstName());
		existing.setLastName(employee.getLastName());
		existing.setEmail(employee.getEmail());
		
		return employeeRepository.save(existing);
		
	}

	
	@Override
	public void deleteEmployeeById(int id) {
		 this.employeeRepository.deleteById(id);
	}
	
}
