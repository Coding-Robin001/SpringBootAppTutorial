package com.springBootProject.springBoot.tutorial.service;

import com.springBootProject.springBoot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
