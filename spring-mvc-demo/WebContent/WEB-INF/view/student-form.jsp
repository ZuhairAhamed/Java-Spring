<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!Doctype html>
<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName"/>
	
	<br><br>
	
	Last Name: <form:input path="lastName"/>
	
	<br><br>
	
	Country:
	<form:select path="country">
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="India" label="India"/>
		<form:option value="German" label="German"/>
		<form:option value="France" label="France"/>
	</form:select>
	
	<br><br>
	
	Favourite Language:
	Java<form:radiobutton path="programmingLanguage" value="java"/>
	C#<form:radiobutton path="programmingLanguage" value="c#"/>
	PHP<form:radiobutton path="programmingLanguage" value="php"/>
	Ruby<form:radiobutton path="programmingLanguage" value="ruby"/>
	
	<br><br>
	
	OS:
	Windows<form:checkbox path="os" value="windows"/>
	Linux<form:checkbox path="os" value="linux"/>
	MacOs<form:checkbox path="os" value="macOs"/>
	
	<br><br>
	
	<input type="submit" value="Submit"/>

	</form:form>

</body>
</html>