package packGraphics;

import java.util.ArrayList;
import java.util.Comparator;

import packComponentes.Artista;

public class Ordenar implements Comparator<String> {
	
	//Variables
	private ArrayList<String> lista;
	
	
	//Metodos
	
	public Ordenar(ArrayList<String> pLista) {
		lista = pLista;
	}
	
	public int compare(String s1, String s2) {
		int value = 0;
		int i = 0;
		boolean stop = false;
			while(i <= s1.length() && i <= s2.length() && !stop) {
				if(s1.charAt(i) > s2.charAt(i)) {
					value = -1;
					stop = true;
				}
				else if(s1.charAt(i) < s2.charAt(i)) {
					value = 1;
					stop = true;
				}
				else {
					i++;
				}
			}
		return value;
	}
}
