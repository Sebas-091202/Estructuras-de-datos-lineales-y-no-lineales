import java.util.ArrayList;

public class ArbolCarpetas {

    // Cada nodo es una carpeta que puede tener varias carpetas hijas
    static class Carpeta {
        String nombre;
        ArrayList<Carpeta> hijos = new ArrayList<>();

        Carpeta(String nombre) {
            this.nombre = nombre;
        }

        void agregar(Carpeta hija) {
            hijos.add(hija);
        }
    }

    // Mostrar el árbol: primero la carpeta y luego sus hijas con más sangría
    static void mostrar(Carpeta carpeta, int nivel) {
        String sangria = "    ".repeat(nivel); // 4 espacios por cada nivel
        System.out.println(sangria + "|-- " + carpeta.nombre);

        for (Carpeta hija : carpeta.hijos) {
            mostrar(hija, nivel + 1); // recursión: el método se llama a sí mismo
        }
    }

    // Contar todas las carpetas del árbol
    static int contar(Carpeta carpeta) {
        int total = 1; // cuenta esta carpeta
        for (Carpeta hija : carpeta.hijos) {
            total = total + contar(hija); // más las carpetas de cada hija
        }
        return total;
    }

    public static void main(String[] args) {
        // Raíz del árbol
        Carpeta raiz = new Carpeta("Disco C:");

        // Hijos de la raíz
        Carpeta usuarios = new Carpeta("Usuarios");
        Carpeta programas = new Carpeta("Archivos de programa");
        raiz.agregar(usuarios);
        raiz.agregar(programas);

        // Hijos de "Usuarios"
        Carpeta documentos = new Carpeta("Documentos");
        Carpeta descargas = new Carpeta("Descargas");
        usuarios.agregar(documentos);
        usuarios.agregar(descargas);

        // Más carpetas
        documentos.agregar(new Carpeta("Tareas"));
        programas.agregar(new Carpeta("Java"));
        programas.agregar(new Carpeta("VS Code"));

        // Resultado
        System.out.println("Estructura de carpetas:");
        mostrar(raiz, 0);

        System.out.println("\nRaíz: " + raiz.nombre);
        System.out.println("Hijos directos de la raíz: " + raiz.hijos.size());
        System.out.println("Total de carpetas: " + contar(raiz));
    }
}
