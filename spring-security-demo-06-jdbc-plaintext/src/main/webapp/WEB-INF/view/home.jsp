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
<!-- Add a link to point /leaders .. this is for Magagers -->
<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		(Only for Manager Peeps)
	</p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin Peeps)
	</p>
</security:authorize>


<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>


</body>

</html>