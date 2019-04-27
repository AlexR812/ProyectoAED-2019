package servidor;
import nodoEspecial.NodoTabla;

public class Tabla {
	protected int contador;
	protected NodoTabla primerReg;
	protected NodoTabla ultimoReg;
	
	public Tabla() {
		this.contador = 0;
		this.primerReg = this.ultimoReg = null;
	}
	
	public void crear(Registro listaCampos) {
		NodoTabla listaC = new NodoTabla(listaCampos);
		this.primerReg = listaC;
	}
	
	public void agregarCampo(CampoDefinicion campoNuev) {
		try {
			this.primerReg.getRegistro().agregarCampo(campoNuev);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public CampoDefinicion modificarCampo(String nombre) {
		NodoTabla temp = this.primerReg;
		return temp.getRegistro().getCampo(nombre);
	}
	
	public void eliminarCampo(String nombre) {
		int total = 0;
		NodoTabla temp = this.primerReg;
		while(total != this.contador) {
			temp.getRegistro().eliminarCampo(nombre);
			temp = temp.getSiguiente();
			total++;
		}
	}
	
	public void agregarRegistro(Registro nuevoReg) {
		if(this.primerReg.getSiguiente() == null) {
			this.contador++;
			String id = this.contador + "";
			nuevoReg.setRegistroID(id);
			NodoTabla nuevo = new NodoTabla(nuevoReg);
			
			this.primerReg.setSiguiente(nuevo);
			this.ultimoReg = nuevo;
		}
		else {
			this.contador++;
			String id = this.contador + "";
			nuevoReg.setRegistroID(id);
			NodoTabla nuevo = new NodoTabla(nuevoReg);
			
			NodoTabla temp = this.ultimoReg;
			this.ultimoReg = nuevo;
			temp.setSiguiente(this.ultimoReg);
			this.ultimoReg.setSiguiente(null);
		}
	}
	
	public void eliminarRegistro(String id) throws Exception {
		if(this.primerReg.getSiguiente() == null) {
			throw new Exception("Tabla Vacia");
		}
		else {
			NodoTabla temp1 = this.primerReg.getSiguiente();
			NodoTabla temp2 = null, temp3 = null;
			while(!temp1.getRegistro().getRegistroId().equals(id)) {
				temp2 = temp1;
				temp1 = temp1.getSiguiente();
			}
			if(temp1.getSiguiente() != null) {
				temp3 = temp1.getSiguiente();
				temp2.setSiguiente(temp3);
				temp1.getRegistro().eliminar();
				this.contador--;
				
			}
			else {
				this.ultimoReg = temp2;
				this.ultimoReg.setSiguiente(null);
				temp1.getRegistro().eliminar();
				this.contador--;
			}
			
		}
	}
	
	public Registro getRegistro(String id) {
		NodoTabla temp = this.primerReg.getSiguiente();
		while(!temp.getRegistro().getRegistroId().equals(id)) {
			temp = temp.getSiguiente();
		}
		return temp.getRegistro();
	}
	
	public void display() throws Exception {
		if(this.primerReg == null) {
			throw new Exception("Tabla Vacia");
		}
		else {
			NodoTabla temp = this.primerReg;
			while(temp != null) {
				if(temp == this.primerReg) {
					temp.getRegistro().displayDescripcion();
					System.out.println("");
				}
				else {
					temp.getRegistro().display();
					System.out.println("");
				}
				temp = temp.getSiguiente();
			}
		}
	}
}
