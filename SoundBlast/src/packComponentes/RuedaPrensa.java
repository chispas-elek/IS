package packComponentes;

import java.util.Date;

public class RuedaPrensa extends EventoMusical {

	//Variables
	private String descripcion;

	public RuedaPrensa( String pNombre, String pLugar, Date pFecha, Date pHora, Genero pGenero, ListaGrupo pGruposParticipantes, String pDescripcion) {
		super(0, pNombre, pLugar, pFecha, pHora, 0, 0, pGenero, pGruposParticipantes, null);
		this.descripcion = pDescripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	

}
