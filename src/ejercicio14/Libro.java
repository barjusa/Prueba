package ejercicio14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Libro extends Ejercicio14 {
	private String isbn;
	private String titulo;
	private String categoria;

	public Libro() {

	}

	public Libro(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public static Connection creaConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/libros", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean guardarLibro(Libro libro) {
		Connection con = creaConexion();
		String isbn = libro.getIsbn();
		String titulo = libro.getTitulo();
		String categoria = libro.getCategoria();
		try {
			PreparedStatement ps = con.prepareStatement("insert into libros values(?,?,?)");
			ps.setString(1, isbn);
			ps.setString(2, titulo);
			ps.setString(3, categoria);
			boolean correcto = ps.execute();
			return correcto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public static ArrayList<Libro> getLibros() {
		Connection con = creaConexion();
		ArrayList<Libro> libros = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from libros");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String categoria = rs.getString("categoria");
				Libro libro = new Libro(isbn, titulo, categoria);
				libros.add(libro);
			}
			return libros;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLibro(String isbn, String titulo, String categoria) {
		return isbn + titulo + categoria;
	}

}
