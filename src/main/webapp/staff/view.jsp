<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Staff Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .card-header {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2>
    <a href="/employees">List All Employees</a>
</h2>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card mt-4">
                <div class="card-header">
                    Staff Information
                </div>
                <div class="card-body">
                    <form method="post">
                        <div class="form-group">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" id="id" value="${staff.id}">
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" value="${staff.name}">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" value="${staff.email}">
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="tel" class="form-control" id="address" value="${staff.address}">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress">Phone number</label>
                            <input type="text" class="form-control" id="inputAddress" value="${staff.phone_number}">
                        </div>
                        <div class="form-group">
                            <label for="inputCity">Salary</label>
                            <input type="text" class="form-control" id="inputCity" value="${staff.salary}">
                        </div>
                        <div class="form-group">
                            <label for="inputState">Department</label>
                            <input type="text" class="form-control" id="inputState" value="${staff.department.department_name}">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>