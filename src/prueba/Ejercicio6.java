package prueba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Ejercicio6")
public class Ejercicio6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<form action='' method='post'>"
				+ "<label for='idNombre'>Introduce un nombre: </label>"
				+ "<input type='text' id='idNombre' name='nombre'>"
				+ "<h4>Aficiones</h4>"
				+ "<input type='checkbox' name='aficiones[]' value='bailar'> Bailar"
				+ "<input type='checkbox' name='aficiones[]' value='cantar'> Cantar"
				+ "<br/>"
				+ "<input type='submit' value='Enviar'></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String aficiones[]= request.getParameterValues("aficiones[]");
		
		PrintWriter out = response.getWriter();
		
		if(nombre==""){
			out.println("<h1>Debes introducir un nombre</h1>");
		}
		if(aficiones==null){
			out.println("<h1>A "+nombre+" no le gusta nada</h1>");
		}
		String aficion = " ";
		for (int i = 0; i < aficiones.length; i++) {
			if(i==aficiones.length){
				aficion+=aficiones[i];
			}else{
				aficion+=aficiones[i]+',';
			}
			
			
			
			
		}
		out.println("<h1>A "+nombre+" le gusta"+aficion+"</h1>");
		
	}
	
}