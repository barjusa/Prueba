package org.mvc;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {
	Object request;
	Object response;
	String baseURL;
	Map<String, Object> datos = new HashMap<>();

	private void ejecutar(String modo, Object request, Object response) {
		//request.setAtribute();
	}

	void doGet() {
		ejecutar("get", request, response);
	}

	void doPost() {
		ejecutar("post", request, response);
	}

	void view(String rutaAVista) {

	}

	void view(String ruta, boolean estaEnmarcada) {

	}
}
