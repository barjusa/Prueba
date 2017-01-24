package Ejercicio12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Ejercicio12_2
 */
@WebServlet("/Ejercicio12_2")
public class Ejercicio12_2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			out.println("Falta el driver de la Base de Datos");
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con =  DriverManager.getConnection("jdbc:mysql://localhost/libros", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Consultas
		try {
			PreparedStatement ps =  con.prepareStatement("select * from libros");
			ResultSet rs = ps.executeQuery();
			out.println("<table border=\"1\">");
			out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");
			while(rs.next()){
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String categoria = rs.getString("categoria");
				out.println("<tr><td>"+isbn+"</td><td>"+titulo+"</td><td>"+categoria+"</td></tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
