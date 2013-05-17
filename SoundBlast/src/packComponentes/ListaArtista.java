package packComponentes;

import java.util.ArrayList;
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
	
	private Iterator<Artista> obtIterator() {
		return this.listaArtistas.iterator();
	}
	
	private String generateCode() {
		Long t = System.currentTimeMillis();
		String pData = t.toString();
		return pData;
	}
	
	public Artista getSolista() {
		Artista pAr = null;
		boolean found = false;
		Iterator<Artista> it = this.obtIterator();
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
		Date date = new Date();
		Artista pAr = new Artista(this.generateCode(), pNombre, pTipo, date);
		this.listaArtistas.add(pAr);
	}
	
	public void addArtista(Artista pArtista) {
		this.listaArtistas.add(pArtista);
	}
	
	public boolean estaArtista(Artista pArtista) {
		Artista pAr = null;
		boolean found = false;
		Iterator<Artista> it = this.obtIterator();
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
	
}
