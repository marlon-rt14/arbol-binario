
package vista;

import java.util.Scanner;

public class ABB {


	public static void main(String[] args) {
		
		MetodosABB arbol = new MetodosABB();
		Scanner dato = new Scanner(System.in);
		
		int op = 0, valor = 0;
		
		do {
			System.out.println("SELECCIONE UNA OPCION DEL MENU");
			System.out.println("1.- Insertar un valor\n"
				+ "2.- Eliminar un nodo\n"
				+ "3.- Listar en PreOrden\n"
				+ "4.- Listar en InOrden\n"
				+ "5.- Listar en PosOrden\n"
				+ "6.- Terminar ejecucion");
			op = dato.nextInt();
			System.out.println("");
			
			switch(op){
				case 1:
					System.out.print("Valor: ");
					valor = dato.nextInt();
					System.out.println("");
					arbol.insertarNodo(valor, arbol.raiz);
					break;
				case 2:
					System.out.print("Valor: ");
					valor = dato.nextInt();
					System.out.println("");
					arbol.eliminarNodo(valor);
					break;
				case 3:
					arbol.listarPreOrder(arbol.raiz);
					System.out.println("");
					break;
				case 4: 
					arbol.listarInOrder(arbol.raiz);
					System.out.println("");
					break;
				case 5:
					arbol.listarPosOrder(arbol.raiz);
					System.out.println("");
					break;
				case 6:
					break;
			}
		} while (op != 6);

		
//		arbol.insertarNodo(8, arbol.raiz);
//		arbol.insertarNodo(4, arbol.raiz);
//		arbol.insertarNodo(10, arbol.raiz);
//		arbol.insertarNodo(12, arbol.raiz);
//		arbol.insertarNodo(1, arbol.raiz);
//		arbol.insertarNodo(11, arbol.raiz);
//		arbol.insertarNodo(15, arbol.raiz);
//		arbol.insertarNodo(14, arbol.raiz);


		
	}
	
}
