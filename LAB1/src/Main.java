public class Main {
    public static void main(String[] args) {

        int[] datos = new int[3];

        datos[0] = 10;
        datos[1] = 20;
        datos[2] = 30;

        int valor = datos[0];

        for(int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
    }
}