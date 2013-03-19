//Author --> Esteban García, Asier

package packListaBoletos;
import java.util.ArrayList;
import java.util.Iterator;

import net.sf.jga.algorithms.Filter;
import net.sf.jga.algorithms.Sort;
import packListaBoletos.Boleto;
import packBombonera.Bombonera;
import packBombonera.ListaNumeros;

//Importamos las librerias JGA Pedidas por la profesora.

public class ListaBoletos {
	
		//Variables
	private static ListaBoletos mListaBoletos = null;
	private ArrayList<Boleto> listaBoletos;
	
	
		//Methods
	private ListaBoletos() {
		listaBoletos = new ArrayList<Boleto>();
	}//ListaBoletos
	
	public static ListaBoletos getListaBoletos() {
		if(mListaBoletos == null) {
			mListaBoletos = new ListaBoletos();
		}
		return mListaBoletos;
	}//getListaBoletos
	
	public Iterator<Boleto> obtIterator() {
		return listaBoletos.iterator();
	}//obtIterator
	
	public Iterator<Boleto> getPremiados() {
		Bombonera lBombonera = Bombonera.getBombonera();
		ListaNumeros numPremiados = lBombonera.realizarSorteo();
		Iterator<Boleto> it = this.obtIterator();
		ArrayList<Boleto> bolPremiados = new ArrayList<Boleto>();
		Boleto actBoleto;
		
		//Methods
		while(it.hasNext() == true) {
			actBoleto = it.next();
			if(actBoleto.obtNumeroAciertos(numPremiados) >= 4) {
				bolPremiados.add(actBoleto);
			}//if
		}//while
		return bolPremiados.iterator();
	}//getPremiados
	
	//Voy a implementar de nuevo la misma clase pero utilizando JGA
	public Iterator<Boleto> getPremiados2() {
		Bombonera lBombonera = Bombonera.getBombonera();
		ListaNumeros numPremiados = lBombonera.realizarSorteo();
		Iterator<Boleto> it = Filter.filter(this.listaBoletos, new ClasificarAcierto(numPremiados)).iterator();
		Iterator<Boleto> result = Sort.sort(it, new OrdenarAcierto(numPremiados));
		return result;
	}
}//ListaBoletos
