//Author -> Mulero Martínez, Rubén
//Author -> Esteban García, Asier

package packComponentes;


import java.util.Date;

public class Artista {
	
	//Variables
	private String codArtista = new Date().toString();
	private String nombre, tipo;
	private Date fechaInicio = new Date();
	
	//Methods
	
			//Constructor	
	public Artista(String pNombre, String pTipo) {
		this.nombre = pNombre;
		this.tipo = pTipo;
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
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public void setTipo(String pTipo) {
		this.tipo = pTipo;
	}

}
