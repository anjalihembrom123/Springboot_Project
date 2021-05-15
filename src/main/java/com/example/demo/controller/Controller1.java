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

import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentService;


@RestController
public class Controller1 {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/tab")
    public String tab() {
        return"welcome to department database";

    }
    //get departments

    @GetMapping("/departments")
    public List<Department> getDepartments()
    {
        return this.departmentService.getDepartments();

    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartment(@PathVariable String departmentId)
    {
        return this.departmentService.getDepartment(Long.parseLong(departmentId));

    }
    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department)
    {
        return this.departmentService.addDepartment(department);

    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department)
    {
        return this.departmentService.updateDepartment(department);

    }
    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable String departmentId){
        try {
            this.departmentService.deleteDepartment(Long.parseLong(departmentId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
