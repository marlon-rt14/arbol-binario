
package vista;


public class Nodo{
	
	private int valor;
	private Nodo padre;
	private Nodo izquierda;
	private Nodo derecha;
	
	public Nodo(int valor){
		this.valor = valor;
		this.padre = null;
		this.izquierda = null;
		this.derecha = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Nodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}

	public Nodo getDerecha() {
		return derecha;
	}

	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	
	
	
}
