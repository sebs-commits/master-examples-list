package com.example.jpa;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

	@Autowired 
	private DepartmentRepository deptRepository;
	@Autowired 
	private EmployeeRepository empRepository;
	
	//To get the list of employees
	@GetMapping("/")
	public ModelAndView home(Model model)
	{
		return new ModelAndView("show","employees", empRepository.findAll());
	}

	//To get the list of departments
	@GetMapping("/departments")
	public String homedept(Model model)
	{
		model.addAttribute("departments", deptRepository.findAll());
	    return "index";
	}
	
	@RequestMapping("/addemp")
	public String addform() {
		return "add-emp";
	}
	
	@RequestMapping(value="/addemployee")
	public ModelAndView add(@RequestParam("empId") int empId,
			@RequestParam("empName") String empName,
			@RequestParam("jobTitle") String jobTitle,
			@RequestParam("salary") double salary,
			@RequestParam("deptNo") int deptNo)
    {
			Department dept= deptRepository.findById(deptNo)
					.orElseThrow(() -> new IllegalArgumentException("Invalid department Number:" + deptNo));
			Employee employee=new Employee(empId,empName,jobTitle,salary,dept);
			empRepository.save(employee);
	      return new ModelAndView("show","employees", empRepository.findAll());
    }
	
	@RequestMapping("/adddept")
	public String adddeptform(Department department) {
		return "add-dept";
	}
	
	//add the department info
	@PostMapping("/add")
    public String add(@Valid Department department, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-dept";
        }
        deptRepository.save(department);

        model.addAttribute("departments", deptRepository.findAll());
        return "index";
    }

	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Department dept = deptRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid department number:" + no));

	    model.addAttribute("department", dept);
	    return "update-dept";
	}
	//update the existing department info
	@PostMapping("/update")
	public String update(@Valid Department department,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "update-dept";
	    }

	    deptRepository.save(department);
	    model.addAttribute("departments", deptRepository.findAll());
	    return "index";
	}
	//delete a department info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    Department dept= deptRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid department Number:" + no));
	    deptRepository.delete(dept);
        model.addAttribute("departments", deptRepository.findAll());
	    return "index";
	}
	
	@RequestMapping("/EmpHighSal/{salary}")
    public ModelAndView findBySalaryGreaterThan(@PathVariable("salary") double salary)
    {
		 return new ModelAndView("show","employees", empRepository.findBySalaryGreaterThan(salary));
    }
	
	
	@RequestMapping("/showdeptempDTO/{deptno}")
    public ModelAndView showed(@PathVariable("deptno") int deptno)
    {
		 return new ModelAndView("showdeptemp","departmentemployees", empRepository.findEmployeesByDeptnoDTO(deptno));
    } 

	@RequestMapping("/showdeptemp/{deptno}")
    public ModelAndView showednodto(@PathVariable("deptno") int deptno)
    {
		 return new ModelAndView("show","employees", empRepository.findEmployeesByDeptno(deptno));
    }
	
	@GetMapping("/deptsHighSal/{salary}")
	public ModelAndView findDepartmentsWithHighSalaries(@PathVariable("salary") double salary)
	{
		return new ModelAndView("index","departments", empRepository.findDepartmentsWithHighSalaries(salary));
	}
	
}
