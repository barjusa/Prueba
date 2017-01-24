package prueba;

import java.util.Map;

public class util8 {


	public static String ciudad(String pais, Map<String, String> datos, String seleccionado) {
		String html = "";
		for (String k : datos.keySet()) {
			html += ("<input id=\"id" + k + "\" type=\"radio\" name=\"" + pais + "\" value=\"" + datos.get(k) + "\" "
					+ (seleccionado.equals(k) ? "checked=\"checked\"" : "") + "> \n");
			html += ("<label for=\"id" + k + "\">" + datos.get(k) + "</label> <br/>\n\n");
		}
		return html;
	}
}
