package packComponentes;

import java.util.Date;

public class ArtistaAntiguo extends Artista {
	
	//Variables
	private Date fechaFin;

	//Methods
	public ArtistaAntiguo(String pCodArtista, String pNombre, String pTipo, Date PFecha) {
		super(pCodArtista, pNombre, pTipo, PFecha);
		this.fechaFin = new Date();
	}
	
	public Date getFechaF() {
		return this.fechaFin;
	}

}
