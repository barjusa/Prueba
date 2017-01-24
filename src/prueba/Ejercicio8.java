package prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio8
 */
@WebServlet("/Ejercicio8")
public class Ejercicio8 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 8 TEMA 7 <br/><br/>" + "<strong>FORMULARIO</strong><br/>");

		Map<String, String> datosRadio = new HashMap<>();
		datosRadio.put("E", "España");
		datosRadio.put("F", "Francia");
		datosRadio.put("I", "Italia");
		datosRadio.put("P", "Portugal");

		out.println("<form action=\"\" method=\"post\">");
		out.println("<label for=\"idNombre\">Nombre: </label>"
				+ "<input type=\"text\" name=\"nombre\" id=\"idNombre\" > <br/>");
		out.println("<label for=\"idPasswd\">Contraseña: </label>"
				+ "<input type=\"password\" name=\"passwd\" id=\"idPasswd\" > <br/>");
		out.println("Elige ciudad de nacimiento<br/>");
		out.println(util8.ciudad("pais", datosRadio, "E"));
		out.println("<input type=\"submit\" value=\"Enviar\">");
		out.println("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 8 TEMA 7 <br/><br/>" + "<strong>FORMULARIO</strong><br/>");

		String nombre = request.getParameter("nombre");
		String passwd = request.getParameter("passwd");

		if (nombre.equals("") || (passwd.length() < 6 || passwd.length() > 12)) {

			Map<String, String> datosRadio = new HashMap<>();
			datosRadio.put("E", "España");
			datosRadio.put("F", "Francia");
			datosRadio.put("I", "Italia");
			datosRadio.put("P", "Portugal");

			out.println("<form action=\"\" method=\"post\">");
			out.println("<label for=\"idNombre\">Nombre: </label>"
					+ "<input type=\"text\" name=\"nombre\" id=\"idNombre\" value=\"" + nombre + "\"> <br/>");

			if (nombre.equals("")) {
				out.println("<font color = \"red\">ERROR. Nombre vacío. Introduzca un nombre.</font><br/>");
			}

			out.println("<label for=\"idPasswd\">Contraseña: </label>"
					+ "<input type=\"password\" name=\"passwd\" id=\"idPasswd\" value=\"" + passwd + "\"> <br/>");

			if (passwd.length() < 6 || passwd.length() > 12) {
				out.println(
						"<font color = \"red\">ERROR. Contraseña inválida. Introduzca una contraseña que tenga entre 6 y 12 caracteres.</font><br/>");
			}

			out.println("Elige ciudad de nacimiento<br/>");
			out.println(util8.ciudad("pais", datosRadio, "E"));
			out.println("<input type=\"submit\" value=\"Enviar\">");
			out.println("</form>");
		}else{
			String pais = request.getParameter("pais");
			out.println("Nombre: "+nombre+"<br/>");
			out.println("Contraseña: "+passwd+"<br/>");
			out.println("País de nacimiento: "+pais+"<br/>");
			
		}
	}

}
