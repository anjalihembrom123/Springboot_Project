package com.example.demo.dao;

import com.example.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Long>{

}
