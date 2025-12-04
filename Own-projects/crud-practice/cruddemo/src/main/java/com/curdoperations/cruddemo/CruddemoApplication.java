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
            queryForEmployeesByName(employeeDAO, "Saripalli");
            //updateEmployeeExample(employeeDAO, 1);
            deleteEmployeeById(employeeDAO, 2);
            deleteAllEmployees(employeeDAO);
            listAllEmployees(employeeDAO);
        };
    }

    private void addEmployees(EmployeeDAO employeeDAO) {
        Employee emp1 = new Employee("John", 123, "john.doe@example.com");
        Employee emp2 = new Employee("Jane", 3456, "jane.saripalli@example.com");
        Employee emp3 = new Employee("Mike", 2345, "mike.saripalli@example.com");

        employeeDAO.save(emp1);
        employeeDAO.save(emp2);
        employeeDAO.save(emp3);
    }

    private void queryForEmployeesByName(EmployeeDAO employeeDAO, String name) {
        List<Employee> employees = employeeDAO.findByName(name);

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    /*private void updateEmployeeExample(EmployeeDAO employeeDAO, int id) {
        Employee emp = employeeDAO.findById(id);


        emp.setEmail("updated.email@example.com");
        employeeDAO.update(emp);
        System.out.println("Updated employee: " + emp);
    }
*/
    private void deleteEmployeeById(EmployeeDAO employeeDAO, int id) {
        employeeDAO.deleteById(id);
        System.out.println("Deleted employee with id: " + id);
    }

    private void deleteAllEmployees(EmployeeDAO employeeDAO) {
        int count = employeeDAO.deleteAll();
        System.out.println("Deleted " + count + " employees.");
    }

    private void listAllEmployees(EmployeeDAO employeeDAO) {
        List<Employee> employees = employeeDAO.findAll();

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
