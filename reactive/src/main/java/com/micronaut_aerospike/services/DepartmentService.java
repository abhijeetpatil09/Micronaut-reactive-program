package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Singleton
public interface DepartmentService {

    Mono<String> addDepartment(Department department);

    Flux<Department> getDepartments();

    Mono<Department> findById(int id);

    Mono<String> deleteById(int id);

    Mono<String> update(Department department, int id);

    Flux<Department> FilterDeptByMoreEmp();

    Flux<Department> FilterDeptByLessEmp();

    Mono<Department> filterMax();

    Mono<Department> filterMin();

    Flux<Department> sortDept();

}
