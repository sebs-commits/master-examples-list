package com.centennial.mvcjpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	// Custom Query
	List<Employee> findByJobTitle(String title);
	
	//Native Query
	//@Query(value = "SELECT * FROM employee WHERE jobtitle = :title", nativeQuery = true)
	//List<Employee> findByJobTitle(String title);
	
	//@Query(value = "SELECT * FROM employee WHERE jobtitle = :title and salary > 75000", nativeQuery = true)
	//List<Employee> findByJobTitle(String title);
	
	//Indexed Query - JPQL JPA Query Language
	//@Query("SELECT e FROM Employee e WHERE e.jobTitle = ?1")
	//List<Employee> findByJobTitle(String title);
	
	//Named Parameter Query - JPQL
	//@Query("SELECT e FROM Employee e WHERE e.jobTitle = :jobtitle and e.salary < 75000")
	//List<Employee> findByJobTitle(@Param("jobtitle") String title);

}
