package com.example.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
    @ManyToOne
    @JoinColumn(name = "deptno", nullable = false)
    private Department deptno;
    
		public Employee()
		{
			
		}
		
		
		public Employee(int empId, String empName, String jobTitle, double salary, Department deptNo) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.jobTitle = jobTitle;
			this.salary = salary;
			this.deptno = deptNo;
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
		public Department getDeptno() {
			return deptno;
		}
		public void setDeptno(Department deptno) {
			this.deptno=deptno;
		}

	

}
