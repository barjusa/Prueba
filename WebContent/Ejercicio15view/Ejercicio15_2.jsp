<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="ejercicio15.LibroDAO"%>
<%@page import="ejercicio15.Libro"%>
<%
	ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("libros");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de libros</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Categoría</th>
		</tr>

		<%
			for (int i = 0; i < libros.size(); i++) {
				out.println("<tr><td>" + libros.get(i).getIsbn() + "</td><td>" + libros.get(i).getTitulo() + "</td><td>"
						+ libros.get(i).getCategoria() + "</td</tr>");
			}
		%>



	</table>
</body>
</html>