package ejercicio18;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvc.Controller;

import ejercicio15.Libro;
import ejercicio15.LibroDAO;

@WebServlet({"/t7/ej18","/t7/ej18/","/t7/ej18/*"})
public class Ej18Controller extends Controller{
	void saludarGet(){
		System.out.println("saludaGet");
	}
	void saludarPost(){
		System.out.println("saludaPost");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("ej18/saludarGet()").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.getRequestDispatcher("ej18/saludarPost()").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
