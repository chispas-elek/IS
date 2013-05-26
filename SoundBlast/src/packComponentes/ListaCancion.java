package packComponentes;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCancion {

	//Variables
	private ArrayList<Cancion> lista;
	
	//Methods
	public ListaCancion() {
		this.lista = new ArrayList<Cancion>();
	}
	
	private Iterator<Cancion> obIterator() {
		return this.lista.iterator();
	}
	
	public void anadirCancion(Cancion pCancion) {
		this.lista.add(pCancion);
	}
	
	public void eliminarCancion(Cancion pCancion) {
		this.lista.remove(pCancion);
	}
	
	public Cancion buscarCancion(String pTitulo) {
		Iterator<Cancion> it = this.obIterator();
		Cancion cancion = null;
		boolean found = false;
		while(it.hasNext() && !found) {
			cancion = it.next();
			if(cancion.getTitulo() == pTitulo) {
				found = true;
			}
		}
		if(!found) {
			cancion = null;
		}
		return cancion;
	}

}
