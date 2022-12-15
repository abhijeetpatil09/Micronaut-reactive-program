package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.repositories.DepartmentRepositoryImpl;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
@Singleton
public class DeprtmentServiceImpl implements DepartmentService{

    @Inject
    DepartmentRepositoryImpl departmentRepository;


    @Override
    public Mono<String> addDepartment(Department department) {
        return Mono.just(departmentRepository.addDepartment(department));
    }

    @Override
    public Flux<Department> getDepartments() {
        List<Department> list = departmentRepository.getDepartments();
        return Flux.fromStream(list.stream());
    }

    @Override
    public Mono<Department> findById(int id) {
        return Mono.just(departmentRepository.findById(id));
    }

    @Override
    public Mono<String> deleteById(int id) {
        return Mono.just(departmentRepository.deleteById(id));
    }

    @Override
    public Mono<String> update(Department department, int id) {
        return Mono.just(departmentRepository.update(department, id));
    }


    @Override
    public Flux<Department> FilterDeptByMoreEmp() {
        List<Department> depts = departmentRepository.getDepartments();
        return Flux.fromStream(depts.stream().filter(p -> p.getNumOfEmployee() > 200)).log();
    }

    @Override
    public Flux<Department> FilterDeptByLessEmp() {
        List<Department> depts = departmentRepository.getDepartments();
        return Flux.fromStream(depts.stream().filter(p -> p.getNumOfEmployee() < 200)).log();
    }

    @Override
    public Mono<Department> filterMax(){
        List<Department> depts = departmentRepository.getDepartments();
        return Mono.just(depts.stream().max((dept1, dept2)-> dept1.numOfEmployee > dept2.numOfEmployee ? 1: -1).get());

   }
    @Override
    public Mono<Department> filterMin() {
        List<Department> depts = departmentRepository.getDepartments();
        return Mono.just(depts.stream().min((dept1, dept2)-> dept1.numOfEmployee > dept2.numOfEmployee ? 1: -1).get());

    }
    @Override
    public Flux<Department> sortDept(){
        List<Department> depts = departmentRepository.getDepartments();
        return Flux.fromStream(depts.stream().sorted(Comparator.comparing(Department::getDeptName)));
    }
}


