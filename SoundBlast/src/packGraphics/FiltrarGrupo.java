package packGraphics;


import packComponentes.Artista;
import packComponentes.Grupo;

import net.sf.jga.fn.UnaryFunctor;

public class FiltrarGrupo extends UnaryFunctor<Grupo, Boolean>{
	
	//Variables
		private String lista;
		
		//Methods
		public FiltrarGrupo(String pLista) {
			lista = pLista;
		}
		
		public String getLista() {
			return lista;
		}
		
		public Boolean fn(Grupo gr) {
			return gr.contiene(lista);
		}
}