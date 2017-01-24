package ejercicio14;

import ejercicio14.Libro.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio13
 */
@SuppressWarnings("serial")
@WebServlet("/Ejercicio14")
public class Ejercicio14 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Ejercicio14view/Ejercicio14_1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libro = new Libro(isbn, titulo, categoria);
		Libro.guardarLibro(libro);
		
		
		ArrayList<Libro> libros = Libro.getLibros();
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("/Ejercicio14view/Ejercicio14_2.jsp").forward(request,response);

	}

}
