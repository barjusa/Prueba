<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario libros</title>
</head>
<body> 
Ejercicio15 TEMA 7<br/><br/>
<b>FORMULARIO DE LIBROS</b><br/></br>
	<form action="http://localhost:8080/Prueba/Ejercicio15" method="post">
		<label for="idISBN">ISBN: </label><input type="text" name="isbn"
			id="idISBN"> <br /> <label for="idTitulo">Título: </label><input
			type="text" name="titulo" id="idTitulo"> <br /> <label
			for="idCategoria">Categoría: </label><input type="text"
			name="categoria" id="idCategoria"> <br /> <input
			type="submit" value="Añadir libro">
	</form>

</body>
</html>