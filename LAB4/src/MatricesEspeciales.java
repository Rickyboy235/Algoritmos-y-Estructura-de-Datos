public class MatricesEspeciales {

    static class MatrizDiagonal {
        int[] diag;

        MatrizDiagonal(int[] diag) {
            this.diag = diag;
        }

        int get(int i, int j) {
            return (i == j) ? diag[i] : 0;
        }

        int size() {
            return diag.length;
        }
    }

    static class MatrizDispersa {
        int[][] datos;

        MatrizDispersa(int[][] datos) {
            this.datos = datos;
        }

        int get(int i, int j) {
            for (int[] d : datos) {
                if (d[0] == i && d[1] == j) return d[2];
            }
            return 0;
        }
    }

    static int[][] suma(int[][] A, int[][] B) {
        int[][] R = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                R[i][j] = A[i][j] + B[i][j];
        return R;
    }

    static int[][] multiplicar(int[][] A, int[][] B) {
        int[][] R = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < B.length; k++)
                    R[i][j] += A[i][k] * B[k][j];
        return R;
    }

    static int[][] transponer(int[][] A) {
        int[][] T = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                T[j][i] = A[i][j];
        return T;
    }

    static void imprimir(int[][] M) {
        for (int[] fila : M) {
            for (int val : fila) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("1. Declaración de matrices");

        MatrizDiagonal md = new MatrizDiagonal(new int[]{1, 2, 3});

        int[][] datos = {
            {0, 2, 5},
            {2, 0, 2}
        };
        MatrizDispersa ms = new MatrizDispersa(datos);

        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        System.out.println("\n2. Acceso optimizado");

        for (int i = 0; i < md.size(); i++) {
            for (int j = 0; j < md.size(); j++) {
                System.out.print(md.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ms.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("\n3. Operaciones");

        System.out.println("Suma:");
        imprimir(suma(A, B));

        System.out.println("Multiplicación:");
        imprimir(multiplicar(A, B));

        System.out.println("Transpuesta:");
        imprimir(transponer(A));

        System.out.println("\n4. Verificación");

        int n = 3;
        System.out.println("Normal: " + (n * n));
        System.out.println("Diagonal: " + n);
        System.out.println("Dispersa: " + datos.length);
    }
}