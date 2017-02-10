package org.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

	protected void ejecutar(String modo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.baseURL = request.getRequestURL().toString().substring(0,
				request.getRequestURL().toString().length() - request.getRequestURI().length())
		+ request.getContextPath() + "/" ;
		request.setAttribute("baseURL", baseURL);
		//String controlador= request.getServletPath();
		String[] partes = request.getPathInfo() != null ? request.getPathInfo().split("/") : null;
		String accion = (partes != null && partes.length > 0 ? partes[1] : "index")
				+ (modo.equals("get") ? "Get" : "Post");
		try {
			this.getClass().getMethod(accion).invoke(this);
		} catch (NoSuchMethodException e) {
			response.setContentType("text/html");
			response.getWriter().print("<h1>No existe el método " + accion + "</h1>");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ejecutar("get", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ejecutar("post", request, response);
	}

	protected void view(String rutaAVista) {
		view(rutaAVista,true);
	}

	protected void view(String rutaADesplegar, boolean estaEnmarcada) {

		String rutaVista = "/view/" + rutaADesplegar;
		request.setAttribute("rutaVista", rutaVista);
		String baseURL = this.baseURL;
		for (String k : datos.keySet()) {
			request.setAttribute(k, datos.get(k));
		}
		if(estaEnmarcada==false){
			try {
				request.getRequestDispatcher(rutaVista).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				request.getRequestDispatcher("/view/_templates/_MASTER.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
