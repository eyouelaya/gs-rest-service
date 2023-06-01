package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeControllerTest {
@Autowired
private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    // Helper function to get the number of current employees
    int getEmployeeCount(EmployeeManager manager)
    {
        return manager.getAllEmployees().getEmployees().size();
    }

    @Test
        // Ensure that employee list is populated on initialization
    void createEmployeeManager() {
        EmployeeManager newEmployeeManager = new EmployeeManager();
        assert(getEmployeeCount(newEmployeeManager) != 0);
    }

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

    //create a sample employee to test if items are added to the right field
    @ExtendWith(MockitoExtension.class)
    @BeforeEach
    void setUp()
    {
        this.employeeManager = new EmployeeManager();
        Employee newEmployee = new Employee("003","test3","test3 last","email3","title3");
        this.employeeManager.addEmployee(newEmployee);
    }

    @Test
        // Check whether added employee ID is found in ID field
    void employeeIdInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees().getEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getEmployee_id() == "003")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee first name is found in first name field
    void employeeFirstNameInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees().getEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getFirst_name() == "test3")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee last name is found in last name field
    void employeeLastNameInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees().getEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getLast_name() == "test3 last")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee email is found in email field
    void employeeEmailInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees().getEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getEmail() == "email3")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee title is found in title field
    void employeeTitleInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees().getEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getTitle() == "title3")
            {
                return;
            }
        }
        assert(false);
    }

}