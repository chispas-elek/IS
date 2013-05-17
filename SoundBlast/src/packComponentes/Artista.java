//Author -> Mulero Martínez, Rubén
//Author -> Esteban García, Asier

package packComponentes;

import java.util.Date;

public class Artista {
	
	//Variables
	private String codArtista, nombre, tipo;
	private Date fechaInicio;
	
	//Methods
	
			//Constructor	
	public Artista(String pCodArtista, String pNombre, String pTipo, Date pFecha) {
		this.codArtista = pCodArtista;
		this.nombre = pNombre;
		this.tipo = pTipo;
		this.fechaInicio = pFecha;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCodigo() {
		return this.codArtista;
	}
	
	public Date getFInicio() {
		return this.fechaInicio;
	}

}
