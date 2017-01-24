package prueba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Ejercicio9
 */
@WebServlet("/Ejercicio9")
@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)
public class Ejercicio9 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 9 TEMA 7 <br/><br/>" + "<strong>FORMULARIO</strong><br/>");

		out.println("<form action=\"\" method=\"post\" enctype=\"multipart/form-data\">");
		out.println("Selecciona el fichero<br/><br/>");
		out.println("<input type=\"file\" name=\"miArchivo\"><br/><br/><br/>");

		out.println("<label for=\"idNombre\">Nuevo nombre</label><br/><br/>"
				+ "<input type=\"text\" name=\"nombre\" id=\"idNombre\"> <br/>");
		out.println("<input type=\"submit\" value=\"Subir\">");
		out.println("</form>");

	}

	private static String devuelveNombreArchivo(Part parte) {
		for (String cd : parte.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}

		return null;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part parteArchivo = request.getPart("miArchivo");
		String nuevoNombre = request.getParameter("nombre");
		String nombreOriginal = devuelveNombreArchivo(parteArchivo);
		if (nuevoNombre.equals("")) {
			parteArchivo.write(nombreOriginal);
		} else {
			parteArchivo.write(nuevoNombre);
		}

	}

}
