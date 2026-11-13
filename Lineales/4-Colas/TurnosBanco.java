import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TurnosBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        String opcion = "";

        while (!opcion.equals("4")) {
            System.out.println("\n--- TURNOS DEL BANCO ---");
            System.out.println("Personas en la fila: " + fila.size());
            System.out.println("1. Llega un cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver fila");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del cliente: ");
                    fila.add(sc.nextLine()); // entra al FINAL de la fila
                    break;

                case "2":
                    if (fila.isEmpty()) {
                        System.out.println("No hay clientes en espera");
                    } else {
                        String atendido = fila.poll(); // sale el PRIMERO que llegó
                        System.out.println("Atendiendo a: " + atendido);
                    }
                    break;

                case "3":
                    System.out.println("Fila (primero ... último): " + fila);
                    break;

                case "4":
                    System.out.println("Banco cerrado");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
