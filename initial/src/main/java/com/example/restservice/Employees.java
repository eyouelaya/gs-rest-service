package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private final List<Employee> employees =  new ArrayList<Employee>();

    public Employees() {
    }

    public Employees(Employee employees) {
        this.employees.add(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees.add(employees);
    }

}
