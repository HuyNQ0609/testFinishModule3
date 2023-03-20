package com.example.testfinishmodule3.controller;

import com.example.testfinishmodule3.model.Staff;
import com.example.testfinishmodule3.service.staff.StaffService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/employees")
public class StaffServlet extends HttpServlet {
    private StaffService staffService;

    public void init() throws ServletException {
        staffService = new StaffService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewDetails(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                break;
        }
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        request.setAttribute("staff", staff);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        request.setAttribute("staff", staff);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewDetails(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> merchants = staffService.findAll();
        request.setAttribute("employees", merchants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        Staff staff = new Staff(id, name, email, address, phone_number, salary, department_id);
        staffService.save(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        request.setAttribute("message", "New staff was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        Staff staff = new Staff(id, name, email, address, phone_number, salary, department_id);
        staffService.update(id, staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        request.setAttribute("message", "Staff information was updated");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
