package packGraphics;

import java.util.ArrayList;
import java.util.Comparator;

import packComponentes.Artista;

public class Ordenar implements Comparator<String> {
	
	
	//Metodos
	
	public Ordenar() {
		
	}
	
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}
}
