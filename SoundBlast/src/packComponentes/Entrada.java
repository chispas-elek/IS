package packComponentes;

public class Entrada {
	
	//Variables
	private int idEntrada;
	private int precio;
	
	public Entrada(int pPrecio) {
		this.idEntrada = (int)System.currentTimeMillis();
		this.precio = pPrecio;
	}
	
	public int getIdEntrada() {
		return this.idEntrada;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}
