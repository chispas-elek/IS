package packComponentes;

import java.util.Date;

public class RuedaPrensa extends EventoMusical {

	//Variables
	private String descripcion;

	public RuedaPrensa(int pId, int pMaxEntradas, String pNombre, String pLugar, Date pFecha, Date pHora, float pPrecioEntrada, float pPrecioVip, Genero pGenero, ListaGrupo pGruposParticipantes, ListaEntrada pListaEntradas, String pDescripcion) {
		super(pId, pMaxEntradas, pNombre, pLugar, pFecha, pHora, pPrecioEntrada, pPrecioVip, pGenero, pGruposParticipantes, pListaEntradas);
		this.descripcion = pDescripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	

}
