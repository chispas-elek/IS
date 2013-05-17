package packComponentes;

public class Cancion {

	
	//Variables
	private int numeroPista, duracion, puntuacion;
	private String titulo, compositor;
	private Genero gen;
	
	public Cancion(int pNumeroPista, int pDuracion, int pPuntuacion, String pTitulo, String pCompositor, Genero pGen) {
	 	this.numeroPista = pNumeroPista;
		this.duracion = pDuracion;
		this.puntuacion = pPuntuacion;
		this.titulo = pTitulo;
		this.compositor = pCompositor;
		this.gen = pGen;
	}

	public int getNumeroPistas() {
		return numeroPista;
	}

	public void setNumeroPista(int pNumeroPista) {
		this.numeroPista = pNumeroPista;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int pDuracion) {
		this.duracion = pDuracion;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int pPuntuacion) {
		this.puntuacion = pPuntuacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String pTitulo) {
		this.titulo = pTitulo;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String pCompositor) {
		this.compositor = pCompositor;
	}

	public Genero getGen() {
		return gen;
	}

	public void setGen(Genero pGen) {
		this.gen = pGen;
	}
	
	
	
	

}
