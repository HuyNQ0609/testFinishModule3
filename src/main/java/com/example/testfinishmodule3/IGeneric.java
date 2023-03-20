package com.example.testfinishmodule3;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();

    void save(T generic);

    T findById(int id);

    boolean update(int id, T generic);

    boolean remove(int id);
}
