package com.centennial.springboot.demoapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server Hello " + LocalDateTime.now();
	}
	@GetMapping("/hi/{path}")
	public String sayHello2(@PathVariable String path) {
		return path + "'s Hello World " + LocalDateTime.now();
	}
	
	@Autowired
	private Employee employee;
	@RequestMapping("/employee/get")
	public Employee getEmployee(@RequestParam(name="empName", required=false, defaultValue="Unknown") String empName,
	@RequestParam(name="jobTitle", required=false, defaultValue="Unknown") String jobTitle,
	@RequestParam(name="salary", required=false, defaultValue="0.0") String salary )
	{
	employee.setEmpName(empName);
		employee.setJobTitle(jobTitle);
		employee.setSalary(Double.parseDouble(salary));
		return employee;
	}
	
	
	//@RequestMapping(value="/employee/update", method=RequestMethod.POST)
	@PostMapping(value="/employee/update")
	public Employee updateEmployee(@RequestParam(name="empName", required=false, defaultValue="Unknown") String empName,
			@RequestParam(name="jobTitle", required=false, defaultValue="Unknown") String jobTitle,
			@RequestParam(name="salary", required=false, defaultValue="0.0") String salary )
			{
			employee.setEmpName(empName);
				employee.setJobTitle(jobTitle);
				employee.setSalary(Double.parseDouble(salary));
				return employee;
			}
}