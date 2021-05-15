
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;


@RestController
public class Controller2 {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return"welcome to employee database";

    }
    //get employees

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return this.employeeService.getEmployees();

    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId)
    {
        return this.employeeService.getEmployee(Long.parseLong(employeeId));

    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.addEmployee(employee);

    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.updateEmployee(employee);

    }
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId){
        try {
            this.employeeService.deleteEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
