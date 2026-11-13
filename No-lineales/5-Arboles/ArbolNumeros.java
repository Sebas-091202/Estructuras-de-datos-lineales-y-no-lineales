import java.util.Scanner;

public class ArbolNumeros {

    // Nodo de un árbol binario: máximo 2 hijos
    static class Nodo {
        int valor;
        Nodo izquierdo; // aquí van los números menores
        Nodo derecho;   // aquí van los números mayores

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Insertar: si es menor va a la izquierda, si es mayor a la derecha
    static Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor); // encontramos un espacio vacío
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else {
            nodo.derecho = insertar(nodo.derecho, valor);
        }
        return nodo;
    }

    // Recorrido inorden: izquierda -> nodo -> derecha (queda ordenado)
    static void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    // Buscar un número bajando por el árbol y mostrando el camino
    static boolean buscar(Nodo raiz, int valor) {
        Nodo actual = raiz;
        System.out.print("Camino: ");

        while (actual != null) {
            System.out.print(actual.valor + " ");

            if (valor == actual.valor) {
                return true;
            } else if (valor < actual.valor) {
                actual = actual.izquierdo; // bajar a la izquierda
            } else {
                actual = actual.derecho;   // bajar a la derecha
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo raiz = null; // el árbol empieza vacío

        System.out.print("¿Cuántos números vas a insertar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Número " + i + ": ");
            int numero = Integer.parseInt(sc.nextLine());
            raiz = insertar(raiz, numero);
        }

        if (raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        // Mostrar resultados
        System.out.println("\nRaíz del árbol: " + raiz.valor);
        System.out.print("Números ordenados (inorden): ");
        inorden(raiz);
        System.out.println();

        // Buscar un número
        System.out.print("\nNúmero a buscar: ");
        int buscado = Integer.parseInt(sc.nextLine());

        if (buscar(raiz, buscado)) {
            System.out.println("-> encontrado");
        } else {
            System.out.println("-> no está en el árbol");
        }
    }
}
