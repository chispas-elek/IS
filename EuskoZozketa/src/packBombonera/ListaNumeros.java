//Author --> Esteban García, Asier

package packBombonera;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaNumeros {
	
		//Variables
	private ArrayList<Integer> listaNumeros;
	
	
		//Methods
	public ListaNumeros() {
		listaNumeros = new ArrayList<Integer>();
	}//ListaNumeros
	
	public Iterator<Integer> obtIterator() {
		return listaNumeros.iterator();
	}//obtIterator

	public boolean estaNumero(int pNum) {
		Iterator<Integer> it = this.obtIterator();
		boolean found = false;

		while(it.hasNext() && found == false) {
			if(pNum == (int)it.next()) {
				found = true;
			}//if
		}//while
		return found;
	 }//estaNumero
	
	public void addNumero(int pNum) {
		if(this.estaCompleto() == false) {
			this.listaNumeros.add(pNum);
		}//if
	}//addNumero
	
	public boolean estaCompleto() {
		boolean result = false;
		Iterator<Integer> it = listaNumeros.iterator();
		int counter = 1;
		
		while(it.hasNext() && counter < 6) {
			counter++;
		}//while
		if(counter == 6) {
			result = true;
		}//if
		return result;
	}//estaCompleto
}//ListaNumeros
