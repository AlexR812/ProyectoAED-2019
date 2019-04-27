package servidor;

public class ListaCampos {
	protected int contador;
	protected CampoDefinicion primero;
	protected CampoDefinicion ultimo;
	
	public ListaCampos() {
		this.contador = 0;
		this.primero = null;
		this.ultimo = null;
	}
	
	public void agregarCampo(CampoDefinicion campoDefinido) {
		if(this.primero == null) {
			this.primero = this.ultimo = campoDefinido;
			this.contador++;
		}
		else {
			CampoDefinicion temp = this.ultimo;
			this.ultimo = campoDefinido;
			this.ultimo.setSiguiente(null);
			temp.setSiguiente(this.ultimo);
			this.contador++;
		}
	}
	
	public int cantidad() {
		return this.contador;
	}
	
	public void display() throws Exception {
		if(this.primero == null) {
			throw new Exception("Lista vacia");
		}
		else {
			CampoDefinicion temp = this.primero;
			while(temp != null) {
				if(temp == this.ultimo) {
					System.out.print(temp.getNombre() + "(fin)");
				}
				else {
					System.out.print(temp.getNombre() + "\t");
				}
				temp = temp.getSiguiente();
			}
		}
		
	}
}
