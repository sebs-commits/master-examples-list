package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    
	@Autowired
	RestTemplate restTemplate;

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }
    
    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public ModelAndView display(@ModelAttribute Employee employee)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeinfo");	
        mv.addObject("employeeList", restTemplate.getForObject("http://localhost:8080/employees", Employee[].class));
        return mv;
    }
    
    @RequestMapping("/create")
    public String create()
    {
        return "create";
    }
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeinfo");
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        restTemplate.postForObject("http://localhost:8080/employee", request, Employee.class);
        mv.addObject("employeeList", restTemplate.getForObject("http://localhost:8080/employees", Employee[].class));
        return mv;
    }
    
	//edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Employee emp = restTemplate.getForObject("http://localhost:8080/employee/"+ no, Employee.class);
	    model.addAttribute("employee", emp);
	    return "update-emp";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Employee employee, Model model) {
		HttpEntity<Employee> request = new HttpEntity<>(employee);
		restTemplate.put("http://localhost:8080/employee/" + employee.getEmpId(), request, Employee.class);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeinfo");	
        mv.addObject("employeeList", restTemplate.getForObject("http://localhost:8080/employees", Employee[].class));
        return mv;
	}
	
	//delete request
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int no, Model model) {
	    Employee emp = restTemplate.getForObject("http://localhost:8080/employee/"+ no, Employee.class);
		HttpEntity<Employee> request = new HttpEntity<>(emp);
		restTemplate.delete("http://localhost:8080/employee/" + emp.getEmpId(), request, Employee.class);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeinfo");	
        mv.addObject("employeeList", restTemplate.getForObject("http://localhost:8080/employees", Employee[].class));
        return mv;
	}	
}
