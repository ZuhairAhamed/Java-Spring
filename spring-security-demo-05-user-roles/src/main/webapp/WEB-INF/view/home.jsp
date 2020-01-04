<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
<h2> Welcome to the Home Page</h2>

<hr>
<!-- display user name and role -->
<p>
	User: <security:authentication property="principal.username"/>
	<br><br>
	Role: <security:authentication property="principal.authorities"/>
</p>
<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>


</body>

</html>