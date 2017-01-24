package prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ejercicio10
 */
@WebServlet("/Ejercicio11")
public class Ejercicio11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 11 TEMA 7 <br/><br/>" + "<strong>FORMULARIO LOGIN</strong><br/>");

		out.println("<form action=\"\" method=\"post\" >");
		out.println("<label for=\"idUsuario\">Usuario: </label>"
				+ "<input type=\"text\" name=\"usuario\" id=\"idUsuario\"> <br/>");
		out.println("<label for=\"idPasswd\">Contraseña: </label>"
				+ "<input type=\"password\" name=\"passwd\" id=\"idPasswd\"> <br/>");
		out.println("<input type=\"submit\" value=\"Login\">");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String usuario = request.getParameter("usuario");
		String passwd = request.getParameter("passwd");
		PrintWriter out = response.getWriter();

		HttpSession sesion = request.getSession();

		if (compruebaUsuario(usuario, passwd)) {

			if (sesion.getAttribute(usuario) == null) {

				sesion.setAttribute(usuario, 2);

				out.println("Bienvenido " + usuario + "<br/>Primera visita");
				out.println("<form action=\"\" method=\"get\" >");
				out.println("<input type=\"submit\" value=\"Logout\">");
				out.println("</form>");

			}

			else {
				int numVisitas = (int) sesion.getAttribute(usuario);
				sesion.setAttribute(usuario, numVisitas+1);

				out.println("Bienvenido " + usuario + "<br/>Visita numero " + numVisitas);
				out.println("<form action=\"\" method=\"get\" >");
				out.println("<input type=\"submit\" value=\"Logout\">");
				out.println("</form>");
			}
		} else {
			out.println("<font color = \"red\">ERROR. Usuario inválido.</font><br/>");
			out.println("<form action=\"\" method=\"get\" >");
			out.println("<input type=\"submit\" value=\"Volver\">");
			out.println("</form>");
		}

	}

	public static boolean compruebaUsuario(String usuario, String passwd) {
		boolean res = false;

		if (usuario != null && passwd != null) {
			Map<String, String> usuarios = new HashMap<String, String>();
			usuarios.put("pepe", "pepe");
			usuarios.put("ana", "ana");

			if (usuarios.containsKey(usuario)) {
				if (usuarios.get(usuario).equals(passwd)) {
					// login ok
					res = true;
				} else {
					// login error
					return res;

				}

			}

		}
		return res;
	}

}
