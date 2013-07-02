package packMae;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;

import net.sf.jga.algorithms.Filter;
import net.sf.jga.algorithms.Sort;

import packComponentes.Artista;
import packComponentes.Disco;
import packComponentes.EventoMusical;
import packComponentes.Genero;
import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;
import packComponentes.ListaEventoMusical;
import packComponentes.ListaGrupo;
import packGraphics.Filtrar;
import packGraphics.FiltrarGrupo;
import packGraphics.Ordenar;

public class CatalogoGrupoArtista {
	
	//Variables
	private static CatalogoGrupoArtista mCatalogoGrupoArtista;
	private ListaGrupo lista;
	private ListaArtista listaA;

	//Methods
	private CatalogoGrupoArtista() {
		this.lista = new ListaGrupo();
		this.listaA = new ListaArtista();
	}
	
	public static CatalogoGrupoArtista getCatalogoGrupoArtista() {
		if(mCatalogoGrupoArtista == null) {
			mCatalogoGrupoArtista = new CatalogoGrupoArtista();
		}
		return mCatalogoGrupoArtista;
	}
	
	public void addGrupo(String pNombre, String pLogo) {
		//System.out.println(pNombre);
		this.lista.addGrupo(pNombre, pLogo);
		//System.out.println("tutto bene");
	}
	
	public Grupo getGrupo(String pNombre) {
		Grupo grupo = this.lista.getGrupo(pNombre);
		return grupo;
	}
	
	public void eliminarGrupo(String pNombre) {
		if(this.getGrupo(pNombre) != null) {
			this.lista.eliminarGrupo(pNombre);
		}
		else {
			System.out.println("El grupo especificado no existe");
		}
	}
	
	public void anadirIntegrante(Artista pArtista, Grupo pGrupo) {
		this.getGrupo(pGrupo.getNombre()).anadirIntegrante(pArtista);
		this.listaA.addArtista(pArtista);
	}
	
	public void reemplazarIntegrante(Artista pArtistaN, Artista pArtistaV, String pGrupo) {
		this.lista.reemplazarIntegrante(pArtistaN, pArtistaV, pGrupo);
		//this.listaA.addArtista(this.lista.getGrupo(pGrupo).buscarComponente(pArtistaN));
	}
	
	public Disco buscarDisco(String pNombre, Grupo pGrupo) {
		return this.getGrupo(pGrupo.getNombre()).buscarDisco(pNombre);
	}
	
	public void anadirEvento(EventoMusical pEvento) {
		CatalogoEventoMusical.getCatalogoEventoMusical().anadirEvento(pEvento);
	}
	
	public void eliminarEvento(EventoMusical pEvento) {
		CatalogoEventoMusical.getCatalogoEventoMusical().eliminarEvento(pEvento);
	}
	
	public EventoMusical buscarEvento(int pId) {
		return CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento(pId);
	}
	
	public ListaEventoMusical buscarEventos(Grupo pGrupo) {
		return CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento(pGrupo);
	}
	
	public ListaEventoMusical buscarFestivalesPorGenero(Genero pGenero) {
		return CatalogoEventoMusical.getCatalogoEventoMusical().buscarFestivalesPorGenero(pGenero);
	}
	
	public float obtenerBeneficio() {
		return CatalogoEventoMusical.getCatalogoEventoMusical().obtenerBeneficio();
	}
	
	public float obtenerBeneficio(EventoMusical pEvento) {
		return CatalogoEventoMusical.getCatalogoEventoMusical().obtenerBeneficio(pEvento);
	}
	
	
	public void anadirDisco(Grupo pGrupo, String pNom, Date pAno, Genero pGen, int pDur) {
		this.getGrupo(pGrupo.getNombre()).anadirDisco(pNom, pAno, pGen, pDur);
	}
	
	public Iterator<String> ordenar() {
		ArrayList<String> sr = new ArrayList<String>();
		Iterator<String> it = Sort.sort(this.listaA.rellenar(), new Ordenar());
		while(it.hasNext()) {
			sr.add(it.next());
		}
		return sr.iterator();
	}
	
	public Iterator<String> filtrarArtistas(String pFilter) {
		ArrayList<String> sr = new ArrayList<String>();
		Iterator<Artista> it = Filter.filter(this.listaA.getArtistas(), new Filtrar(pFilter)).iterator();
		while(it.hasNext()) {
			sr.add(it.next().getNombre());
		}
		return sr.iterator();
	}
	
	public Iterator<String> filtrarGrupos(String pFilter) {
		ArrayList<String> sr = new ArrayList<String>();
		Iterator<Grupo> it = Filter.filter(this.lista.getGrupos(), new FiltrarGrupo(pFilter)).iterator();
		while(it.hasNext()) {
			sr.add(it.next().getNombre());
		}
		return sr.iterator();
	}
	
	public Iterator<String> rellenar() {
		return this.lista.rellenar();
		
	}
	
	public Iterator<String> rellenarArtistas() {
		return this.listaA.rellenar();
	}
}
