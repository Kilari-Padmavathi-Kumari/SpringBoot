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

            List<Employee> employees = employeeDAO.findAll();

            for (Employee emp : employees) {
                System.out.println(emp);
            }

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
