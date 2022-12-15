package com.micronaut_aerospike.entities;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;


@AerospikeRecord(namespace = "test",set = "Department")
public class Department {

    @AerospikeBin
    @AerospikeKey
    public int deptId;

    @AerospikeBin
    public String deptName;

    @AerospikeBin
    public int numOfEmployee;

    public Department() {
    }

    public Department(int deptId, String deptName, int numOfEmployee) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.numOfEmployee = numOfEmployee;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(int numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", numOfEmployee=" + numOfEmployee +
                '}';
    }
}
