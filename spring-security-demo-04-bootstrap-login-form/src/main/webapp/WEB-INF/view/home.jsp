<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
<h2> Welcome to the Home Page</h2>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>


</body>

</html>