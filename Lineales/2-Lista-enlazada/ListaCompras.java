import java.util.Scanner;

public class ListaCompras {

    // Cada nodo guarda un producto y apunta al siguiente nodo
    static class Nodo {
        String producto;
        Nodo siguiente;

        Nodo(String producto) {
            this.producto = producto;
            this.siguiente = null; // al crearlo no apunta a nadie
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo cabeza = null; // primer nodo de la lista (al inicio está vacía)

        System.out.println("Escribe los productos de tu lista (escribe 'fin' para terminar)");

        String texto = "";
        while (!texto.equalsIgnoreCase("fin")) {
            System.out.print("Producto: ");
            texto = sc.nextLine();

            if (!texto.equalsIgnoreCase("fin")) {
                Nodo nuevo = new Nodo(texto);

                if (cabeza == null) {
                    cabeza = nuevo; // la lista estaba vacía: el nuevo es el primero
                } else {
                    // Caminar hasta el último nodo
                    Nodo ultimo = cabeza;
                    while (ultimo.siguiente != null) {
                        ultimo = ultimo.siguiente;
                    }
                    ultimo.siguiente = nuevo; // el último ahora apunta al nuevo
                }
            }
        }

        // Recorrer la lista desde la cabeza e imprimir cada producto
        System.out.println("\nTu lista de compras:");
        Nodo actual = cabeza;
        int contador = 0;

        while (actual != null) {
            System.out.print(actual.producto + " -> ");
            actual = actual.siguiente; // pasar al siguiente nodo
            contador++;
        }
        System.out.println("null");

        System.out.println("Total de productos: " + contador);
    }
}
