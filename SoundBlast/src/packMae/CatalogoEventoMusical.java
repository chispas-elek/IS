package packMae;

import javax.swing.DefaultListModel;

import packComponentes.EventoMusical;
import packComponentes.Genero;
import packComponentes.Grupo;
import packComponentes.ListaEventoMusical;

public class CatalogoEventoMusical {
	
	//Variables
	private static CatalogoEventoMusical mCatalogoEventoMusical;
	private ListaEventoMusical lista;
	
	private CatalogoEventoMusical() {
		lista = new ListaEventoMusical();
	}
	
	public static CatalogoEventoMusical getCatalogoEventoMusical() {
		if(mCatalogoEventoMusical == null) {
			mCatalogoEventoMusical = new CatalogoEventoMusical();
		}
		return mCatalogoEventoMusical;
	}
	
	public void anadirEvento(EventoMusical pEvento) {
		this.lista.anadirEvento(pEvento);
	}
	
	public void eliminarEvento(EventoMusical pEvento) {
		this.lista.eliminarEvento(pEvento);
	}
	
	public EventoMusical buscarEvento(int pId) {
		return this.lista.buscarEvento(pId);
	}
	
	public ListaEventoMusical buscarEvento(Grupo pGrupo) {
		return this.lista.buscarEvento(pGrupo);
	}
	
	public EventoMusical buscarEvento(String pNom) {
		return this.lista.buscarEvento(pNom);
	}
	
	public ListaEventoMusical buscarFestivalesPorGenero(Genero pGen) {
		return this.lista.buscarFestivalesPorGenero(pGen);
	}
	
	public float obtenerBeneficio(EventoMusical pEvento) {
		return this.lista.obtenerBeneficio(pEvento);
	}
	
	public float obtenerBeneficio() {
		return this.lista.obtenerBeneficio();
	}
	
	public boolean comprarEntrada(EventoMusical pEvento) {
		return this.lista.comprarEntrada(pEvento);
	}
	
	public boolean comprarEntradaVip(EventoMusical pEvento) {
		return this.lista.comprarEntradaVip(pEvento);
	}
	
	public float obtenerPrecioEntrada(EventoMusical pEvento) {
		return this.lista.obtenerPrecioEntrada(pEvento);
	}
	
	public float obtenerPrecioEntradaVip(EventoMusical pEvento) {
		return this.lista.obtenerPrecioEntradaVip(pEvento);
	}
	
	public boolean esta(EventoMusical pEvento) {
		return this.esta(pEvento);
	}
	
	public boolean esta(int pId) {
		return this.lista.esta(pId);
	}
	
	public void rellenar(DefaultListModel pLm) {
		this.lista.rellenar(pLm);
	}
	
public void actualizar(DefaultListModel pLm, String pFilter) {
		this.lista.actualizar(pLm, pFilter);
	}

}
