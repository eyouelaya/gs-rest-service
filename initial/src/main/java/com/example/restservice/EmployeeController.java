package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeManager employeeManager;
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/")
    public Employees  getEmployees() {
        return employeeManager.getAllEmployees();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String addEmployee (@RequestBody Employee employee){
       try {
           if(checkEmployee(employee)){
               return employeeManager.addEmployee(employee);
           }
       }catch (Exception exe){
            System.err.println(exe.getMessage());
           return exe.getMessage();
        }
       return "Error missing employee missing data in some of the fields";
    }

    //check if all variables are set
    public boolean checkEmployee(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value == null) {
                return false;
            }
        }
        return true;
    }
}
