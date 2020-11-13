package main;

public class Eliminar_Espacios {

	public String EliminarEspacios(String cadena) {

		StringBuilder nuevaCadena = new StringBuilder(cadena);

		int i = 0;

		while (i < nuevaCadena.length()) {
			if (cadena.charAt(i) == ' ' || cadena.charAt(i) == '\n' || cadena.charAt(i)=='.') {
				
				nuevaCadena.deleteCharAt(i);
                i--;
			}
            i++; 
			
		}
		return nuevaCadena.toString();

	}
}
