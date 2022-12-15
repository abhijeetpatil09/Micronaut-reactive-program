package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.entities.Department;

import java.util.List;

public interface DepartmentRepository {


    String addDepartment(Department department);

    List<Department> getDepartments();

    Department findById(int id);

    String deleteById(int id);

    String update(Department department, int id);

}
