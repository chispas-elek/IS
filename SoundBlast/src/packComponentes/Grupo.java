package packComponentes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;


public class Grupo {
	
	//Variables
	private String nombre, logo;
	private ListaArtista componentes, componentesAnteriores;
	private ListaDisco discografia;
	
	
	//Methods
	public Grupo(String pNombre, String pLogo) {
		this.nombre = pNombre;
		this.logo = pLogo;
		this.componentes = new ListaArtista();
		this.componentesAnteriores = new ListaArtista();
		this.discografia = new ListaDisco();
	}
	
	public void anadirIntegrante(Artista pComponente) {
		componentes.addArtista(pComponente);
	}
	
	public void eliminarComponente(Artista pComponente) {
		componentes.eliminarArtista(pComponente);
	}
	
	public Artista buscarComponente(String pComponente) {
		return componentes.buscarArtista(pComponente);
	}
	
	public Artista getSolista() {
		return componentes.getSolista();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getLogo() {
		return logo;
	}

	public ListaArtista getComponentes() {
		return componentes;
	}

	public ListaArtista getComponentesAnteriores() {
		return componentesAnteriores;
	}

	public ListaDisco getDiscografia() {
		return discografia;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public void setLogo(String pLogo) {
		this.logo = pLogo;
	}
	
	public void reemplazarIntegrante(String pViejo, String pNuevo) {
		
		if(!this.getComponentes().estaArtista(pViejo)) {
			System.out.println("El artista no existe");
		}
		else {
			ArtistaAntiguo pArt = new ArtistaAntiguo(buscarComponente(pViejo));
			componentesAnteriores.addArtista(pArt);
			this.eliminarComponente(buscarComponente(pViejo));
			this.anadirIntegrante(buscarComponente(pNuevo));	
		}
	}
	
	public Disco buscarDisco(String pNombre) {
		return discografia.buscarDisco(pNombre);
	}
	
	public void anadirDisco(String pNom, Date pAno, Genero pGen, int pDur) {
		this.discografia.addDisco(pNom, pAno, pGen, pDur);
	}
	
	public DefaultListModel actArt(DefaultListModel pLm) {
		return this.componentes.actualizar(pLm);
	}
	
	public DefaultListModel actDis(DefaultListModel pLm) {
		return this.discografia.actualizar(pLm);
	}
	
	public DefaultListModel actArtAnt(DefaultListModel pLm) {
		return this.componentesAnteriores.actualizar(pLm);
	}
}
