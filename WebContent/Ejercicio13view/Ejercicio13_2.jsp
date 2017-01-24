<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <% ArrayList<String> isbn = (ArrayList<String>) request.getAttribute("isbn");
    ArrayList<String> titulo = (ArrayList<String>) request.getAttribute("titulo");
    ArrayList<String> categoria = (ArrayList<String>) request.getAttribute("categoria");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de libros</title>
</head>
<body>
<table border="1">
<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>

<% for( int i= 0;i< isbn.size();i++){
out.println("<tr><td>"+isbn.get(i)+"</td><td>"+titulo.get(i)+"</td><td>"+categoria.get(i)+"</td</tr>");}%>



<!-- recoger los datos que se creen en POST de ejercicio13.java -->
</table>
</body>
</html>