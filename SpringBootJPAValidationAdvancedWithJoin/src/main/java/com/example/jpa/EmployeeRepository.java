package com.example.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	// Custom Query by method name
	List<Employee> findBySalaryGreaterThan(double salary);
	
	// Custom Query by JPA JPQL 
	// Using the Java object relations to easily join database
	
	//Example with DTO - Using dto style object to transfer data between application layers
	@Query("select new com.example.jpa.EmployeeDepartmentData(e.empId, e.empName, e.jobTitle, e.salary, d.deptno, d.location, d.deptname) FROM Employee AS e JOIN e.deptno AS d WHERE d.deptno = ?1")
	List<EmployeeDepartmentData> findEmployeesByDeptnoDTO(Integer id);
	
	@Query("SELECT d.employees FROM Department d WHERE d.deptno = ?1") //JPQL named indexed query
    List<Employee> findEmployeesByDeptno(Integer id);
	
	@Query("SELECT DISTINCT e.deptno FROM Employee e WHERE e.salary > :salary") //JPQL named param query
    List<Department> findDepartmentsWithHighSalaries(@Param("salary") double salary);
	
}
