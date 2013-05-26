package packMae;

import java.util.Date;

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

	//Methods
	private CatalogoGrupoArtista() {
		this.lista = new ListaGrupo();
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
		this.getGrupo(pGrupo.getNombre()).anadirIntegrante(pArtista);
	}
	
	public void reemplazarIntegrante(Artista pArtistaN, Artista pArtistaV, Grupo pGrupo) {
		this.lista.reemplazarIntegrante(pArtistaN, pArtistaV, pGrupo);
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
	
	public ListaGrupo getGrupos() {
		return this.lista;
	}
	
	public void anadirDisco(Grupo pGrupo, String pNom, Date pAno, Genero pGen, int pDur) {
		this.getGrupo(pGrupo.getNombre()).anadirDisco(pNom, pAno, pGen, pDur);
	}
	
}
