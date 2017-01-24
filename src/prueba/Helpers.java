package prueba;

import java.util.Map;

public class Helpers {
	public static String generaRadio(String nombre, Map<String, String> datos, String seleccionado) {
		String html = "";
		for (String k : datos.keySet()) {
			html += ("<input id=\"id" + k + "\" type=\"radio\" name=\"" + nombre + "\" value=\"" + k + "\" "
					+ (seleccionado.equals(k) ? "checked=\"checked\"" : "") + "> \n");
			html += ("<label for=\"id" + k + "\">" + datos.get(k) + "</label> <br/>\n\n");
		}
		return html;
	}

	public static String generaCheckboxes(String nombre, Map<String, String> datos, String seleccionado) {

		String html = "";
		for (String k :  datos.keySet()){
			html += ("<input id=\"id" + k + "\" type=\"checkbox\" name=\"" + nombre + "\" value=\"" + k + "\" "
					+ (seleccionado.equals(k) ? "checked=\"checked\"" : "") + "> \n");
			html += ("<label for=\"id" + k + "\">" + datos.get(k) + "</label> <br/>\n\n");
		
		}
		
		return html;
	}
	
	public static String generaSelected(String nombre, Map<String,String> datos, String seleccionado){
		String html="";
		html += ("<select name=\"" + nombre + "\" >\" \n");
		for (String k :  datos.keySet()){
			
			html += ("<option name=\"" + datos.get(k) + "\"> "+datos.get(k)+"</option> <br/>\n\n");
		
		}
		html += ("</select> \n");
		return html;
	}
}
