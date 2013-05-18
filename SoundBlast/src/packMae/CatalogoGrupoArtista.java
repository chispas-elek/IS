package packMae;

import packComponentes.Artista;
import packComponentes.Disco;
import packComponentes.EventoMusical;
import packComponentes.Genero;
import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;
import packComponentes.ListaEventoMusical;
import packComponentes.ListaGrupo;

public class CatalogoGrupoArtista {
	
	//Variables
	private static CatalogoGrupoArtista mCatalogoGrupoArtista;
	private ListaGrupo lista;
	private ListaEventoMusical listaEM;

	//Methods
	private CatalogoGrupoArtista() {
		this.lista = new ListaGrupo();
		this.listaEM = new ListaEventoMusical();
	}
	
	public static CatalogoGrupoArtista getCatalogoGrupoArtista() {
		if(mCatalogoGrupoArtista == null) {
			mCatalogoGrupoArtista = new CatalogoGrupoArtista();
		}
		return mCatalogoGrupoArtista;
	}
	
	public void addGrupo(String pNombre, String pLogo, ListaArtista pComponentes, ListaArtista pComponentesAntiguos, ListaDisco pDiscografia) {
		this.lista.addGrupo(pNombre, pLogo, pComponentes, pComponentesAntiguos, pDiscografia);
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
		this.getGrupo(pGrupo.getNombre()).addComponente(pArtista);
	}
	
	public void reemplazarIntegrante(Artista pArtistaN, Artista pArtistaV, Grupo pGrupo) {
		this.getGrupo(pGrupo.getNombre()).reemplazarIntegrante(pArtistaV, pArtistaN);
	}
	
	public Disco buscarDisco(String pNombre, Grupo pGrupo) {
		return this.buscarDisco(pNombre, pGrupo);
	}
	
	public void anadirEvento(EventoMusical pEvento) {
		this.listaEM.anadirEvento(pEvento);
	}
	
	public void eliminarEvento(EventoMusical pEvento) {
		this.listaEM.eliminarEvento(pEvento);
	}
	
	public EventoMusical buscarEvento(int pId) {
		return this.listaEM.buscarEvento(pId);
	}
	
	public ListaEventoMusical buscarEventos(Grupo pGrupo) {
		return this.buscarEventos(pGrupo);
	}
	
	public ListaEventoMusical buscarFestivalesPorGenero(Genero pGenero) {
		return this.listaEM.buscarFestivalesPorGenero(pGenero);
	}
	
	public float obtenerBeneficio() {
		return this.listaEM.obtenerBeneficio();
	}	
}
