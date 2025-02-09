package com.example.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpa2Application  implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa2Application.class, args);
	}


    public void run(String...args) throws Exception {
     
        Iterable<Employee> iterator = repository.findAll();
         
        System.out.println("All the Employees: ");
        iterator.forEach(item -> System.out.println(item));
        System.out.println("# of employees:" + repository.count());
        System.out.println("ID exists : "+repository.existsById(2131));
        System.out.println("ID exists : "+repository.findById(2125));
        
	}
}
