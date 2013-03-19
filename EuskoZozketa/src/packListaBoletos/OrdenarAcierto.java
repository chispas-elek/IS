package packListaBoletos;

//Importamos librerías pedidas


import packBombonera.ListaNumeros;
import java.util.Comparator;


public class OrdenarAcierto implements Comparator<Boleto> {
	
	 //Variables
	private ListaNumeros lista;
	
	public OrdenarAcierto(ListaNumeros pLista) {
		lista = pLista;
	}
	
	public ListaNumeros getLista() {
		return lista;
	}
	
	public int compare(Boleto pBol1, Boleto pBol2) {
		int value = 0;
		int i = 0;
		boolean stop = false;
		if((pBol1.obtNumeroAciertos(this.getLista()) != pBol2.obtNumeroAciertos(this.getLista()))) {
			value = (pBol2.obtNumeroAciertos(this.getLista()) - pBol1.obtNumeroAciertos(this.getLista()));
		}
		else {
			while(i <= pBol1.getNombre().length() && i <= pBol2.getNombre().length() && !stop) {
				if(pBol1.getNombre().charAt(i) > pBol2.getNombre().charAt(i)) {
					value = -1;
					stop = true;
				}
				else if(pBol1.getNombre().charAt(i) < pBol2.getNombre().charAt(i)) {
					value = 1;
					stop = true;
				}
				else {
					i++;
				}
			}
		}
		return value;
	}

}
