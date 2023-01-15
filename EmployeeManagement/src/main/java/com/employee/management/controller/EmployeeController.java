package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.model.Employees;
import com.employee.management.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService  employeeServiceImpl;
	
	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("ListEmployees", employeeServiceImpl.findAllEmployees());
		return "home-page";
	}

	@GetMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("Employees", new Employees());
		return "add-employee";

	}

	@PostMapping("/addEmployee")
	public String createEmployee(Employees employee) {
		employeeServiceImpl.addEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String employeeUpdatePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("employee", employeeServiceImpl.findEmployeeById(id));
		return "update-employee";

	}
	@PostMapping("/updateEmployee")
	public String updateEmployee(Employees employee) {
		employeeServiceImpl.updateEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {
		this.employeeServiceImpl.deleteEmployeeById(id);
		return "redirect:/";
	}
	 


}
