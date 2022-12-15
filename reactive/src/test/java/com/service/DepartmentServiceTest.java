package com.service;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.repositories.DepartmentRepositoryImpl;
import com.micronaut_aerospike.services.DeprtmentServiceImpl;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.*;

@MicronautTest
public class DepartmentServiceTest {

    @Inject
    DepartmentRepositoryImpl departmentRepository;

    @Inject
    DeprtmentServiceImpl departmentService;


    @MockBean
            (DepartmentRepositoryImpl.class)
    DepartmentRepositoryImpl departmentRepository() {

        return mock(DepartmentRepositoryImpl.class);
    }

    ;
    @Test
    void getDepartments() {
        Department department = new Department(1, "Java", 50);
        Department department1 = new Department(2, "Database", 75);
        Department department2 = new Department(3, "Testing", 100);
        when(departmentRepository.getDepartments()).thenReturn(List.of(department,department1, department2));

        departmentService.getDepartments();

        verify(departmentRepository, times(1)).getDepartments();

    }
    @Test
    void addDepartment(){
        Department department = new Department(1, "Java", 50);
        when(departmentRepository.addDepartment(department)).thenReturn("Department created successfully id is "+department.getDeptId());
        Mono<String> result = departmentService.addDepartment(department);
        verify(departmentRepository, times(1)).addDepartment(department);
      //  assertEquals("Department created successfully id is "+department.getDeptId(), result);
    }
    @Test
    void findById(){
        Department department = new Department(1, "Java", 50);
        department.setDeptId(1);
        when(departmentRepository.findById(department.getDeptId())).thenReturn(department);

        departmentService.findById(1);
        verify(departmentRepository, times(1)).findById(department.getDeptId());
    }
    @Test
    void deleteById(){
        Department department = new Department(1, "Java", 50);

        department.setDeptId(1);
        when(departmentRepository.deleteById(department.getDeptId())).thenReturn("Department deleted successfully");

        departmentService.deleteById(1);
        verify(departmentRepository, times(1)).deleteById(department.getDeptId());
    }
    @Test
    void update(){

        Department department = new Department(1, "Java", 50);
        department.setDeptId(1);
        Department newDept = new Department(1,"Aerospike", 100);

        when(departmentRepository.update(department,1)).thenReturn("Department updated successfully");

        departmentService.update(department, 1);

        verify(departmentRepository, times(1)).update(department, department.getDeptId());
    }


}
