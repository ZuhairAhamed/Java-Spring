<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype html>
<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

	The student is confirmed : ${student.firstName } ${student.lastName }
	<br>
	Country : ${student.country}
	<br>
	Postal Code: ${student.postalCode }
	<br>
	Free Passes: ${student.freePasses}
	<br>
	Favourite Language is : ${student.programmingLanguage }
	<br>
	Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.os}">
			<li>${temp}</li>
		</c:forEach>
	</ul>

</body>
</html>