package servidor;

public class CampoDefinicion {
	protected String nombre;
	protected String descripcion;
	protected String tipoDato;
	protected CampoDefinicion siguiente;
	protected Object dato;
	
	public CampoDefinicion() {
		this.nombre = null;
		this.descripcion = null;
		this.tipoDato = null;
		
	}
	
	public void crear(Object dato) {
		this.dato = dato;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	public CampoDefinicion getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(CampoDefinicion siguiente) {
		this.siguiente = siguiente;
	}
	
	public Object getDato() {
		return this.dato;
	}
}