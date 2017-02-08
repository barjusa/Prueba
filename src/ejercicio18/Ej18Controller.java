package ejercicio18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvc.Controller;

@SuppressWarnings("serial")
@WebServlet({ "/t7/ej18", "/t7/ej18/", "/t7/ej18/*" })
public class Ej18Controller extends Controller {
	public void saludarGet() throws IOException {
		PrintWriter out;

		out = response.getWriter();
		response.setContentType("text/html");

		out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>FORMULARIO SALUDAR NOMBRE</strong><br/><br/>");

		out.println("<form action=\"" + this.baseURL + "t7/ej18/saludar\" method=\"post\" >");
		out.println("<label for=\"idNombre\">Nombre: </label>"
				+ "<input type=\"text\" name=\"nombre\" id=\"idNombre\"> <br/>");
		out.println("<input type=\"submit\" value=\"Saludar\">");
		out.println("</form>");

	}

	public void saludarPost() throws IOException {
		PrintWriter out;
		String nombre = request.getParameter("nombre");

		out = response.getWriter();
		response.setContentType("text/html");

		out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>SALUDAR NOMBRE</strong><br/><br/>");

		out.println("Hola " + nombre + " !!!<br/>");

	}

	protected void despedirseGet() throws IOException {
		PrintWriter out;

		out = response.getWriter();
		response.setContentType("text/html");

		out.println("Ejercicio 19 TEMA 7 <br/><br/>" + "<strong>FORMULARIO SALUDAR NOMBRE</strong><br/><br/>");

		out.println("<form action=\""+this.baseURL+"t7/ej18/despedirse\" method=\"post\" >");
		out.println("<label for=\"idNombre\">Nombre: </label>"
				+ "<input type=\"text\" name=\"nombre\" id=\"idNombre\"> <br/>");
		out.println("<input type=\"submit\" value=\"Saludar\">");
		out.println("</form>");

	}

	protected void despedirsePost() throws IOException {
		PrintWriter out;
		String nombre = request.getParameter("nombre");

		out = response.getWriter();
		response.setContentType("text/html");

		out.println("Ejercicio 19 TEMA 7 <br/><br/>" + "<strong>DESPEDIR NOMBRE</strong><br/><br/>");

		out.println("Adiós " + nombre + " !!!<br/>");

	}
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * saludarGet(request, response);
	 * 
	 * 
	 * }
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * saludarPost(request, response);
	 * 
	 * }
	 */
}
