import java.util.Scanner;

public class BuscarEnArreglo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arreglo con datos ya cargados (tamaño fijo: 6 frutas)
        String[] frutas = {"Manzana", "Pera", "Banano", "Uva", "Mango", "Fresa"};

        // Mostrar el arreglo con sus posiciones
        System.out.println("Frutas en el arreglo:");
        for (int i = 0; i < frutas.length; i++) {
            System.out.println("[" + i + "] " + frutas[i]);
        }

        // 1) Acceso directo por posición
        System.out.print("\nEscribe una posición (0 a " + (frutas.length - 1) + "): ");
        int posicion = Integer.parseInt(sc.nextLine());

        if (posicion >= 0 && posicion < frutas.length) {
            System.out.println("En la posición " + posicion + " está: " + frutas[posicion]);
        } else {
            System.out.println("Esa posición no existe en el arreglo");
        }

        // 2) Búsqueda: recorrer el arreglo hasta encontrar la fruta
        System.out.print("\nEscribe una fruta para buscar: ");
        String buscada = sc.nextLine();

        int encontrada = -1; // -1 significa "no la encontré"

        for (int i = 0; i < frutas.length; i++) {
            if (frutas[i].equalsIgnoreCase(buscada)) {
                encontrada = i;
                break; // ya la encontré, dejo de buscar
            }
        }

        // Resultado
        if (encontrada != -1) {
            System.out.println(buscada + " está en la posición " + encontrada);
        } else {
            System.out.println(buscada + " no está en el arreglo");
        }
    }
}
