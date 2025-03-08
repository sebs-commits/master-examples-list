package com.centennial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
	
	@Autowired
    EmployeeRepository empRepository;

// Get All Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }
    
    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    Employee getEmployee(@PathVariable("empId") int empId) throws Exception {
	    Employee emp= empRepository.findById(empId)
		  	      .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + empId));
        return emp;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addEmployee(@RequestBody Employee emp) throws Exception {
    	empRepository.save(emp);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee emp) throws Exception {
        empRepository.save(emp);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteEmployee(@PathVariable("empId") int empId) throws Exception {
	    Employee emp= empRepository.findById(empId)
	  	      .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + empId));
	  	  empRepository.delete(emp);
    }
    
}
