package packComponentes;


public class Grupo {
	
	//Variables
	private String nombre, logo;
	private ListaArtista componentes, componentesAntiguos;
	private ListaDisco discografia;
	
	
	//Methods
	public Grupo(String pNombre, String pLogo, ListaArtista pComponentes, ListaArtista pComponentesAntiguos, ListaDisco pDiscografia) {
		this.nombre = pNombre;
		this.logo = pLogo;
		this.componentes = pComponentes;
		this.componentesAntiguos = pComponentesAntiguos;
		this.discografia = pDiscografia;
	}
	
	public void addIntegrante(Artista pComponente) {
		componentes.addArtista(pComponente);
	}
	
	public void eliminarComponente(Artista pComponente) {
		componentes.eliminarArtista(pComponente);
	}
	
	public Artista getSolista() {
		return componentes.getSolista();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getLogo() {
		return logo;
	}

	public ListaArtista getComponentes() {
		return componentes;
	}

	public ListaArtista getComponentesAntiguos() {
		return componentesAntiguos;
	}

	public ListaDisco getDiscografia() {
		return discografia;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public void setLogo(String pLogo) {
		this.logo = pLogo;
	}
	
	public void reemplazarIntegrante(Artista pViejo, Artista pNuevo) {
		
		if(!this.getComponentes().estaArtista(pViejo)) {
			System.out.println("El artista no existe");
		}
		else {
			ArtistaAntiguo pArt = new ArtistaAntiguo(pViejo);
			componentesAntiguos.addArtista(pArt);
			this.eliminarComponente(pViejo);
			this.addIntegrante(pNuevo);	
		}
	}
	
	public Disco buscarDisco(String pNombre) {
		return discografia.buscarDisco(pNombre);
	}
	
	
	
	
	
	
	
	
	

}
