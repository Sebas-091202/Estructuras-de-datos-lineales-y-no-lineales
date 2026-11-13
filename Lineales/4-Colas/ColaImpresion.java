import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ColaImpresion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> cola = new LinkedList<>();

        System.out.print("¿Cuántos documentos vas a enviar a la impresora? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        // Encolar: cada documento entra al final de la cola
        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Nombre del documento " + i + ": ");
            cola.add(sc.nextLine());
        }

        System.out.println("\nCola de impresión: " + cola);
        System.out.println("Imprimiendo en orden de llegada...\n");

        // Desencolar: sale primero el que llegó primero
        int numero = 1;
        while (!cola.isEmpty()) {
            String documento = cola.poll();
            System.out.println(numero + ". Imprimiendo: " + documento + "   (quedan " + cola.size() + ")");
            numero++;
        }

        System.out.println("\nTodos los documentos fueron impresos");
    }
}
