package packListaBoletos;

//Importamos librerías pedidas

import net.sf.jga.fn.UnaryFunctor;
import packBombonera.ListaNumeros;

public class ClasificarAcierto extends UnaryFunctor<Boleto, Boolean> {
	
	//Variables
	private ListaNumeros lista;
	
	//Methods
	public ClasificarAcierto(ListaNumeros pLista) {
		lista = pLista;
	}
	
	public ListaNumeros getLista() {
		return lista;
	}
	
	public Boolean fn(Boleto pBoleto) {
		Boolean value = false;
		if(pBoleto.obtNumeroAciertos(this.getLista()) >= 4) {
			value = true;
		}
		return value;
	}
}
