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
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
	}
}
