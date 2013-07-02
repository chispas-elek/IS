package packGraphics;


import packComponentes.Artista;

import net.sf.jga.fn.UnaryFunctor;

public class Filtrar extends UnaryFunctor<Artista, Boolean>{
	
	//Variables
		private String lista;
		
		//Methods
		public Filtrar(String pLista) {
			lista = pLista;
		}
		
		public String getLista() {
			return lista;
		}
		
		public Boolean fn(Artista ar) {
			return ar.contiene(lista);
		}
}
