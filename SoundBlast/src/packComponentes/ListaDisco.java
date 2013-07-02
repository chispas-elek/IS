package packComponentes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import javax.swing.DefaultListModel;

public class ListaDisco {

	//Variables
	private ArrayList<Disco> lista;
	
	public ListaDisco() {
		this.lista = new ArrayList<Disco>();
	}
	
	private Iterator<Disco> obIterator() {
		return this.lista.iterator();
	}
	
	public void addDisco(String pNombre, Date pAño, Genero pGenero, int pDuracion) {
		ListaCancion pLista = new ListaCancion();
		Disco disc = new Disco(pNombre, pAño, pDuracion, pLista, pGenero);
		this.lista.add(disc);
	}
	
	public void elimDisco(Disco pDisco) {
		try {
			if(this.buscarDisco(pDisco.getNombreDisco()) != null) {
				this.lista.remove(pDisco);
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e){
			System.out.println("El disco no existe");
		}
	}
	
	public Disco buscarDisco(String pNombre) {
		Iterator<Disco> it = this.obIterator();
		Disco disc = null;
		boolean found = false;
		while(it.hasNext() && !found) {
			disc = it.next();
			if(disc.getNombreDisco() == pNombre) {
				found = true;
			}
		}
		if(!found) {
			disc = null;
		}
		return disc;
	}
	
	public Iterator<String> actualizar() {
		Iterator<Disco> it = this.obIterator();
		ArrayList<String> sr = new ArrayList<String>();
		Disco disco = null;
		while(it.hasNext()) {
			disco = it.next();
			sr.add(disco.getNombreDisco());
		}
		return sr.iterator();
	}
	
	
}
