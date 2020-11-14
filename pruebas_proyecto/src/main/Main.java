package main;

import java.io.FileNotFoundException;

import interfaz.Interfaz_Inicio;
import javazoom.jl.decoder.JavaLayerException;
import sonidos.Reproducir_mp3;

public class Main {

	public static void main(String[] args) {

		
		Interfaz_Inicio inicio = new Interfaz_Inicio();
		inicio.setLocationRelativeTo(null);
		inicio.setVisible(true);
        
	
		Reproducir_mp3 repro = new Reproducir_mp3();
		
			try {
				repro.reproducir();
			} catch (FileNotFoundException | JavaLayerException e) {
				
				e.printStackTrace();
			}
	
		
	}
}
