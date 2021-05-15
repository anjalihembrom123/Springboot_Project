package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public DepartmentServiceImpl() {

    }


    @Override
    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartment(long departmentId) {

        //return departmentDao.getOne(departmentId);
        return departmentDao.findById(departmentId).orElse(null);
    }

    @Override
    public Department addDepartment(Department department) {
        departmentDao.save(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentDao.save(department);
        return department;
    }

    @Override
    public void deleteDepartment(long parseLong) {
        Department entity = departmentDao.getOne(parseLong);
        departmentDao.delete(entity);
    }
}




