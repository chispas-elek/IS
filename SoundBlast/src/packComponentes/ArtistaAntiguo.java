package packComponentes;

import java.util.Date;

public class ArtistaAntiguo extends Artista {
	
	//Variables
	private Date fechaFin;

	//Methods
	public ArtistaAntiguo(Artista pArtista) {
		super(pArtista.getNombre(), pArtista.getTipo());
		this.fechaFin = new Date();
	}
	
	public Date getFechaF() {
		return this.fechaFin;
	}

}
