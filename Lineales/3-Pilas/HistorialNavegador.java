import java.util.Scanner;
import java.util.Stack;

public class HistorialNavegador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> historial = new Stack<>();
        String opcion = "";

        while (!opcion.equals("4")) {
            System.out.println("\n--- NAVEGADOR ---");

            // peek(): ver la página de encima sin sacarla
            if (historial.isEmpty()) {
                System.out.println("Página actual: (ninguna)");
            } else {
                System.out.println("Página actual: " + historial.peek());
            }

            System.out.println("1. Visitar página");
            System.out.println("2. Atrás");
            System.out.println("3. Ver historial");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Escribe la página (ej: google.com): ");
                    historial.push(sc.nextLine()); // entra encima de la pila
                    break;

                case "2":
                    if (historial.isEmpty()) {
                        System.out.println("No hay páginas para regresar");
                    } else {
                        String cerrada = historial.pop(); // sale la última que entró
                        System.out.println("Saliste de: " + cerrada);
                    }
                    break;

                case "3":
                    System.out.println("Historial (de arriba hacia abajo):");
                    for (int i = historial.size() - 1; i >= 0; i--) {
                        System.out.println("  " + historial.get(i));
                    }
                    break;

                case "4":
                    System.out.println("Navegador cerrado");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
