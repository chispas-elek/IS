package packMae;

import java.util.Iterator;

import javax.swing.DefaultListModel;

import packComponentes.Concierto;
import packComponentes.EventoMusical;
import packComponentes.Festival;
import packComponentes.Genero;
import packComponentes.Grupo;
import packComponentes.ListaEventoMusical;
import packComponentes.RuedaPrensa;

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
	
	public int obtenerBeneficio(EventoMusical pEvento) {
		return this.lista.obtenerBeneficio(pEvento);
	}
	
	public int obtenerBeneficio() {
		return this.lista.obtenerBeneficio();
	}
	
	public boolean comprarEntrada(EventoMusical pEvento) {
		return this.lista.comprarEntrada(pEvento);
	}
	
	public boolean comprarEntradaVip(EventoMusical pEvento) {
		return this.lista.comprarEntradaVip(pEvento);
	}
	
	public int obtenerPrecioEntrada(EventoMusical pEvento) {
		return this.lista.obtenerPrecioEntrada(pEvento);
	}
	
	public int obtenerPrecioEntradaVip(EventoMusical pEvento) {
		return this.lista.obtenerPrecioEntradaVip(pEvento);
	}
	
	public boolean esta(EventoMusical pEvento) {
		return this.esta(pEvento);
	}
	
	public boolean esta(int pId) {
		return this.lista.esta(pId);
	}
	
	public Iterator<String> rellenar() {
		return this.lista.rellenar();
	}
	
	public Iterator<String> actualizar(String pFilter) {
		return this.lista.actualizar(pFilter);
	}
	
	public void anadirConcierto(Concierto pCon) {
		this.lista.anadirEvento(pCon);
	}
	
	public void anadirFestival(Festival pFes) {
		this.lista.anadirEvento(pFes);
	}

	public void anadirRPrensa(RuedaPrensa pRP) {
		this.lista.anadirEvento(pRP);
	}
}
