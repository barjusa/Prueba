package prueba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Formulario")
public class Formulario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<form action='' method='post'>"
				+ "<label for='idNombre'>Introduce un nombre: </label>"
				+ "<input type='text' id='idNombre' name='nombre'>"
				+ "<input type='submit' value='Saludar'></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		PrintWriter saludo = response.getWriter();
		saludo.println("<h1>Hola "+nombre+"!</h1>");
	}
	
}