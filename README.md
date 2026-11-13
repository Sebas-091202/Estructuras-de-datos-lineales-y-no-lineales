# Estructuras de datos lineales y no lineales

Ejercicios sencillos en **Java** para practicar las estructuras de datos más comunes.
Cada tema tiene su carpeta con un `notas.txt` (explicación y enunciados) y **2 ejercicios**.

## Temas

### Lineales: los datos van uno detrás de otro, en secuencia

| Estructura | Idea principal | Ejercicios |
|---|---|---|
| Arreglo (array) | Tamaño fijo, acceso por posición | `PromedioNotas`, `BuscarEnArreglo` |
| Lista enlazada | Cada elemento apunta al siguiente | `ListaCompras`, `ListaNumeros` |
| Pila (stack) | Último en entrar, primero en salir (LIFO) | `InvertirPalabra`, `HistorialNavegador` |
| Cola (queue) | Primero en entrar, primero en salir (FIFO) | `TurnosBanco`, `ColaImpresion` |

### No lineales: los datos se organizan en jerarquías o conexiones, no en fila

| Estructura | Idea principal | Ejercicios |
|---|---|---|
| Árbol | Jerarquía de padres e hijos (carpetas, menús) | `ArbolCarpetas`, `ArbolNumeros` |
| Grafo | Nodos conectados entre sí (redes sociales, mapas) | `RedSocial`, `MapaCiudades` |

## Estructura del repositorio

```
Estructuras-de-datos-lineales-y-no-lineales/
├── Lineales/
│   ├── 1-Arreglos/
│   ├── 2-Lista-enlazada/
│   ├── 3-Pilas/
│   └── 4-Colas/
└── No-lineales/
    ├── 5-Arboles/
    └── 6-Grafos/
```

## Cómo ejecutar un ejercicio

**Opción 1 - Visual Studio Code:** abre el archivo `.java` y pulsa **Run** (encima del `main`).
Necesitas la extensión *Extension Pack for Java*.

**Opción 2 - Terminal** (Java 11 o superior):

```bash
cd Lineales/1-Arreglos
java PromedioNotas.java
```
