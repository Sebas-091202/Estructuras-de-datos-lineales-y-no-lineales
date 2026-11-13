import java.util.Scanner;

public class PromedioNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arreglo de tamaño fijo: caben 5 notas
        double[] notas = new double[5];

        // Pedir las notas y guardarlas por posición
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Escribe la nota " + (i + 1) + " (usa punto, ej: 3.5): ");
            notas[i] = Double.parseDouble(sc.nextLine());
        }

        // Calcular la suma, la nota mayor y la menor
        double suma = 0;
        double mayor = notas[0];
        double menor = notas[0];

        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];

            if (notas[i] > mayor) {
                mayor = notas[i];
            }
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        double promedio = suma / notas.length;
        promedio = Math.round(promedio * 100) / 100.0; // redondear a 2 decimales

        // Mostrar el arreglo con sus posiciones
        System.out.println("\nNotas guardadas en el arreglo:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Posición " + i + " -> " + notas[i]);
        }

        // Resultado
        System.out.println("Promedio: " + promedio);
        System.out.println("Nota más alta: " + mayor);
        System.out.println("Nota más baja: " + menor);
    }
}
