package packComponentes;

import java.util.Date;

public class Disco {
	
	//Variables
	private String nombreDisco;
	private Date año;
	private Genero gen;
	private int duracionTotal;
	private ListaCancion canciones;
	
	
	//Methods
	public Disco(String pNombreDisco, Date pAño, int pDuracion, ListaCancion pCanciones, Genero pGen) {
		this.nombreDisco = pNombreDisco;
		this.año = pAño;
		this.duracionTotal = pDuracion;
		this.canciones = pCanciones;
		this.gen = pGen;
		
	}


	public String getNombreDisco() {
		return nombreDisco;
	}


	public Date getAño() {
		return año;
	}


	public int getDuracionTotal() {
		return duracionTotal;
	}


	public ListaCancion getCanciones() {
		return canciones;
	}
	
	public Genero getGenero() {
		return this.gen;
	}
	
}
