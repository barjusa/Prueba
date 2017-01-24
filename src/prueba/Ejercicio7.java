package prueba;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Radio
 */
@SuppressWarnings("serial")
@WebServlet("/Ejercicio7")
public class Ejercicio7 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Ejercicio 7 TEMA 7 <br/>"
				+ "Prueba de helper radio button <br/>");
		
		Map<String,String> datosRadio = new HashMap<>();
		datosRadio.put("C", "Cine");
		datosRadio.put("D", "Deporte");
		datosRadio.put("M", "Música");
		datosRadio.put("R", "Restaurantes");
		
		out.println(Helpers.generaRadio("aficion",datosRadio,"M"));
		out.println("<br/>");
		
		Map<String,String> datosCheckbox = new HashMap<>();
		datosCheckbox.put("RK", "Rock");
		datosCheckbox.put("CL", "Clásica");
		datosCheckbox.put("P", "Pop");
		datosCheckbox.put("H", "Heavy");
		out.println("Prueba helper checkbox <br/>");
		
		out.println(Helpers.generaCheckboxes("musica", datosCheckbox, "D"));
		out.println("<br/>");
		
		Map<String,String> datosSelect = new HashMap<>();
		datosSelect.put("M", "Macarrones");
		datosSelect.put("L", "Lentejas");
		datosSelect.put("P", "Paella");
		datosSelect.put("H", "Hormigas");
		out.println("Prueba helper select <br/>");
		
		out.println(Helpers.generaSelected("comida", datosSelect, "H"));
		out.println("<br/>");
	}


	
}