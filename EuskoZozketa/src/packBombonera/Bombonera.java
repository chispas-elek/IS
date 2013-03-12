//Author --> Esteban García, Asier

package packBombonera;
import packBombonera.ListaNumeros;
import java.util.Iterator;

public class Bombonera {

		//Variables
	private static Bombonera mBombonera = null;
	
	
		//Methods
	private Bombonera() {
		
	}//Bombonera
	
	public static Bombonera getBombonera() {
		if (mBombonera == null) {
			mBombonera = new Bombonera();
		}//if
		return mBombonera;
	}//getBombonera
		
	public ListaNumeros realizarSorteo() {
		ListaNumeros boletoGanador = new ListaNumeros();
		Iterator<Integer> it = boletoGanador.obtIterator();
		
		while(it.hasNext() && boletoGanador.estaCompleto() == false) {
			boletoGanador.addNumero((int)Math.random() * 49);
		}//while
		return boletoGanador;
	}//realizarSorteo
}//Bombonera
