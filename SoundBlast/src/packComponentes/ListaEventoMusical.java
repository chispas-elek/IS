package packComponentes;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;

public class ListaEventoMusical {

	
	//Variables
	private ArrayList<EventoMusical> lista;

	//Methods
	public ListaEventoMusical() {
		this.lista = new ArrayList<EventoMusical>();
	}
	
	private Iterator<EventoMusical> obIterator() {
		return this.lista.iterator();
	}
	
	public void anadirEvento(EventoMusical pEvento) {
		if(this.buscarEvento(pEvento.getId()) != null) {
			System.out.println("El evento ya existe");
		}
		else {
			this.lista.add(pEvento);
		}
	}
	
	public void eliminarEvento(EventoMusical pEvento) {
		if(this.buscarEvento(pEvento.getId()) == null) {
			System.out.println("El evento no existe");
		}
		else {
			this.lista.remove(pEvento);
		}
	}
	
	public EventoMusical buscarEvento(int pId) {
		Iterator<EventoMusical> it = this.obIterator();
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
	
	public EventoMusical buscarEvento(String pNom) {
		Iterator<EventoMusical> it = this.obIterator();
		boolean found = false;
		EventoMusical evento = null;
		while(it.hasNext() && !found) {
			evento = it.next();
			if(evento.getNombre() == pNom) {
				found = true;
			}
		}
		if(!found) {
			evento = null;
		}
		return evento;
	}
	
	public ListaEventoMusical buscarEvento(Grupo pGrupo) {
		ListaEventoMusical lista = new ListaEventoMusical();
		Iterator<EventoMusical> it = this.obIterator();
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
		Iterator<EventoMusical> it = this.obIterator();
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
		Iterator<EventoMusical> it = this.obIterator();
		while(it.hasNext()) {
			evento = it.next();
			benef = benef + evento.obtenerBeneficio();
		}
		return benef;
	}
	
	public float obtenerBeneficio(EventoMusical pEvento) {
		return this.buscarEvento(pEvento.getId()).obtenerBeneficio();
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
		return this.buscarEvento(pEvento.getId()).getPrecioEntradaVip();
	}
	
	public boolean esta(int pId) {
		Iterator<EventoMusical> it = this.obIterator();
		boolean flag = false;
		EventoMusical ev = null;
		while(it.hasNext() && !flag) {
			ev = it.next();
			if(ev.getId() == pId) {
				flag = true;
			}
		}
		return flag;
	}
	
	public void rellenar(DefaultListModel pLm) {
		Iterator<EventoMusical> it = this.obIterator();
		EventoMusical e = null;
		while(it.hasNext()) {
			e = it.next();
			pLm.addElement(e.getNombre());
		}
	}
	
	public void actualizar(DefaultListModel pLm, String pFilter) {
		Iterator<EventoMusical> it = this.obIterator();
		EventoMusical e = null;
		while(it.hasNext()) {
			e = it.next();
			if(this.buscar(pFilter, e.getNombre())) {
				pLm.addElement(e.getNombre());
			}
		}
	}
	
	private boolean buscar(String pFilter, String pComp) {
		boolean result = true;
		int i = 0;
		while(i<= pComp.length() && i <= pFilter.length()) {
			if(pComp.charAt(i) != pFilter.charAt(i)) {
				result = false;
			}
		}
		return result;
	}
	
}
