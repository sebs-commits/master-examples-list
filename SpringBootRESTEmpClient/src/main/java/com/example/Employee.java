package com.example;

public class Employee {
	
	private int empId;
	private String empName;
	private String jobTitle;
	private double salary;
	private int deptNo;
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo=deptNo;
	}
	
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

}
