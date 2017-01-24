package ejercicio15;

import ejercicio15.Libro.*;
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
@WebServlet("/Ejercicio15")
public class Ejercicio15 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Ejercicio15view/Ejercicio15_1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libro = new Libro(isbn, titulo, categoria);
		LibroDAO.guardarLibro(libro);
		
		
		ArrayList<Libro> libros = LibroDAO.getLibros();
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("/Ejercicio15view/Ejercicio15_2.jsp").forward(request,response);

	}

}
