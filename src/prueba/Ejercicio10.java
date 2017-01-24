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

/**
 * Servlet implementation class Ejercicio10
 */
@WebServlet("/Ejercicio10")
public class Ejercicio10 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 10 TEMA 7 <br/><br/>" + "<strong>FORMULARIO LOGIN</strong><br/>");

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
		// compruebaUsuario(usuario, passwd);

		if (compruebaUsuario(usuario, passwd)) {
			Cookie[] cs = request.getCookies();
			if (cs != null && cs.length > 0) {
				//si hay cookies previamente
				//Cookie c1 = new Cookie(usuario, "1");
				//c1.setMaxAge(-1000);
				//response.addCookie(c1);
				long ultimavisita=Long.parseLong(cs[0].getValue());
				Long tiempoTrascurrido = (System.currentTimeMillis()-ultimavisita)/1000;
				if(tiempoTrascurrido>60){
					tiempoTrascurrido=(long) 1;
					out.println("Bienvenido "+usuario+". Ha pasado más de "+tiempoTrascurrido+ " minuto desde la última visita<br/>");
					out.println("<form action=\"\" method=\"get\" >");
					out.println("<input type=\"submit\" value=\"Logout\">");
					out.println("</form>");
				}else{
					out.println("Bienvenido "+usuario+". Tiempo transcurrido desde la última visita "+tiempoTrascurrido+"<br/>");
					out.println("<form action=\"\" method=\"get\" >");
					out.println("<input type=\"submit\" value=\"Logout\">");
					out.println("</form>");
				}
				
				
			}else{
				//primera entrada
				Cookie c1 = new Cookie(usuario, String.valueOf(System.currentTimeMillis()));
				//c1.setMaxAge(-1000);
				response.addCookie(c1);
				out.println("Bienvenido "+usuario+"<br/>Primera conexión");
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
