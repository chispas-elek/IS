package packComponentes;

public class Entrada {
	
	//Variables
	private int idEntrada;
	private float precio;
	
	public Entrada(float pPrecio) {
		this.idEntrada = (int)System.currentTimeMillis();
		this.precio = pPrecio;
	}
	
	public int getIdEntrada() {
		return this.idEntrada;
	}
	
	public float getPrecio() {
		return this.precio;
	}
}
