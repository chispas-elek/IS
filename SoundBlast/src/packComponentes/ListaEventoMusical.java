package packComponentes;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEventoMusical {

	
	//Variables
	private ArrayList<EventoMusical> lista;

	//Methods
	public ListaEventoMusical() {
		this.lista = new ArrayList<EventoMusical>();
	}
	
	private Iterator<EventoMusical> obtIterator() {
		return this.lista.iterator();
	}
	
	public void anadirEvento(EventoMusical pEvento) {
		
	}
	
	public void eliminarEvento(EventoMusical pEvento) {
		
	}
	
	public EventoMusical buscarEvento(int pId) {
		Iterator<EventoMusical> it = this.obtIterator();
		boolean found = false;
		EventoMusical evento = null;
		while(it.hasNext() && !found) {
			evento = it.next();
			if(evento.getId() == pId) {
				found = true;
			}
		}
		if(!found) {
			evento = null;
		}
		return evento;
	}
	
	public ListaEventoMusical buscarEventos(Grupo pGrupo) {
		ListaEventoMusical lista = new ListaEventoMusical();
		Iterator<EventoMusical> it = this.obtIterator();
		EventoMusical evento = null;
		while(it.hasNext()) {
			evento = it.next();
			if(evento.getGruposParticipantes().getGrupo(pGrupo.getNombre()) != null) {
				lista.anadirEvento(evento);
			}
		}
		return lista;
	}
	
	public ListaEventoMusical buscarFestivalesPorGenero(Genero pGenero) {
		ListaEventoMusical lista = new ListaEventoMusical();
		Iterator<EventoMusical> it = this.obtIterator();
		EventoMusical evento = null;
		while(it.hasNext()) {
			evento = it.next();
			if(evento.getGenero() == pGenero) {
				lista.anadirEvento(evento);
			}
		}
		return lista;
	}
	
	public float obtenerBeneficio() {
		float benef = 0;
		EventoMusical evento;
		Iterator<EventoMusical> it = this.obtIterator();
		while(it.hasNext()) {
			evento = it.next();
			benef = benef + evento.obtenerBeneficio();
		}
		return benef;
	}
	
	public boolean comprarEntrada(EventoMusical pEvento) {
		return this.buscarEvento(pEvento.getId()).venderEntradaNormal();
	}
	
	public boolean comprarEntradaVip(EventoMusical pEvento) {
		return this.buscarEvento(pEvento.getId()).venderEntradaVip();
	}
	
	public float obtenerPrecioEntrada(EventoMusical pEvento) {
		return this.buscarEvento(pEvento.getId()).getPrecioEntrada();
	}
	
	public float obtenerPrecioEntradaVip(EventoMusical pEvento) {
		return this.buscarEvento(pEvento.getId()).getPrecioVip();
	}
	
	
	
}
