package ejercicio18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvc.Controller;


@WebServlet({"/t7/ej18","/t7/ej18/","/t7/ej18/*"})
public class Ej18Controller extends Controller{
	protected void saludarGet(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			response.setContentType("text/html");

			out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>FORMULARIO SALUDAR NOMBRE</strong><br/><br/>");

			out.println("<form action=\"\" method=\"post\" >");
			out.println("<label for=\"idNombre\">Nombre: </label>" + "<input type=\"text\" name=\"nombre\" id=\"idNombre\"> <br/>");
			out.println("<input type=\"submit\" value=\"Saludar\">");
			out.println("</form>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void saludarPost(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out;
		String nombre = request.getParameter("nombre");
		try {
			out = response.getWriter();
			response.setContentType("text/html");

			out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>SALUDAR NOMBRE</strong><br/><br/>");
			
			out.println("Hola "+nombre+" !!!<br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void despedirseGet(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			response.setContentType("text/html");

			out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>FORMULARIO SALUDAR NOMBRE</strong><br/><br/>");

			out.println("<form action=\"\" method=\"post\" >");
			out.println("<label for=\"idNombre\">Nombre: </label>" + "<input type=\"text\" name=\"nombre\" id=\"idNombre\"> <br/>");
			out.println("<input type=\"submit\" value=\"Saludar\">");
			out.println("</form>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void despedirsePost(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out;
		String nombre = request.getParameter("nombre");
		try {
			out = response.getWriter();
			response.setContentType("text/html");

			out.println("Ejercicio 18 TEMA 7 <br/><br/>" + "<strong>DESPEDIR NOMBRE</strong><br/><br/>");
			
			out.println("Adiós "+nombre+" !!!<br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		saludarGet(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		saludarPost(request,  response);

	}
}
