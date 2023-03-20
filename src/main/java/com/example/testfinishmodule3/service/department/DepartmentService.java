package com.example.testfinishmodule3.service.department;

import com.example.testfinishmodule3.connection.StaffConnection;
import com.example.testfinishmodule3.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService implements IDepartment {
    private static final String GET_DEPARTMENT_BY_ID;
    static {
        GET_DEPARTMENT_BY_ID = "select * from department where id = ?";
    }

    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet res = null;

    private void closeConnection() {
        try {
            if (res != null) res.close();
            if (pre != null) pre.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getRollback() {
        try {
            con.rollback();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public Department findById(int id) {
        Department department = null;
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(GET_DEPARTMENT_BY_ID);
            pre.setInt(1, id);
            res = pre.executeQuery();
            while (res.next()) {
                String address_name = res.getString("department_name");
                department = new Department(id, address_name);
            }
            con.commit();
        } catch (SQLException e) {
            getRollback();
        } finally {
            closeConnection();
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public void save(Department department) {

    }

    @Override
    public boolean update(int id, Department department) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
