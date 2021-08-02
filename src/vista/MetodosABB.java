package vista;

public class MetodosABB {

	Nodo raiz;

	public MetodosABB() {
		this.raiz = null;
	}

	//INSERTAR UN NODO DE MANERA RECURSIVA
	public void insertarNodo(int num, Nodo actual) {
		Nodo nuevo = new Nodo(num);
		if (raiz == null) {
			raiz = nuevo;
		} else if (actual == null) {
			System.out.println("El origen es nulo! \n");
		} else {
			if (nuevo.getValor() >= actual.getValor()) {
				if (actual.getDerecha() != null) {
					actual = actual.getDerecha();
					insertarNodo(num, actual);
				} else {
					nuevo.setPadre(actual);
					actual.setDerecha(nuevo);
				}

			} else {
				if (actual.getIzquierda() != null) {
					actual = actual.getIzquierda();
					insertarNodo(num, actual);
				} else {
					nuevo.setPadre(actual);
					actual.setIzquierda(nuevo);
				}
			}
		}
	}
	
	public Nodo buscarNodo(int valor) {
		Nodo actual = raiz;
		while (actual != null) {
			if (actual.getValor() >= valor) {
				actual = actual.getDerecha();
			} else {
				actual = actual.getIzquierda();
			}
			if (actual == null) {
				return null;
			}
		}
		return actual;
	}

	public void eliminarNodo(int valor) {
		Nodo actual = raiz;
		Nodo padre = raiz;
		boolean hijoIzq = true;
		
		//ENCONTRAR UNA COINCIDENCIA CON LOS VALORES DEL ARBOL
		while (actual.getValor() != valor) {
			padre = actual;
			if (valor < actual.getValor()) {
				hijoIzq = true;
				actual = actual.getIzquierda();
			} else {
				hijoIzq = false;
				actual = actual.getDerecha();
			}
			if (actual == null) {
				System.out.println("El nodo no se encuentra en el arbol");
				System.out.println("");
			}
		}
		
		//ELIMINAR EL NODO CUANDO IZQUIERDA Y DERECHA APUNTEN A NULL
		if (actual.getIzquierda() == null && actual.getDerecha() == null) {
			if (actual == raiz) {
				raiz = null;
			} else if (hijoIzq) {
				padre.setIzquierda(null);
			} else {
				padre.setDerecha(null);
			}
			
			//ELIMINAR UN NODO CUANDO SOLO DERECHA APUNTE A NULL
		} else if (actual.getDerecha() == null && actual.getIzquierda() != null) {
			if (actual == raiz) {
				raiz = actual.getIzquierda();
			} else if (hijoIzq) {
				padre.setIzquierda(actual.getIzquierda());
			} else {
				padre.setDerecha(actual.getIzquierda());
			}
			
			//ELIMINAR UN NODO CUANDO SOLO IZQUIERDA APUNTE A NULL
		} else if (actual.getIzquierda() == null && actual.getDerecha() != null) {
			if (actual == raiz) {
				raiz = actual.getDerecha();
			} else if (hijoIzq) {
				padre.setIzquierda(actual.getDerecha());
			} else {
				padre.setDerecha(actual.getIzquierda());
			}
			
			//ELIMINAR UN NODO CUANDO NINGUNO APUNTE A NULL
		} else {
			//LLMAR AL METODO QUE VA A BUSCAR EL NODO CON EL CUAL VAMOS A REEMPLAZAR
			Nodo reemplazo = obtenerNodoReemplazo(actual);
			if (actual == raiz) {
				raiz = reemplazo;
			} else if (hijoIzq) {
				padre.setIzquierda(reemplazo);
			} else {
				padre.setDerecha(reemplazo);
			}
			reemplazo.setIzquierda(actual.getIzquierda());
			System.out.println("Nodo eliminado! ");
			System.out.println("");
		}
	}


	//metodo encargado de devolvernos el nodo reemplazo
	private Nodo obtenerNodoReemplazo(Nodo actual) {
		Nodo reemplazarPadre = actual;
		Nodo reemplazo = actual;
		Nodo auxiliar = actual.getDerecha();

		while (auxiliar != null) {
			reemplazarPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar = auxiliar.getIzquierda();
		}
		if (reemplazo != actual.getDerecha()) {
			reemplazarPadre.setIzquierda(reemplazo.getDerecha());
			reemplazo.setDerecha(actual.getDerecha());
		}
		//System.out.println("El nodo reemplazo es: " + reemplazo.getValor());
		return reemplazo;
	}

	public void listarPreOrder(Nodo actual) {
		if (actual != null) {
			System.out.println("Valor: " + actual.getValor());
			listarInOrder(actual.getIzquierda());
			listarInOrder(actual.getDerecha());
		}
	}

	public void listarInOrder(Nodo actual) {
		if (actual != null) {
			listarInOrder(actual.getIzquierda());
			System.out.println("Valor: " + actual.getValor());
			listarInOrder(actual.getDerecha());
		}
	}

	public void listarPosOrder(Nodo actual) {
		if (actual != null) {
			listarInOrder(actual.getIzquierda());
			listarInOrder(actual.getDerecha());
			System.out.println("Valor: " + actual.getValor());
		}
	}
}
