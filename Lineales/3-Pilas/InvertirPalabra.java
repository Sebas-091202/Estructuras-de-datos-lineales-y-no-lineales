import java.util.Scanner;
import java.util.Stack;

public class InvertirPalabra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        // Pedir palabra
        System.out.print("Escribe una palabra: ");
        String palabra = sc.nextLine();

        // Meter cada letra en la pila (push)
        for (char letra : palabra.toCharArray()) {
            pila.push(letra);
        }

        // Sacar las letras (pop): sale primero la última que entró
        String invertida = "";
        while (!pila.isEmpty()) {
            invertida = invertida + pila.pop();
        }

        // Resultado
        System.out.println("Palabra invertida: " + invertida);

        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println("Es un palíndromo (se lee igual al revés)");
        } else {
            System.out.println("No es un palíndromo");
        }
    }
}
