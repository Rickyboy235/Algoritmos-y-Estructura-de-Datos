import java.util.Scanner;

public class Insertar {

    static final int MAX = 6;
    static int[] arreglo = new int[MAX];
    static int[] copia = new int[MAX];
    static boolean[] ocupado = new boolean[MAX];
    static int longActual = 0;

    static int leerInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero valido: ");
            }
        }
    }

    static void insertar(Scanner sc) {
        if (longActual >= MAX) {
            System.out.println("El arreglo esta lleno.");
            return;
        }

        System.out.print("Ingrese el numero: ");
        int numero = leerInt(sc);

        System.out.print("Ingrese la posicion (0 a " + (MAX - 1) + "): ");
        int pos = leerInt(sc);

        if (pos < 0 || pos >= MAX) {
            System.out.println("Posicion invalida.");
            return;
        }

        if (!ocupado[pos]) {
            arreglo[pos] = numero;
            ocupado[pos] = true;
            longActual++;
            System.out.println("Insertado en posicion " + pos);
            return;
        }

        if (ocupado[MAX - 1]) {
            System.out.println("No hay espacio para desplazar.");
            return;
        }

        for (int i = MAX - 2; i >= pos; i--) {
            if (ocupado[i]) {
                arreglo[i + 1] = arreglo[i];
                ocupado[i + 1] = true;
            } else {
                ocupado[i + 1] = false;
            }
        }

        arreglo[pos] = numero;
        ocupado[pos] = true;
        longActual++;

        System.out.println("Insertado con desplazamiento en posicion " + pos);
    }

    static void actualizar(Scanner sc) {
        if (longActual == 0) {
            System.out.println("El arreglo esta vacio.");
            return;
        }

        recorrer();

        System.out.print("Ingrese posicion a actualizar (0 a " + (MAX - 1) + "): ");
        int pos = leerInt(sc);

        if (pos < 0 || pos >= MAX || !ocupado[pos]) {
            System.out.println("Posicion invalida o vacia.");
            return;
        }

        System.out.print("Nuevo valor: ");
        int nuevo = leerInt(sc);

        arreglo[pos] = nuevo;
        System.out.println("Actualizado correctamente.");
    }

    static void recorrer() {
        System.out.println("\n--- Arreglo ---");
        for (int i = 0; i < MAX; i++) {
            if (ocupado[i]) {
                System.out.println("Indice " + i + ": " + arreglo[i]);
            } else {
                System.out.println("Indice " + i + ": [vacio]");
            }
        }
        System.out.println("Elementos usados: " + longActual + "/" + MAX);
    }

    static void copiar() {
        for (int i = 0; i < MAX; i++) {
            copia[i] = arreglo[i];
        }

        System.out.println("\n--- Copia realizada ---");
        for (int i = 0; i < MAX; i++) {
            System.out.println("Original: " + arreglo[i] + " | Copia: " + copia[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Recorrer");
            System.out.println("4. Copiar");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            op = leerInt(sc);

            switch (op) {
                case 1:
                    insertar(sc);
                    break;
                case 2:
                    actualizar(sc);
                    break;
                case 3:
                    recorrer();
                    break;
                case 4:
                    copiar();
                    break;
                case 5:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (op != 5);

        sc.close();
    }
}