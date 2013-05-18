package packComponentes;

import java.util.Date;

public class Festival extends EventoMusical {

	//Variables
		private int aforo;

	
	//Methods
	public Festival(int pId, int pMaxEntradas, String pNombre, String pLugar, Date pFecha, Date pHora, float pPrecioEntrada, float pPrecioVip, Genero pGenero, ListaGrupo pGruposParticipantes, ListaEntrada pListaEntradas, int pAforo) {
		super(pId, pMaxEntradas, pNombre, pLugar, pFecha, pHora, pPrecioEntrada, pPrecioVip, pGenero, pGruposParticipantes, pListaEntradas);
		this.aforo = pAforo;
	}
		
	public int getAforo() {
		return this.aforo;
	}

}
