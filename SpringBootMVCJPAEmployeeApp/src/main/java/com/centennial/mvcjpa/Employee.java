package com.centennial.mvcjpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Employee entity class - Model class
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="empid")
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="jobtitle")
	private String jobTitle;
	private double salary;
	@Column(name="deptno")
    private int deptNo;
    
		public Employee()
		{
			
		}
		
		
		public Employee(int empId, String empName, String jobTitle, double salary, int deptNo) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.jobTitle = jobTitle;
			this.salary = salary;
			this.deptNo = deptNo;
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
		public int getDeptNo() {
			return deptNo;
		}
		public void setDeptNo(int no) {
			this.deptNo=no;
		}

	

}
