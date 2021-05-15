package com.example.demo.services;

import com.example.demo.entities.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartments();

    public Department getDepartment(long departmentId);

    public Department addDepartment(Department department);

    public Department updateDepartment(Department department);

    public void deleteDepartment(long parseLong);
}
