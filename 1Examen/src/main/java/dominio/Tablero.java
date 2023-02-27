package dominio;
public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void generarEstadoActualPorMontecarlo() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (int) (Math.random() * 2);
            }
        }
    }
    public int contarVecinosVivos(int i, int j){
        int vecinosVivos = 0;
        for (i = 0; i < DIMENSION; i++) {
            for (j = 0; j < DIMENSION; j++) {
                if (i > 0 && j > 0 && estadoActual[i - 1][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (i > 0 && estadoActual[i - 1][j] == 1) {
                    vecinosVivos++;
                }
                if (i > 0 && j < DIMENSION - 1 && estadoActual[i - 1][j + 1] == 1) {
                    vecinosVivos++;
                }
                if (j > 0 && estadoActual[i][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (j < DIMENSION - 1 && estadoActual[i][j + 1] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && j > 0 && estadoActual[i + 1][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && estadoActual[i + 1][j] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && j < DIMENSION - 1 && estadoActual[i + 1][j + 1] == 1) {
                    vecinosVivos++;
                }
            }
        }
        return vecinosVivos;
    }

    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinosVivos = contarVecinosVivos(i, j);
                if (vecinosVivos == 3) {
                    estadoSiguiente[i][j] = 1;
                } else if (vecinosVivos == 2) {
                    estadoSiguiente[i][j] = estadoActual[i][j];
                } else {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                resultado += estadoActual[i][j] + " ";
            }
            resultado += "" ;

        }
        return resultado;
    }
}