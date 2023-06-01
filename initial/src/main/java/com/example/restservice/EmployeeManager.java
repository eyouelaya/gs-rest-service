package com.example.restservice;

import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {
    private static final Employees employees = new Employees();

    static
    {
        employees.setEmployees(new Employee("001","test1","test1 last","email1","title1"));
        employees.setEmployees(new Employee("002","test 2","test2 last","email2","title2"));
    }
    public Employees getAllEmployees () {
       return employees;
    }
    public String addEmployee(Employee employee){
        try{
            employees.setEmployees(employee);
            return "Success adding Employee";
        }catch (Exception exe){
            System.err.println("Error in adding employee "+ exe.getMessage());
            return exe.getMessage();
        }
    }

}
