import java.util.Scanner;

public class MapaCiudades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nodos del grafo: las ciudades
        String[] ciudades = {"Medellin", "Bogota", "Cali", "Pereira", "Manizales"};

        // Matriz de adyacencia: km[i][j] = distancia entre la ciudad i y la ciudad j
        // 0 significa que NO hay carretera directa (distancias aproximadas)
        int[][] km = {
            //  Med  Bog  Cal  Per  Man
            {    0, 415,   0, 215, 195 }, // Medellin
            {  415,   0, 460, 320, 290 }, // Bogota
            {    0, 460,   0, 215,   0 }, // Cali
            {  215, 320, 215,   0,  55 }, // Pereira
            {  195, 290,   0,  55,   0 }  // Manizales
        };

        // Mostrar las conexiones de cada ciudad
        System.out.println("Rutas directas:");
        for (int i = 0; i < ciudades.length; i++) {
            System.out.print(ciudades[i] + " -> ");
            for (int j = 0; j < ciudades.length; j++) {
                if (km[i][j] > 0) {
                    System.out.print(ciudades[j] + " (" + km[i][j] + " km)  ");
                }
            }
            System.out.println();
        }

        // Elegir origen y destino
        System.out.println("\nCiudades:");
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println(i + ". " + ciudades[i]);
        }

        System.out.print("Número de la ciudad de origen: ");
        int origen = Integer.parseInt(sc.nextLine());
        System.out.print("Número de la ciudad de destino: ");
        int destino = Integer.parseInt(sc.nextLine());

        // Validar los números
        if (origen < 0 || origen >= ciudades.length || destino < 0 || destino >= ciudades.length) {
            System.out.println("Número de ciudad no válido");
            return;
        }
        if (origen == destino) {
            System.out.println("Ya estás en " + ciudades[origen]);
            return;
        }

        System.out.println("\n" + ciudades[origen] + " -> " + ciudades[destino]);

        if (km[origen][destino] > 0) {
            System.out.println("Hay ruta directa: " + km[origen][destino] + " km");
        } else {
            System.out.println("No hay ruta directa");

            // Buscar una ciudad intermedia k: origen -> k -> destino
            for (int k = 0; k < ciudades.length; k++) {
                if (km[origen][k] > 0 && km[k][destino] > 0) {
                    int total = km[origen][k] + km[k][destino];
                    System.out.println("Puedes ir por " + ciudades[k] + ": " + total + " km");
                }
            }
        }
    }
}
