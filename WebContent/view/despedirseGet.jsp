<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Ejercicio 20 TEMA 7
	<br />
	<br />
	<strong>FORMULARIO DESPEDIR NOMBRE</strong>
	<br />
	<br />

	<form action="<%= request.getAttribute("baseURL") %>t7/ej18/despedirse" method="post">
		<label for="idNombre">Nombre: </label> 
		<input type="text" name="nombre" id="idNombre"> <br/> 
		<input type="submit" value="Despedirse">
</body>
</html>