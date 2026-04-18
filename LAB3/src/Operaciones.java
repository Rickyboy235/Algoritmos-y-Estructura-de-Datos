public class Operaciones {
    public static void main(String[] args) {
        
        int[] arreglo1 = {10, 20, 30, 40};
        int[] arreglo2 = {10, 25, 30, 45};
        
        System.out.println("Arreglo 1: ");
        imprimir(arreglo1);
        
        System.out.println("Arreglo 2: ");
        imprimir(arreglo2);
        
        //Comparación
        
        System.out.println("\n--- Comparacion ---");
        for (int i = 0; i < arreglo1.length; i++) {
            
            if (arreglo1[i] == arreglo2[i]) {
                System.out.println("Indice " + i + ": iguales (" + arreglo1[i] + ")");
            } else {
                System.out.println("Indice " + i + ": diferentes ("
                + arreglo1[i] + " vs " + arreglo2[i] + ")");
                System.out.println("Arreglos diferentes");
                break;
            }
            
        }
        
        //Clonación
        
        int[] clon = new int[arreglo1.length];
        for (int i = 0; i < arreglo1.length; i++) {
            clon[i] = arreglo1[i];
        }
        
        System.out.println("\nClon: ");
        imprimir(clon);
        
        //fusion
        
        int[] fusion = new int[arreglo1.length + arreglo2.length];
        
        for (int i = 0; i < arreglo1.length; i++) {
            fusion[i] = arreglo1[i];
        }
        
        for (int i = 0; i < arreglo2.length; i++) {
            fusion[arreglo1.length + i] = arreglo2[i];
        }
        
        System.out.println("\nArreglo fusionado: ");
        imprimir(fusion);
    }
    
    public static void imprimir(int[] arreglo) {
        System.out.println("[ ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i] + " ");
        }
        System.out.println("]");
    }
}

