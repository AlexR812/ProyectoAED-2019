package servidor;

public class Registro {
	protected int capacidad;
	protected int contador;
	protected CampoDefinicion primero;
	protected CampoDefinicion ultimo;
	protected String registroID;
	
	public Registro(int capacidad) {
		this.capacidad = capacidad;
		this.primero = this.ultimo = null;
		this.registroID = null;
	}
	
	public CampoDefinicion getCampo(String nombre) {
		CampoDefinicion temp = this.primero;
		while(!temp.getNombre().equals(nombre)) {
			temp = temp.getSiguiente();
		}
		return temp;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public int contador() {
		return this.contador;
	}
	
	public void agregarCampo(CampoDefinicion campo) throws Exception {
		if(this.contador == this.capacidad) {
			throw new Exception("Registro Lleno");
		}
		else if(this.primero == null) {
			this.primero = this.ultimo = campo;
			this.contador++;
		}
		else {
			CampoDefinicion temp = this.ultimo;
			this.ultimo = campo;
			temp.setSiguiente(this.ultimo);
			this.ultimo.setSiguiente(null);
			this.contador++;
		}
	}
	
	public void eliminar() {
		this.primero = this.ultimo = null;
		this.contador = 0;
	}
	
	public void setRegistroID(String id) {
		this.registroID = id;
	}
	
	public String getRegistroId() {
		return this.registroID;
	}
	
	public CampoDefinicion actualizar(String nombreCamp) {
		CampoDefinicion temp = this.primero;
		while(!temp.getNombre().equals(nombreCamp)) {
			temp = temp.getSiguiente();
		}
		return temp;
	}
	
	public void eliminarCampo(String nombre) {
		CampoDefinicion temp1 = this.primero;
		CampoDefinicion temp2 = null, temp3 = null;
		while(temp1.getNombre().equals(nombre)) {
			temp2 = temp1;
			temp1 = temp1.getSiguiente();
		}
		if(temp1.getSiguiente() == null) {
			this.ultimo = temp2;
			temp2.setSiguiente(null);
			temp1 = null;
			temp1.setSiguiente(null);
		}
		else {
			temp3 = temp1.getSiguiente();
			//temp2.setSiguiente(temp3);
			temp1 = null;
			//temp1.setSiguiente(null);
		}
	}
	
	public void display() throws Exception {
		if(this.primero == null) {
			throw new Exception("Registro vacio");
		}
		else {
			int registro = 0;
			CampoDefinicion temp = this.primero;
			while(temp != null) {
				if(registro == 0) {
					System.out.print(this.getRegistroId());
					registro++;
				}
				else {
					System.out.print("\t" + temp.getDato());
					//System.out.print(temp.getDato());
					temp = temp.getSiguiente();
				}
			}
		}
	}
	    
	public void displayDescripcion() throws Exception {
		if(this.primero == null) {
			throw new Exception("Registro vacio");
		}
		else {
			CampoDefinicion temp = this.primero;
			while(temp != null) {
				System.out.print(temp.getNombre() + " ");
				temp = temp.getSiguiente();
			}
		}
	}
}