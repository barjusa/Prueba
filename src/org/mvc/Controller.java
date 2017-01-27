package org.mvc;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller extends HttpServlet{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String baseURL;
	protected Map<String, Object> datos = new HashMap<>();

	protected void ejecutar(String modo, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.baseURL = request.getRequestURL().toString().substring(0,
				request.getRequestURL().toString().length() - request.getRequestURI().length())
		+ request.getContextPath() + "/" ;
		request.setAttribute("baseURL", baseURL);
		//String controlador= request.getServletPath();
		String accion = request.getPathInfo(); 
		if(accion.equals("")){
			accion="index";
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ejecutar("get", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		ejecutar("post", request, response);
	}

	protected void view(String rutaAVista) {

	}

	protected void view(String rutaADesplegar, boolean estaEnmarcada) {
		request.getRequestDispatcher("/view/viewController.jsp").forward(request, response);
		String rutaVista = "/view" + rutaADesplegar;
		String baseURL = this.baseURL;
	}
}
