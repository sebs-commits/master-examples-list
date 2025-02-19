package com.example.jpa;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="department")
public class Department {
	//Recommend to use lower case column names in your annotations to avoid certain naming convention issues.
	@Id
	@Column(name="deptno")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Database assigns primary keys for the entity using a database identity column.

	private int deptno;
	
    @NotBlank(message = "Department Name is mandatory")
    @Column(name="deptname")
    private String deptname;
    
    @NotBlank(message = "Location is mandatory")
    @Column(name="location")
    private String location;    
    
    //Value of mappedBy attributes is the name of the field(object name declared) on the other side of the relationship 
	@OneToMany(mappedBy = "deptno")
	private List<Employee> employees;
	
    public Department()
    {
    	
    }
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
