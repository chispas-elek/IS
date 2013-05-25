package packComponentes;

import java.util.Date;

public class ArtistaAntiguo extends Artista {
	
	//Variables
	private Date fechaFin;

	//Methods
	public ArtistaAntiguo(Artista pArtista) {
		super(pArtista.getCodigo(), pArtista.getNombre(), pArtista.getTipo(), pArtista.getFInicio());
		this.fechaFin = new Date();
	}
	
	public Date getFechaF() {
		return this.fechaFin;
	}

}
