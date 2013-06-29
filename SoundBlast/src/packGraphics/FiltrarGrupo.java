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
			Boolean value = true;
			int i = 0;
			while(i <= gr.getNombre().length() && i <= getLista().length() && value) {
				if(gr.getNombre().charAt(i) != getLista().charAt(i)) {
				value = false;
				}
			}	
			return value;
		}
}