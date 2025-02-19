package com.example.jpa;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDepartmentData {
	
	private int empId;
	private String empName;
	private String jobTitle;
	private double salary;
	private int deptno;
    private String deptname;
    private String location;
    
		public EmployeeDepartmentData()
		{
			
		}
		
		
		public EmployeeDepartmentData(int empId, String empName, String jobTitle, double salary, int deptno,String location, String deptname) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.jobTitle = jobTitle;
			this.salary = salary;
			this.deptno = deptno;
			this.deptname = deptname;
			this.location = location;
		}


		//setter and getter methods
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int id) {
			this.empId = id;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String name) {
			this.empName = name;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String job) {
			this.jobTitle = job;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double sal) {
			this.salary = sal;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno=deptno;
		}


		public String getDeptname() {
			return deptname;
		}


		public void setDeptname(String deptname) {
			this.deptname = deptname;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}

	

}
