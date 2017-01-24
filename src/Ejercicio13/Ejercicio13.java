package Ejercicio13;

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
@WebServlet("/Ejercicio13")
public class Ejercicio13 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			out.println("Falta el driver de la Base de Datos");
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/libros", "root", "");
			response.sendRedirect("http://localhost:8080/Prueba/Ejercicio13view/Ejercicio13_1.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		try {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			PreparedStatement ps =  con.prepareStatement("insert into libros(isbn,titulo,categoria) values(?,?,?)");
			ps.setString(1, isbn);
			ps.setString(2, titulo);
			ps.setString(3, categoria);
			ps.execute();
			try {
				PreparedStatement pst =  con.prepareStatement("select * from libros");
				ResultSet rs = pst.executeQuery();
				List<String> isbnTotal=new ArrayList<String>();
				List<String> tituloTotal=new ArrayList<String>();
				List<String> categoriaTotal=new ArrayList<String>();
				while(rs.next()){
					
					String isbn2 = rs.getString("isbn");
					String titulo2 = rs.getString("titulo");
					String categoria2 = rs.getString("categoria");
					isbnTotal.add(isbn2);
					tituloTotal.add(titulo2);
					categoriaTotal.add(categoria2);
					
				}
				request.setAttribute("isbn", isbnTotal);
				request.setAttribute("titulo", tituloTotal);
				request.setAttribute("categoria", categoriaTotal);
				request.getRequestDispatcher("Ejercicio13view/Ejercicio13_2.jsp").forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/Prueba/Ejercicio13");
			out.println("Sentencia mal preparada");
			e.printStackTrace();
		}
		
	}

}
