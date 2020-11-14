package sonidos;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.*;

public class Reproducir_mp3 {
	
	
	
	public void reproducir () throws FileNotFoundException, JavaLayerException {
		
		Player rep = new Player(new FileInputStream("C:/Users/Boing/git/POO_Proyecto_Grupo7/pruebas_proyecto/src/sonidos/Fondo.mp3"));
		rep.play();
		
	}
	
	
	
	

}
