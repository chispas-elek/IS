package packComponentes;

import java.util.Date;
import java.util.Random;

public abstract class EventoMusical {
	
	//Variables
	private int id, maxEntradas;
	private String nombre, lugar;
	private Date fecha,hora;
	private int precioEntrada, precioVip;
	private Genero genero;
	private ListaGrupo gruposParticipantes;
	private ListaEntrada listaEntradas;
	public EventoMusical(int pMaxEntradas, String pNombre, String pLugar, Date pFecha, Date pHora, int pPrecioEntrada, int pPrecioVip, Genero pGenero, ListaGrupo pGruposParticipantes, ListaEntrada pListaEntradas) {
		Random rnd = new Random();
		this.id = rnd.nextInt();
		this.maxEntradas = pMaxEntradas;
		this.nombre = pNombre;
		this.lugar = pLugar;
		this.fecha = pFecha;
		this.hora = pHora;
		this.precioEntrada = pPrecioEntrada;
		this.precioVip = pPrecioVip;
		this.genero = pGenero;
		this.gruposParticipantes = pGruposParticipantes;
		this.listaEntradas = pListaEntradas;
	}
	
	public int getId() {
		return this.id;
	}

	public int getMaxEntradas() {
		return this.maxEntradas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getLugar() {
		return this.lugar;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public Date getHora() {
		return this.hora;
	}

	public int getPrecioEntrada() {
		return this.precioEntrada;
	}

	public int getPrecioEntradaVip() {
		return this.precioVip;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public ListaGrupo getGruposParticipantes() {
		return this.gruposParticipantes;
	}

	public ListaEntrada getListaEntradas() {
		return this.listaEntradas;
	}

	public boolean venderEntradaNormal() {
		boolean success = false;
		if(!haAlcanzadoMaximo()) {
		this.listaEntradas.venderEntrada(this.precioEntrada);
		success = true;
		}
		return success;
	}
	
	public boolean venderEntradaVip() {
		boolean success = false;
		if(!haAlcanzadoMaximo()) {
		this.listaEntradas.venderEntrada(this.precioVip);
		success = true;
		}
		return success;
	}
	
	public boolean haAlcanzadoMaximo() {
		boolean sol = false;
		if(this.listaEntradas.cuantasTiene() == this.maxEntradas) {
			sol = true;
		}
		return sol;
	}
	
	public int obtenerBeneficio() {
		return this.listaEntradas.calcularBeneficio();
	}
	
	public int cuantasTiene() {
		return this.listaEntradas.cuantasTiene();
	}
	
	
	
	

}
