<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vaishalibhoyar
  Date: 26/05/25
  Time: 1:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
  <h2>Register Car</h2>
  <br>
  <form:form modelAttribute="car" action="register-car">
    Registration Number: <form:input path="registrationNumber"/>
    <br>
    Model: <form:input path="model"/>
    <br>
    Manufacturer: <form:input path="manufacturer"/>
    <br>
    <input type="submit" value="Register">
  </form:form>
</body>
</html>
