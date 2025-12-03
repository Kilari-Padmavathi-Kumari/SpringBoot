package com.curdoperations.cruddemo;

import com.curdoperations.cruddemo.dao.EmployeeDAO;
import com.curdoperations.cruddemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
        return runner -> {

            // Save example
            Employee emp1 = new Employee("Josh", 1234567890, "josh@example.com");
            employeeDAO.save(emp1);

            // Find by ID
            Employee emp = employeeDAO.findById(emp1.getId());
            System.out.println("Found: " + emp);

            // Find all
            System.out.println("All Employees: " + employeeDAO.findAll());

            // Update
            emp.setName("Josh Updated");
            employeeDAO.update(emp);

            // Delete by ID
            employeeDAO.deleteById(emp.getId());

            // Delete all (use carefully!)
            // employeeDAO.deleteAll();
        };
    }

}

























/*package com.curdoperations.cruddemo;

import com.curdoperations.cruddemo.dao.EmployeeDAO;
import com.curdoperations.cruddemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
        return runner -> {

            //  Create and save employee
            Employee temp = new Employee("Padma", 987654321, "padma@gmail.com");

            //  You do NOT have save() method in DAO, so add it
            employeeDAO.save(temp);

            //  Read it by ID
            Employee emp = employeeDAO.findById(temp.getId());

            System.out.println("Employee Found: " + emp);
        };
    }

}*/
