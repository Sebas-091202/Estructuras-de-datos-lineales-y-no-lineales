import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RedSocial {

    // Lista de adyacencia: cada persona (nodo) tiene su lista de amigos (conexiones)
    static LinkedHashMap<String, ArrayList<String>> red = new LinkedHashMap<>();

    static void agregarPersona(String nombre) {
        red.put(nombre, new ArrayList<>());
    }

    // La amistad va en los dos sentidos (grafo no dirigido)
    static void agregarAmistad(String a, String b) {
        red.get(a).add(b);
        red.get(b).add(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nodos: las personas
        agregarPersona("Ana");
        agregarPersona("Luis");
        agregarPersona("Carlos");
        agregarPersona("Maria");
        agregarPersona("Pedro");

        // Aristas: las amistades
        agregarAmistad("Ana", "Luis");
        agregarAmistad("Ana", "Carlos");
        agregarAmistad("Luis", "Maria");
        agregarAmistad("Carlos", "Maria");
        agregarAmistad("Maria", "Pedro");

        // Mostrar todo el grafo
        System.out.println("Red social (persona -> amigos):");
        for (String persona : red.keySet()) {
            System.out.println(persona + " -> " + red.get(persona));
        }

        // Consultar una persona
        System.out.print("\nEscribe un nombre (ej: Ana): ");
        String nombre = sc.nextLine();

        if (!red.containsKey(nombre)) {
            System.out.println("Esa persona no está en la red");
            return;
        }

        ArrayList<String> amigos = red.get(nombre);
        System.out.println("Amigos de " + nombre + ": " + amigos);

        // Sugerencias: amigos de mis amigos que todavía no son mis amigos
        ArrayList<String> sugerencias = new ArrayList<>();

        for (String amigo : amigos) {
            for (String amigoDeAmigo : red.get(amigo)) {
                boolean soyYo = amigoDeAmigo.equals(nombre);
                boolean yaEsAmigo = amigos.contains(amigoDeAmigo);
                boolean yaSugerido = sugerencias.contains(amigoDeAmigo);

                if (!soyYo && !yaEsAmigo && !yaSugerido) {
                    sugerencias.add(amigoDeAmigo);
                }
            }
        }

        System.out.println("Personas que quizá conozcas: " + sugerencias);
    }
}
