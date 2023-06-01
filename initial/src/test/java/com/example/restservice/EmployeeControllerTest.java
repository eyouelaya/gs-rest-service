package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeControllerTest {
@Autowired
private EmployeeController employeeController;

    @Test
    void getEmployees() {
        assertNotNull(employeeController.getEmployees());
    }
    @Test
    void addEmployee() {
        List<Employee> employees =  employeeController.getEmployees().getEmployees();
        Employee newEmployee = new Employee("003","test3","test3 last","email3","title3");
        employeeController.addEmployee(newEmployee);
        assertTrue(employees.contains(newEmployee));
    }

}