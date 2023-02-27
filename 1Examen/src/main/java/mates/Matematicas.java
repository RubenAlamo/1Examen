package mates;
public class Matematicas{

    public static void main(String[] args) {
        // declarar variables
        int puntosTotales = 1000000;
        int count = 0;
        int areaCuadrado = 4;
        // bucle que genera los puntos aleatorios
    }

    public static double generarNumeroPi(int puntosTotales) {
        // declarar variables
        double count = 0;
        int areaCuadrado = 4;
        double pi;
        // bucle que genera los puntos aleatorios
        for (int i = 0; i < puntosTotales; i++) {
            double x = Math.random();
            double y = Math.random();
            // para saber si el punto esta dentro o fuera del circulo
            if (x * x + y * y <= 1) {
                count++;
            }
        }
        // calcular el valor de pi
        pi = (count / puntosTotales) * areaCuadrado;
        return pi;
    }
}
