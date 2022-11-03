<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee View</title>
</head>
<body>
   <table border="1">
     <tr>
        <th>No.</th>
        <th>First Name</th>
        <th>Email</th>
        <th>Extension</th>
     </tr>
    <c:forEach var="em" items="${employees}">
           <tr>
             <td>${em.employeeNumber}</td>
             <td>${em.firstName }</td>
             <td>${em.email}</td>
             <td>${em.extension}</td>
           </tr>
    </c:forEach>
    </table>
</body>
</html>