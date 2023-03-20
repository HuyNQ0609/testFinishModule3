<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Staff</title>
</head>
<body>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<form method="post">
    <table border="1" cellpadding="5">
        <caption>
            <h3>Staff Information</h3>
        </caption>
        <tr>
            <td>ID:</td>
            <td><c:out value="${staff.id}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><c:out value="${staff.name}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><c:out value="${staff.email}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><c:out value="${staff.address}"/></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><c:out value="${staff.phone_number}"/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><c:out value="${staff.salary}"/></td>
        </tr>
        <tr>
            <td>Department</td>
            <td><c:out value="${staff.department.department_name}"/></td>
        </tr>
    </table>
    <table>
        <h3>Are you sure?</h3>
        <tr>
            <td><input type="submit" value="Delete staff"></td>
            <td><a href="/employees">Back to list employees</a></td>
        </tr>
    </table>
</form>
</body>
</html>
