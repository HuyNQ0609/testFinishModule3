<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">List Employees Information</h2>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone number</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Department</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="staff" items="${employees}">
                    <tr>
                        <td><c:out value="${staff.id}"/></td>
                        <td><c:out value="${staff.name}"/></td>
                        <td><c:out value="${staff.email}"/></td>
                        <td><c:out value="${staff.address}"/></td>
                        <td><c:out value="${staff.phone_number}"/></td>
                        <td><c:out value="${staff.salary}"/></td>
                        <td><c:out value="${staff.department.department_name}"/></td>
                        <td>
                            <a href="<c:url value="/employees?action=view&id=${staff.getId()}"/>">View</a>
                            <a href="/employees?action=edit&id=${staff.id}" class="settings" title="Settings" data-toggle="tooltip">Edit</a>
                            <a href="/employees?action=delete&id=${staff.id}" class="delete" title="Delete" data-toggle="tooltip">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <a href="<c:url value='/employees?action=create'/>">Create new Staff</a>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
