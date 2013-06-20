package packComponentes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class ListaArtista {

	//Variables
	private ArrayList<Artista> listaArtistas;

	//Methods
	public ListaArtista(ArrayList<Artista> pListaArtistas) {
		this.listaArtistas = pListaArtistas;
	}
	
	public ListaArtista() {
		this.listaArtistas = new ArrayList<Artista>();
	}
	
	private Iterator<Artista> obIterator() {
		return this.listaArtistas.iterator();
	}
	
	public Artista getSolista() {
		Artista pAr = null;
		boolean found = false;
		Iterator<Artista> it = this.obIterator();
		while(it.hasNext() && !found) {
			pAr = it.next();
			if(pAr.getTipo() == "solista") {
				found = true;
			}
		}
		if(found = false) {
			pAr = null;
		}
		return pAr;
	}
	
	public void addArtista(String pNombre, String pTipo) {
		this.listaArtistas.add(new Artista(Calendar.getInstance().getTime().toString(), pNombre, pTipo, new Date()));
	}
	
	public void addArtista(Artista pArtista) {
		this.listaArtistas.add(pArtista);
	}
	
	public boolean estaArtista(Artista pArtista) {
		Artista pAr = null;
		boolean found = false;
		Iterator<Artista> it = this.obIterator();
		while(it.hasNext() && !found) {
			pAr = it.next();
			if(pAr == pArtista) {
				found = true;
			}
		}
		return found;
	}
	
	public void eliminarArtista(Artista pArtista) {
		this.listaArtistas.remove(pArtista);
	}
	
	public ArrayList<String> extraerNombres() {
		ArrayList<String> data = new ArrayList<String>();
		Iterator<Artista> it = this.obIterator();
		Artista ar = null;
		while(it.hasNext()) {
			ar = it.next();
			data.add(ar.getNombre());
		}
		return data;
	}
	
}
