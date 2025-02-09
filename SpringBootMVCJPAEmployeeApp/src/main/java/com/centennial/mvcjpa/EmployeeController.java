package com.centennial.mvcjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository empRepository;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(@RequestParam("empId") int empId,
			@RequestParam("empName") String empName,
			@RequestParam("jobTitle") String jobTitle,
			@RequestParam("salary") double salary,
			@RequestParam("deptNo") int deptNo)
    {
		  Employee employee=new Employee(empId,empName,jobTitle,salary,deptNo);
          empRepository.save(employee);
	      return new ModelAndView("show","employees", empRepository.findAll());
    }
	
	  //@GetMapping("/edit") //alternate way
      @RequestMapping("/edit")
      public String Modify()
      {
                return "edit";
      }
      
	//@PostMapping("/update") // alternate way
	@RequestMapping(value="/update", method = RequestMethod.POST)
	//public ModelAndView edit(Employee employee) //@ModelAttribute optional
	public ModelAndView edit(@ModelAttribute Employee employee) 
	{
	      empRepository.save(employee);
	      ModelAndView mview = new ModelAndView("show");
	      mview.addObject("employees", empRepository.findAll());
	      return mview;
	}
	
    @GetMapping("/finddelete/{empId}")
  	public ModelAndView find(@PathVariable("empId") int empId)
  	{
    	  empRepository.deleteById(empId);
	      ModelAndView mview = new ModelAndView("show");
	      mview.addObject("employees", empRepository.findAll());
	      return mview;
  	}
    
    @RequestMapping("/find/{job}")
  	public ModelAndView findByJob(@PathVariable("job") String jobTitle)
  	{
	      ModelAndView mview = new ModelAndView("show");
	      mview.addObject("employees", empRepository.findByJobTitle(jobTitle));
	      return mview;
  	}
    
	@RequestMapping("/show")
    public String show(Model model)
    {
        model.addAttribute("employees", empRepository.findAll());
        return "show";
    }    
}