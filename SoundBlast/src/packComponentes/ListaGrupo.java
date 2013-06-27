package packComponentes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;

public class ListaGrupo {
	
	//Variables
	private ArrayList<Grupo> lista;
	
	//Methods
	public ListaGrupo()  {
		this.lista = new ArrayList<Grupo>();
	}
	
	public void addGrupo(String pNombre, String pLogo) {
		Grupo grupo = new Grupo(pNombre, pLogo);
		this.lista.add(grupo);
	}
	
	private Iterator<Grupo> obIterator() {
		return this.lista.iterator();
	}
	
	public Grupo getGrupo(String pNombre) {
		Iterator<Grupo> it = this.obIterator();
		Grupo gr = null;
		boolean found = false;
		while(it.hasNext() && !found) {
			gr = it.next();
			if(pNombre == gr.getNombre()) {
				found = true;
			}
		}
		if(!found) {
			gr = null;
		}
		return gr;
	}
	
	public void eliminarGrupo(String pNombre) {
		if(this.getGrupo(pNombre) != null) {
			this.lista.remove(this.getGrupo(pNombre));
		}
	}
	
	public Disco buscarDisco(String pNombre, Grupo pGrupo) {
		return this.getGrupo(pGrupo.getNombre()).buscarDisco(pNombre);
	}
	
	public ArrayList<Grupo> getLista() {
		return this.lista;
	}
	
	public void anadirIntegrante(String pNom, String pTipo, Grupo pGrupo) {
		Artista pComponente = new Artista(pNom,pTipo);
		this.getGrupo(pGrupo.getNombre()).anadirIntegrante(pComponente);
	}
	
	public void reemplazarIntegrante(Artista pArtistaN, Artista pArtistaV, Grupo pGrupo) {
		this.getGrupo(pGrupo.getNombre()).reemplazarIntegrante(pArtistaV, pArtistaN);
	}
	
	public DefaultListModel rellenar(DefaultListModel pLm) {
		Iterator<Grupo> it = obIterator();
		Grupo gr = null;
		while(it.hasNext()) {
			gr = it.next();
			pLm.addElement(gr.getNombre());
		}
		return pLm;
	}

}
