package packGraphics;

import java.util.ArrayList;

import net.sf.jga.fn.BinaryFunctor;

public class Filtrar extends BinaryFunctor<String, String, Boolean>{
	
	//Variables
		private ArrayList<String> lista;
		
		//Methods
		public Filtrar(ArrayList<String> pLista) {
			lista = pLista;
		}
		
		public ArrayList<String> getLista() {
			return lista;
		}
		
		public Boolean fn(String s, String filt) {
			Boolean value = true;
			int i = 0;
			while(i <= s.length() && i <= filt.length() && value) {
				if(s.charAt(i) != filt.charAt(i)) {
				value = false;
				}
			}	
			return value;
		}
}
