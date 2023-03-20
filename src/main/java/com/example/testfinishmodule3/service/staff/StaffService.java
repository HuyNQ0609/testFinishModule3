package com.example.testfinishmodule3.service.staff;

import com.example.testfinishmodule3.connection.StaffConnection;
import com.example.testfinishmodule3.model.Department;
import com.example.testfinishmodule3.model.Staff;
import com.example.testfinishmodule3.service.department.DepartmentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaff {
    private static final String SELECT_ALL_EMPLOYEES;
    private static final String GET_STAFF_BY_ID;
    private static final String INSERT_INTO_STAFF;
    private static final String UPDATE_STAFF;
    private static final String DELETE_STAFF;

    static {
        SELECT_ALL_EMPLOYEES = "call select_all_employees()";
        GET_STAFF_BY_ID = "select * from Staff where id = ?";
        INSERT_INTO_STAFF = "insert into staff(id, name, email, address, phone_number, salary, department_id) values (?, ?, ?, ?, ?, ?, ?)";
        UPDATE_STAFF = "update staff set name = ?, email = ?, address = ?, phone_number = ?, salary = ?, department_id = ? where id = ?";
        DELETE_STAFF = "delete from staff where id = ?";
    }

    DepartmentService departmentService = new DepartmentService();

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
    public List<Staff> findAll() {
        List<Staff> employees = new ArrayList<>();
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(SELECT_ALL_EMPLOYEES);
            res = pre.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");
                String address = res.getString("address");
                String phone_number = res.getString("phone_number");
                double salary = res.getDouble("salary");
                int department_id = res.getInt("department_id");
                Department department = departmentService.findById(department_id);
                employees.add(new Staff(id, name, email, address, phone_number, salary, department));
            }
            con.commit();

        } catch (SQLException e) {
            getRollback();
        } finally {
            closeConnection();
        }
        return employees;
    }

    @Override
    public void save(Staff staff) {
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(INSERT_INTO_STAFF);
            pre.setInt(1, staff.getId());
            pre.setString(2, staff.getName());
            pre.setString(3, staff.getEmail());
            pre.setString(4, staff.getAddress());
            pre.setString(5, staff.getPhone_number());
            pre.setDouble(6, staff.getSalary());
            pre.setInt(7, staff.getDepartment_id());
            pre.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            getRollback();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Staff findById(int id) {
        Staff staff = null;
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(GET_STAFF_BY_ID);
            pre.setInt(1, id);
            res = pre.executeQuery();
            while (res.next()) {
                String name = res.getString("name");
                String email = res.getString("email");
                String address = res.getString("address");
                String phone_number = res.getString("phone_number");
                double salary = res.getDouble("salary");
                int department_id = res.getInt("department_id");
                Department department = departmentService.findById(department_id);
                staff = new Staff(id, name, email, address, phone_number, salary, department);
            }
            con.commit();
        } catch (SQLException e) {
            getRollback();
        } finally {
            closeConnection();
        }
        return staff;
    }

    @Override
    public boolean update(int id, Staff staff) {
        boolean rowUpdated = false;
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(UPDATE_STAFF);
            pre.setString(1, staff.getName());
            pre.setString(2, staff.getEmail());
            pre.setString(3, staff.getAddress());
            pre.setString(4, staff.getPhone_number());
            pre.setDouble(5, staff.getSalary());
            pre.setInt(6, staff.getDepartment_id());
            pre.setInt(7, staff.getId());
            rowUpdated = pre.executeUpdate() > 0;
            con.commit();
        } catch (SQLException e) {
            getRollback();
        } finally {
            closeConnection();
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) {
        boolean rowDeleted = false;
        try {
            con = StaffConnection.getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(DELETE_STAFF);
            pre.setInt(1, id);
            rowDeleted = pre.executeUpdate() > 0;
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(e);
            }
        } finally {
            try {
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }
}
