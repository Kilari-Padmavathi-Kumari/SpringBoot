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
            addEmployees(employeeDAO);
        };
    }

    private void addEmployees(EmployeeDAO employeeDAO) {
        Employee emp1 = new Employee("kavya", 1234, "kavya.doe@example.com");
        Employee emp2 = new Employee("junnu", 3456, "junnu.saripalli@example.com");
        Employee emp3 = new Employee("chitti", 2345, "chitti.saripalli@example.com");

        employeeDAO.save(emp1);
        employeeDAO.save(emp2);
        employeeDAO.save(emp3);
    }

}
