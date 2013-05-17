package packComponentes;

import java.io.InputStreamReader;

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
	
	public void addComponente(Artista pComponente) {
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
		try {
			if(componentes.estaArtista(pViejo)) {
				componentesAntiguos.addArtista(pViejo);
				this.eliminarComponente(pViejo);
				this.addComponente(pNuevo);
			}
			else {
				throw(new Exception()); 
			}
		}
		catch {
			System.out.println("No existe ese artista. Introduzca un nuevo artista a reemplazar.");
			Artista pAr = new Artista(null, pViejo.getNombre(), pViejo.getTipo());
			
			
			reemplazarIntegrante(null,pNuevo);
		}
	}
	
	
	
	
	
	
	
	

}
