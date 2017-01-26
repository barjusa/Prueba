package org.mvc;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	Object request;
	Object response;
	String baseURL;
	Map<String, Object> datos = new HashMap<>();

	private void ejecutar(String modo, Object request, Object response) {
		this.request = request;
		this.response = response;
		this.baseURL = "http://localhost:8080/app1/Controller/ejecutar";
		request.setAttribute(baseURL);
	}

	void doGet() {
		ejecutar("get", request, response);
	}

	void doPost() {
		ejecutar("post", request, response);
	}

	void view(String rutaAVista) {

	}

	void view(String rutaADesplegar, boolean estaEnmarcada) {
		request.getRequestDispatcher("/view/viewController.jsp").forward(request, response);
		String rutaVista = "/view" + rutaADesplegar;
		String baseURL = this.baseURL;
	}
}
