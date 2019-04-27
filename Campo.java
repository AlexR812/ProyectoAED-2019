package servidor;

public class Campo {
	protected Campo siguiente;
	protected Object dato;
	
	public Campo(Object dato) {
		this.dato = dato;
	}
	
	public Campo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Campo siguiente) {
		this.siguiente = siguiente;
	}

	public Object getDato() {
		return dato;
	}
	
	public void setDato(Object dato) {
		this.dato = dato;
	}
}
