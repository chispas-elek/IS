//Author --> Esteban García, Asier

package packListaBoletos;
import packBombonera.ListaNumeros;
//import java.util.Vector;
import java.util.Iterator;

public class Boleto {
	
		//Variables
	//private static int numBoletos = 1;
	private int identificador,telefono;
	private String nombre,direccion;
	private ListaNumeros listaNumeros;
	
	
		//Methods
	public Boleto(int pIdentificador, int pTelefono, String pNombre, String pDireccion, ListaNumeros pListaNumeros) {
		this.identificador = pIdentificador;
		this.telefono = pTelefono;
		this.nombre = pNombre;
		this.direccion = pDireccion;
		this.listaNumeros = pListaNumeros;
	}//Boleto
	
	public void rellenar(ListaNumeros pListaNumeros) {
		Iterator<Integer> it = pListaNumeros.obtIterator();
		
		//Methods
		while(it.hasNext() && listaNumeros.estaCompleto() == false) {
			this.listaNumeros.addNumero((int)it.next());
		}//while
	}//rellenar
	
	public int obtNumeroAciertos(ListaNumeros pListaNumeros) {
		int aciertos = 0;
		Iterator<Integer> it = this.listaNumeros.obtIterator();
		
		//Methods
		while(it.hasNext()) {
			if(pListaNumeros.estaNumero((int)it.next())) {
				aciertos++;
			}//if
		}//while
		return aciertos;
	}//obtNumeroAciertos
}//Boleto
