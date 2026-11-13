import java.util.Scanner;

public class ListaNumeros {

    // Cada nodo guarda un número y apunta al siguiente nodo
    static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    static Nodo cabeza = null; // primer nodo de la lista

    // Agregar al inicio: el nuevo nodo apunta al que antes era el primero
    static void agregarAlInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Eliminar el primer nodo que tenga ese valor
    static boolean eliminar(int valor) {
        if (cabeza == null) {
            return false; // lista vacía
        }

        // Caso 1: el valor está en el primer nodo
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            return true;
        }

        // Caso 2: buscarlo en el resto de la lista
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente; // "saltar" el nodo a borrar
                return true;
            }
            actual = actual.siguiente;
        }

        return false; // no se encontró
    }

    // Recorrer la lista e imprimirla
    static void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir 5 números y agregarlos al inicio
        for (int i = 1; i <= 5; i++) {
            System.out.print("Número " + i + ": ");
            int numero = Integer.parseInt(sc.nextLine());
            agregarAlInicio(numero);
        }

        System.out.println("\nLista (cada número entró por el inicio):");
        mostrar();

        // Eliminar un número
        System.out.print("\n¿Qué número quieres eliminar? ");
        int borrar = Integer.parseInt(sc.nextLine());

        if (eliminar(borrar)) {
            System.out.println("Se eliminó el " + borrar);
        } else {
            System.out.println("El " + borrar + " no está en la lista");
        }

        System.out.println("Lista final:");
        mostrar();
    }
}
