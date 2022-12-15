package com.micronaut_aerospike.controllers;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.services.DepartmentService;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller("/department")

public class DepartmentController {

    @Inject
    DepartmentService departmentService;

    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> addDepartment(@Body Department department) {
        return departmentService.addDepartment(department);
    }
    @Get(value="/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @Get(value = "/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<Department> findById(@PathVariable int id){
        return  departmentService.findById(id);
    }

    @Delete(value = "/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> deleteById(@QueryValue int id){

        return  departmentService.deleteById(id);
    }

    @Put(value = "/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> update(Department department, @PathVariable int id){

        return  departmentService.update(department, id);
    }

    @Get(value = "/filterMorethan")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<Department> filterMorethan(){
        return departmentService.FilterDeptByMoreEmp();
    }
    @Get(value = "/filterLessthan")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<Department> filterLessthan(){
        return departmentService.FilterDeptByLessEmp();
    }
    @Get(value = "/filterMax")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<Department> filterMax(){
        return departmentService.filterMax();
    }
    @Get(value = "/filterMin")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<Department> filterMin(){
        return departmentService.filterMin();
    }
    @Get(value = "/sortDept")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<Department> sortDept(){
        return departmentService.sortDept();
    }


}
