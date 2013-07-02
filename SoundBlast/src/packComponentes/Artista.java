//Author -> Mulero Martínez, Rubén
//Author -> Esteban García, Asier

package packComponentes;


import java.util.Date;

public class Artista {
	
	//Variables
	private String codArtista = new Date().toString();
	private String nombre;
	private Tipo tipo;
	private Date fechaInicio = new Date();
	
	//Methods
	
			//Constructor	
	public Artista(String pNombre, Tipo pTipo) {
		this.nombre = pNombre;
		this.tipo = pTipo;
	}
	
	public Tipo getTipo() {
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
	
	public void setTipo(Tipo pTipo) {
		this.tipo = pTipo;
	}
	
	public boolean contiene(String pFilter) {
		boolean result = true;
		int i = 0;
		while(i <= this.getNombre().length() && i <= pFilter.length() && result) {
			if(this.getNombre().charAt(i) != pFilter.charAt(i)) {
			result = false;
			}
		}
		return result;
	}

}
