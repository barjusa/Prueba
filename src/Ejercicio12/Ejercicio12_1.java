package Ejercicio12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Ejercicio12_1
 */
@SuppressWarnings("serial")
@WebServlet("/Ejercicio12_1")
public class Ejercicio12_1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("Ejercicio 12 TEMA 7 <br/><br/>" + "<strong>FORMULARIO LIBROS</strong><br/><br/>");

		out.println("<form action=\"\" method=\"post\" >");
		out.println("<label for=\"idISBN\">ISBN: </label>" + "<input type=\"text\" name=\"isbn\" id=\"idISBN\"> <br/>");
		out.println("<label for=\"idTitulo\">Título: </label>"
				+ "<input type=\"text\" name=\"titulo\" id=\"idTitulo\"> <br/>");
		out.println("<label for=\"idCategoria\">Categoría: </label>"
				+ "<input type=\"text\" name=\"categoria\" id=\"idCategoria\"> <br/>");
		out.println("<input type=\"submit\" value=\"Añadir libro\">");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			out.println("Falta el driver de la Base de Datos");
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/libros", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Insertar un dato
		try {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			PreparedStatement ps =  con.prepareStatement("insert into libros(isbn,titulo,categoria) values(?,?,?)");
			ps.setString(1, isbn);
			ps.setString(2, titulo);
			ps.setString(3, categoria);
			ps.execute();
			response.sendRedirect("Ejercicio12_2");
		} catch (SQLException e) {
			response.sendRedirect("Ejercicio12_1");
			out.println("Sentencia mal preparada");
			e.printStackTrace();
		}

	}

}
