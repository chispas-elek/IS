package packComponentes;

import java.util.Date;

public class Festival extends EventoMusical {

	//Variables
		private int aforo;

	
	//Methods
	public Festival(int pMaxEntradas, String pNombre, String pLugar, Date pFecha, Date pHora, int pPrecioEntrada, int pPrecioVip, Genero pGenero, ListaGrupo pGruposParticipantes, ListaEntrada pListaEntradas, int pAforo) {
		super(pMaxEntradas, pNombre, pLugar, pFecha, pHora, pPrecioEntrada, pPrecioVip, pGenero, pGruposParticipantes, pListaEntradas);
		this.aforo = pAforo;
	}
		
	public int getAforo() {
		return this.aforo;
	}

}
