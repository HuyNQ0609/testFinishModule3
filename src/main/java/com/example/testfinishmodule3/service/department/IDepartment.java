package com.example.testfinishmodule3.service.department;

import com.example.testfinishmodule3.IGeneric;
import com.example.testfinishmodule3.model.Department;

import java.util.List;

public interface IDepartment extends IGeneric<Department> {
    @Override
    Department findById(int id);

    @Override
    List<Department> findAll();

    @Override
    void save(Department department);

    @Override
    boolean update(int id, Department department);

    @Override
    boolean remove(int id);
}
