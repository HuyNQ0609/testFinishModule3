package com.example.testfinishmodule3.service.staff;

import com.example.testfinishmodule3.IGeneric;
import com.example.testfinishmodule3.model.Staff;

import java.util.List;

public interface IStaff extends IGeneric<Staff> {
    List<Staff> findAll();

    void save(Staff staff);

    Staff findById(int id);

    boolean update(int id, Staff staff);

    boolean remove(int id);
}
