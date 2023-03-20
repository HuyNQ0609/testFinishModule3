<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Staff Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Edit Staff Information</h2>
    <form method="post">
        <div>
            <c:if test="${staff != null}">
                <input type="hidden" name="id" value="<c:out value='${staff.id}'/>"/>
            </c:if>
        </div>

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<c:out value='${staff.name}'/>">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" value="<c:out value='${staff.email}'/>">
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address"
                   value="<c:out value='${staff.address}'/>">
        </div>

        <div class="form-group">
            <label for="phone_number">Phone number:</label>
            <input type="text" class="form-control" id="phone_number" name="phone_number" value="<c:out value='${staff.phone_number}'/>">
        </div>

        <div class="form-group">
            <label for="salary">Salary:</label>
            <input type="text" class="form-control" id="salary" name="salary" value="<c:out value='${staff.salary}'/>">
        </div>
        <div class="form-group">
            <label for="department">Department:</label>
            <select class="form-control" id="department" name="department_id">
                <option value="1">Lanh dao</option>
                <option value="2">Quan tri</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <div class="form-group">
            <a href="/employees?action=list">Back to List Employees</a>
        </div>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
